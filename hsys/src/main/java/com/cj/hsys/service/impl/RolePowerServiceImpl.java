package com.cj.hsys.service.impl;

import com.cj.core.entity.AuthRole;
import com.cj.common.mapper.AuthCustomerRoleMapper;
import com.cj.common.mapper.AuthModularMapper;
import com.cj.common.mapper.AuthRoleMapper;
import com.cj.common.mapper.AuthRoleModularMapper;
import com.cj.common.service.AuthRoleModularService;
import com.cj.core.domain.*;
import com.cj.core.exception.MyException;
import com.cj.hsys.domain.FindAllRoleResp;
import com.cj.hsys.domain.UpdateModularByRoleIdReq;
import com.cj.hsys.service.RolePowerService;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
@Transactional
public class RolePowerServiceImpl implements RolePowerService {


    @Resource
    private AuthRoleMapper authRoleMapper;

    @Resource
    private AuthModularMapper authModularMapper;

    @Resource
    private AuthCustomerRoleMapper authCustomerRoleMapper;

    @Resource
    private AuthRoleModularMapper authRoleModularMapper;

    @Resource
    private AuthRoleModularService authRoleModularService;


    @Override
    public ApiResult findAllRole() {

        //查询所有角色
        List<AuthRole> authRoles = authRoleMapper.findAllAuthRole();
        //获取系统内所有权限
        AuthModulars authModulars = (AuthModulars) MemoryData.getRoleModularMap().get("authModulars");


        FindAllRoleResp findAllRoleResp = new FindAllRoleResp();
        findAllRoleResp.setAuthRoles(authRoles);
        findAllRoleResp.setAuthModulars(authModulars);

        ApiResult apiResult = ApiResult.SUCCESS();
        apiResult.setData(findAllRoleResp);
        return apiResult;
    }

    @Override
    public ApiResult addRole(AuthRole authRole) {
        ApiResult apiResult = null;

        AuthRole oldAuthRole = authRoleMapper.findAuthRoleByName(authRole.getRoleName());
        if (oldAuthRole != null) {
            apiResult = ApiResult.FAIL();
            apiResult.setMsg("角色已存在");

            return apiResult;
        }

        int i = authRoleMapper.insert(authRole);
        if (i > 0) {
            apiResult = ApiResult.SUCCESS();
        } else {
            apiResult = ApiResult.FAIL();
        }
        return apiResult;
    }

    @Override
    public ApiResult deleteRole(Long roleId) {
        ApiResult apiResult = null;

        if ("26,29,30,31,33,34".indexOf(roleId.toString()) > -1) {
            throw new MyException("禁止删除");
        }

        int i = authCustomerRoleMapper.findCustomerNumByRoleId(roleId);
        if (i > 0) {
            throw new MyException("此角色已有用户在使用");
        }
        //物理删除角色信息
        int j = authRoleMapper.deleteById(roleId);

        if (j > 0) {
            apiResult = ApiResult.SUCCESS();
        } else {
            apiResult = ApiResult.FAIL();
        }

        return apiResult;
    }

    //根据角色ID查询权限集合
    @Override
    public AuthRoleModulars findModularByRoleId(String json) {
        Gson gson = new Gson();
        Map map = gson.fromJson(json, Map.class);
        long roleId = ((Double) map.get("roleId")).longValue();

        List<AuthRoleModulars> authRoleModulars = (List<AuthRoleModulars>) MemoryData.getRoleModularMap().get("authRoleModulars");
//        AuthModulars authModulars = (AuthModulars) MemoryData.getRoleModularMap().get("authModulars");
        for (AuthRoleModulars authRoleModulars0 : authRoleModulars) {
            if (roleId == authRoleModulars0.getRoleId()) {
                return authRoleModulars0;
            }
        }

        return null;


    }

    @Override
    public ApiResult updateModularByRoleId(UpdateModularByRoleIdReq updateModularByRoleIdReq) {
        ApiResult apiResult = null;
        Gson gson = new Gson();

        long roleId = updateModularByRoleIdReq.getRoleId();
        List<Long> modularIds = updateModularByRoleIdReq.getModularIds();

        Map map = new HashMap();
        map.put("roleId", roleId);
        map.put("modularIds", modularIds);


        int i = authRoleModularMapper.deleteModularByRoleId(roleId);

        int j = authRoleModularMapper.addModularByRoleId(map);

        if (j > 0) {
            apiResult = ApiResult.SUCCESS();
            //更新系统权限
            authRoleModularService.findRoleModular();

        } else {
            apiResult = ApiResult.FAIL();
        }
        return apiResult;
    }

    @Override
    public ApiResult readRolePower() {
        authRoleModularService.findRoleModular();
        return ApiResult.SUCCESS();
    }

}
