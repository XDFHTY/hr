package com.cj.common.service;

import com.cj.common.domain.AdmainModel;

import java.util.List;

/**
 * @author： 刘磊
 * @Description: 人员查询业务层
 * @date： 2019/5/28 14:11
 **/
public interface FUService {
    /**
     * 根据角色id和部门id查询
     * @param pid 角色id
     * @param cid 部门id
     * @return
     */
    List<AdmainModel> findUser(Long pid, Long cid);
}
