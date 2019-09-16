package com.cj.common.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cj.core.entity.AuthRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuthRoleMapper extends BaseMapper<AuthRole> {


    //根据用户 consumerId 查询账号角色信息
    public List<AuthRole> findCustomerRoleById(Long consumerId);

    //查询所有角色信息集合
    public List<AuthRole> findAllAuthRole();

    //根据角色名称查询角色信息
    public AuthRole findAuthRoleByName(String roleName);

    //根据账号等级和角色名称 查询角色id
    Long findRoleIdByName(@Param("roleName") String roleName);
}