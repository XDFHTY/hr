package com.cj.hsys.service.impl;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cj.common.mapper.AuthCustomerRoleMapper;
import com.cj.common.mapper.Key64Mapper;
import com.cj.common.service.AuthCustomerRoleService;
import com.cj.core.domain.*;
import com.cj.core.entity.*;
import com.cj.core.exception.MyException;
import com.cj.core.utils.jwt.JwtUtil;
import com.cj.hsys.domain.*;
import com.cj.hsys.mapper.AdminInfoMapper;
import com.cj.hsys.mapper.AdminMapper;
import com.cj.hsys.service.AdminService;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

import static com.cj.core.utils.md5.Md5Utils.MD5Encode;


@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Resource
    private AdminInfoMapper adminInfoMapper;

    @Resource
    private AuthCustomerRoleMapper authCustomerRoleMapper;

    @Resource
    private Key64Mapper key64Mapper;

    @Resource
    private AuthCustomerRoleService authCustomerRoleService;



    Gson gson = new Gson();


//    @Value("${ip.white.list}")
//    private String[] ips;


    //添加账号
    @Override
    public AddAdminResp addAdmin(VoAdmin voAdmin) {
        Admin admin = new Admin();
        AdminInfo adminInfo = voAdmin.getAdminInfo();

        //检查账号是否已存在
        Admin oldAdmin = adminMapper.findAdminByName(voAdmin.getAdminName());

        long time = System.currentTimeMillis();

        //账号已存在
        if (oldAdmin != null) {
            throw new MyException("账号已存在");
        }
        //获取唯一主键
        Key64 key64 = new Key64();
        key64.setStub("a");
        //获取key-adminId
        key64Mapper.addKey64(key64);

        admin.setAdminId(key64.getId());
        admin.setAdminName(voAdmin.getAdminName());
        //生成盐值
        String uuid = UUID.randomUUID().toString();
        admin.setSaltVal(uuid);
        admin.setAdminType("1");  //系统管理员
        admin.setCreateTime(new Date(time));

        if (admin.getAdminPass() == null || "".equals(admin.getAdminPass())) {
            admin.setAdminPass("123456"); //设置初始密码
        }

        //加密密码，MD5（主键+盐值+密码）
        String adminPass = MD5Encode(admin.getAdminId() + admin.getSaltVal() + admin.getAdminPass(), "UTF-8", true);

        admin.setAdminPass(adminPass);
        admin.setAdminType("1");  //设置为管理员

        int i = adminMapper.insert(admin);
        adminInfo.setAdminId(admin.getAdminId());
        int j = adminInfoMapper.insert(adminInfo);

        //添加角色
        AuthCustomerRole authCustomerRole = new AuthCustomerRole();
        authCustomerRole.setCustomerId(admin.getAdminId());
        authCustomerRole.setRoleId(voAdmin.getRoleId());
        int k = authCustomerRoleMapper.insert(authCustomerRole);

        if (i == 1 && j==1 && k == 1) {
            AddAdminResp addAdminResp = new AddAdminResp();
            addAdminResp.setAdminId(admin.getAdminId());
            return addAdminResp;
        } else {
            throw new MyException("添加失败");
        }

    }

    @Override
    public int updateAdmin(Admin admin) {
        Admin oldAdmin = adminMapper.findAdminByName(admin.getAdminName());
        String newAdminPass = MD5Encode(oldAdmin.getAdminId() + oldAdmin.getSaltVal() + admin.getAdminPass(), "UTF-8", true);
        admin.setAdminPass(newAdminPass);
        return adminMapper.updateAdminPass(admin);
    }

    @Override
    public int delete(Long adminId) {
        return adminMapper.deleteAdmin(adminId);
    }

    @Override
    public Pager findAllAdmin(Pager<Admin> pager) {
        pager.setRecords(adminMapper.findAllAdmin(pager));
        return pager;
    }


    //登录
    @Override
    public IfLoginResp ifLogin(VoLogin voLogin, HttpServletRequest request) {

        Admin admin = new Admin();
        admin.setAdminName(voLogin.getAdminName());
        admin.setAdminPass(voLogin.getAdminPass());
        Admin oldAdmin = adminMapper.findAdminByUserName(admin);

        long time = System.currentTimeMillis();

        if (oldAdmin == null) {
            throw new MyException("账号不存在");
        } else if (oldAdmin.getAdminPass().equals(MD5Encode(oldAdmin.getAdminId() + oldAdmin.getSaltVal() + admin.getAdminPass(), "UTF-8", true))) {  //密码正确
            String token = "";

            Long adminId = oldAdmin.getAdminId();
            String adminName = oldAdmin.getAdminName();

            //查询账号角色信息
            List<AuthRole> roles = authCustomerRoleService.findCustomerRoleById(adminId);

            VoAdminInfo voAdminInfo = adminInfoMapper.findAdminInfoByAdminId(adminId);


            //设置token，有效期
            token = JwtUtil.getToken(adminId, adminName, roles,voAdminInfo.getProvinceId(),voAdminInfo.getCityId(),voLogin.getClient());


            IfLoginResp ifLoginResp = new IfLoginResp();
            ifLoginResp.setToken(token);
            ifLoginResp.setIssuedAt(new Date(time));
            ifLoginResp.setRoles(roles);
            ifLoginResp.setVoAdminInfo(voAdminInfo);
            ifLoginResp.setAuthModulars(findIndexByRoleId(roles));

            HttpSession session = request.getSession();
            session.setAttribute("id",adminId);
            session.setAttribute("name",adminName);
            session.setAttribute("client",voLogin.getClient());
            session.setAttribute("roles",roles);
            session.setAttribute("pid",voAdminInfo.getProvinceId());
            session.setAttribute("cid",voAdminInfo.getCityId());

            return ifLoginResp;
        } else {
            throw new MyException("账号不存在或密码错误");
        }


    }

    //注销
    @Override
    public int ifLogout(HttpSession session) {
        Long adminId = (Long) session.getAttribute("id");
        String tokenKey = adminId.toString();
        if (MemoryData.getTokenMap().containsKey(tokenKey)) {
            MemoryData.getTokenMap().remove(tokenKey);  //删除adminId-token
        }
        return 1;
    }

    //修改密码，校验原密码
    @Override
    public ApiResult updateAdminByAdminPass(HttpSession session, UpdateAdminByAdminPassReq updateAdminByAdminPassReq) {


        String oldAdminPass = updateAdminByAdminPassReq.getOldAdminPass();
        String newAdminPass = updateAdminByAdminPassReq.getNewAdminPass();


        ApiResult apiResult;
        Admin admin = new Admin();
        admin.setAdminName((String) session.getAttribute("name"));
        Admin oldAdmin = adminMapper.findAdminByName(admin.getAdminName());

        int i = 0;
        if (MD5Encode(oldAdmin.getAdminId() + oldAdmin.getSaltVal() + oldAdminPass, "UTF-8", true).equals(oldAdmin.getAdminPass())) {

            String md5Pass = MD5Encode(oldAdmin.getAdminId() + oldAdmin.getSaltVal() + newAdminPass, "UTF-8", true);
            oldAdmin.setAdminPass(md5Pass);

            admin.setAdminId(oldAdmin.getAdminId());
            admin.setAdminPass(md5Pass);
            i = adminMapper.updateAdminPass(admin);

            if (i > 0) {
                apiResult = ApiResult.SUCCESS();
            } else {
                apiResult = ApiResult.FAIL();
            }
        } else {

            apiResult = ApiResult.FAIL();
            apiResult.setMsg("密码错误");
        }


        return apiResult;
    }

    @Override
    @Transactional
    public int updateAdmin(VoAdmin voAdmin, HttpServletRequest request) {
        Admin admin = new Admin();
        admin.setAdminId(voAdmin.getAdminId());
        admin.setOperatorId((Long) request.getSession().getAttribute("id"));
        int i = adminMapper.updateById(admin);

        if (voAdmin.getRoleId()!=null && voAdmin.getRoleId()>0){
            AuthCustomerRole authCustomerRole = new AuthCustomerRole();
            authCustomerRole.setCustomerId(admin.getAdminId());
            authCustomerRole.setRoleId(voAdmin.getRoleId());
            int j = authCustomerRoleMapper.update(authCustomerRole,new UpdateWrapper<AuthCustomerRole>().eq("customer_id",admin.getAdminId()));
        }
        int k = adminInfoMapper.updateById(voAdmin.getAdminInfo());
        return i+k;
    }

    @Override
    public AuthModulars findIndexByRoleId(List<AuthRole> roles) {
        List<AuthRoleModulars> authRoleModulars = (List<AuthRoleModulars>) MemoryData.getRoleModularMap().get("authRoleModulars");

        long finalRoleId = roles.get(0).getRoleId();
        Optional<AuthRoleModulars> authRoleModulars2 =
                authRoleModulars.stream().filter(authRoleModulars1 -> finalRoleId ==authRoleModulars1.getRoleId()).findFirst();
        if (authRoleModulars2.isPresent()){
            return authRoleModulars2.get().getAuthModulars();
        }

        return null;
    }
}