package com.cj.hsys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cj.core.entity.AdminInfo;
import com.cj.hsys.domain.VoAdminInfo;

/**
* Created by Mybatis Generator 2019-05-20 18:14:26
*/
public interface AdminInfoMapper extends BaseMapper<AdminInfo> {


    VoAdminInfo findAdminInfoByAdminId(Long adminId);
}