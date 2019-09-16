package com.cj.common.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cj.common.domain.AdmainModel;
import com.cj.core.entity.AdminInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author： 刘磊
 * @Description: ${description}
 * @date： 2019/5/28 14:15
 **/
public interface FUMapper extends BaseMapper<AdminInfo> {

    /**
     * 根据角色id和部门id查询
     * @param pid 角色id
     * @param cid 部门id
     * @return
     */
    List<AdmainModel> findUser(@Param("pid") Long pid,@Param("cid") Long cid);
}
