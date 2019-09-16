package com.cj.hsys.service;


import com.cj.core.domain.ApiResult;
import com.cj.core.domain.AuthModulars;
import com.cj.core.domain.Pager;
import com.cj.core.entity.Admin;
import com.cj.core.entity.AuthRole;
import com.cj.hsys.domain.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public interface AdminService {

    /**
     * =====================================Admin===================================================
     */

    /**
     * 新增管理员账号
     */
    public AddAdminResp addAdmin(VoAdmin voAdmin);


    /**
     * 修改管理员密码
     */
    public int updateAdmin(Admin admin);



    /**
     * 删除管理员账号
     */
    public int delete(Long adminId);



    /**
     * 查询所有管理员账号
     */
    public Pager findAllAdmin(Pager<Admin> pager);


    /**
     * 管理员登录
     */
    public IfLoginResp ifLogin(VoLogin voLogin, HttpServletRequest request);

//    /**
//     * ADLogin
//     */
//    public IfLoginResp ADLogin(String userid, String token, String key);

//    /**
//     * 管理员从HSE系统登录
//     * @param admin
//     * @param request
//     * @return
//     */
//    public IfLoginResp ipLogin(Admin admin ,HttpServletRequest request);

    /**
     * 管理员注销
     */
    public int ifLogout(HttpSession session);




    /**
     * 修改密码，校验原密码
     */
    public ApiResult updateAdminByAdminPass(HttpSession session, UpdateAdminByAdminPassReq updateAdminByAdminPassReq);

    /**
     * 修改账号信息
     * @return
     */
    public int updateAdmin(VoAdmin voAdmin,HttpServletRequest request);


    public AuthModulars findIndexByRoleId(List<AuthRole> roles);

}
