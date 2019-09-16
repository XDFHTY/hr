package com.cj.common.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cj.core.entity.AuthCustomerRole;

public interface AuthCustomerRoleMapper extends BaseMapper<AuthCustomerRole> {

    /**
     * 统计使用此角色的用户ID
     * @return
     */
    public int findCustomerNumByRoleId(Long roleId);

}