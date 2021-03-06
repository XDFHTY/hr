package com.cj.hsys.service;

import com.cj.core.domain.ApiResult;
import com.cj.core.domain.AuthRoleModulars;
import com.cj.core.entity.AuthRole;
import com.cj.hsys.domain.UpdateModularByRoleIdReq;

import java.util.List;

public interface RolePowerService {

    //====================================角色管理

    /**
     * 查询所有角色信息
     */
    public ApiResult findAllRole();

    /**
     * 新增角色
     */
    public ApiResult addRole(AuthRole authRole);

    /**
     * 删除角色
     */
    public ApiResult deleteRole(Long roleId);


    //======================================权限管理

    /**
     * 根据角色ID查询权限列表
     */
    public AuthRoleModulars findModularByRoleId(String json);

    /**
     * 根据角色ID修改角色权限
     * @param updateModularByRoleIdReq
     * @return
     */
    public ApiResult updateModularByRoleId(UpdateModularByRoleIdReq updateModularByRoleIdReq);


    /**
     * 从新读取权限信息
     * @return
     */
    public ApiResult readRolePower();


}
