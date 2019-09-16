package com.cj.hsys.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cj.core.domain.Pager;
import com.cj.core.entity.Admin;

import java.util.List;

public interface AdminMapper extends BaseMapper<Admin> {

    /**
     * 删除账号
     */
    public  int deleteAdmin(Long adminId);

    /**
     * 批量删除账号
     */
    public int deleteAdmins(List<Long> adminIds);

    /**
     * 查询所有账号
     */
    public List<Admin> findAllAdmin(Pager pager);

    /**
     * 根据用户名查询账号
     */
    public Admin findAdminByUserName(Admin admin);

    /**
     * 修改密码
     */
    public int updateAdminPass(Admin admin);

    /**
     * 查询用户名是否已存在
     */
    public Admin findAdminByName(String adminName);





}