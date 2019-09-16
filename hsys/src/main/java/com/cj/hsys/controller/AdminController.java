package com.cj.hsys.controller;


import com.cj.core.aop.Log;
import com.cj.core.domain.ApiResult;
import com.cj.core.domain.Pager;
import com.cj.core.domain.ResultUtil;
import com.cj.core.entity.Admin;
import com.cj.hsys.domain.*;
import com.cj.hsys.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/system/api/v1/account")
@Api(tags = "系统管理: 人员管理")
public class AdminController {
     Long id=null;

    @Autowired
    private AdminService adminService;



    /**
     * ============================================管理员登录、注销====================================================
     */

    /**
     * 登录
     */
    @ApiOperation(value = "登录",response = IfLoginResp.class)
    @PostMapping("/ifLogin")
    @Log(name = "人员管理",value = "登录")
    public ApiResult ifLogin(@ApiParam(name = "voLogin",value = "adminName=用户名、adminPass=密码,如：\n{\n" +
            "  \"adminName\": \"aaa\",\n" +
            "  \"adminPass\": \"123456\",\n" +
            "  \"client\": \"PC\"\n" +
            "}")
                       @RequestBody VoLogin voLogin, HttpServletRequest request){



        return ResultUtil.result(adminService.ifLogin(voLogin,request));


    }



    @ApiOperation("注销")
    @DeleteMapping("/ifLogout")
    @Log(name = "人员管理",value = "注销")
    public ApiResult ifLogout(HttpServletRequest request){
        System.out.println("===ID:  "+request.getHeader("id"));

        return ResultUtil.result(adminService.ifLogout(request.getSession()));
    }


    /**
     * ==============================================管理员账号维护===========================================================
     */

    /**
     * 新增账号
     */

    @ApiOperation(value = "添加账号",response = AddAdminResp.class)
    @PostMapping("/addAdmin")
    @Log(name = "人员管理",value = "添加账号")
    public ApiResult addAdmin(@ApiParam(name = "admin",value = "" +
            "",required = true)
                                  @RequestBody VoAdmin voAdmin){

        return ResultUtil.result(adminService.addAdmin(voAdmin));
    }

    /**
     * 修改密码，不校验原密码
     */
    @ApiOperation("修改密码，不校验原密码")
    @PutMapping("/updateAdminPass")
    @Log(name = "人员管理",value = "修改密码，不校验原密码")
    public ApiResult updateAdmin(@ApiParam(name = "admin",value = "id=adminId、账号=adminName、adminPass=新密码",required = true)
            @RequestBody Admin admin){

        return ResultUtil.result(adminService.updateAdmin(admin));
    }



    /**
     * 删除账号
     */
    @ApiOperation("删除账号")
    @DeleteMapping("/deleteAdmin")
    @Log(name = "人员管理",value = "删除账号")
    @ApiImplicitParam(name = "adminId",value = "adminId",required = true)
    public ApiResult deleteAdmins(Long adminId){
        return ResultUtil.result(adminService.delete(adminId));

    }


    /**
     * 查询所有账号
     */
    @ApiOperation(value = "分页查询所有账号",response = VoFindAdmin.class)
    @GetMapping("/findAllAdmin/{current}")
    @Log(name = "人员管理",value = "查询所有账号")
    public ApiResult findAllAdmin(@PathVariable long current){


        Pager<Admin> pager = new Pager();
        pager.setCurrent(current);

        return ResultUtil.result(adminService.findAllAdmin(pager));
    }


    //=========================================新接口==========

    /**
     * 修改密码，校验原密码
     */
    @PutMapping("/updateAdminByAdminPass")
    @ApiOperation("修改密码，校验原密码")
    @Log(name = "人员管理",value = "修改密码，校验原密码")
    public ApiResult updateAdminByAdminPass(@ApiParam(name = "json",value = "输入新旧密码")
                                           @RequestBody UpdateAdminByAdminPassReq updateAdminByAdminPassReq,
                                            HttpSession session){

        return adminService.updateAdminByAdminPass(session,updateAdminByAdminPassReq);
    }

    @PutMapping("/updateAdmin")
    @ApiOperation("修改账号信息")
    @Log(name = "人员管理",value = "修改账号信息")
    public ApiResult updateAdmin(
            @ApiParam(name = "voAdmin",value = "adminId、adminInfoId必传",required = true)
            @RequestBody VoAdmin voAdmin,HttpServletRequest request){

        return ResultUtil.result(adminService.updateAdmin(voAdmin,request));
    }

//    @GetMapping("/findIndexByRoleId")
//    @ApiOperation("查询菜单列表")
//    @Log(name = "人员管理",value = "查询菜单列表")
//    public ApiResult findIndexByRoleId(HttpServletRequest request){
//        return ResultUtil.result(adminService.findIndexByRoleId(request));
//    }

}
