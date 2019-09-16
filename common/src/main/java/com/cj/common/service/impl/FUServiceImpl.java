package com.cj.common.service.impl;

import com.cj.common.domain.AdmainModel;
import com.cj.common.mapper.FUMapper;
import com.cj.common.service.FUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author： 刘磊
 * @Description: 人员查询业务实现层
 * @date： 2019/5/28 14:12
 **/
@Service
@Transactional
public class FUServiceImpl implements FUService {

    @Autowired
    private FUMapper fuMapper;
    /**
     * 根据角色id和部门id查询
     * @param pid 角色id
     * @param cid 部门id
     * @return
     */
    @Override
    public List<AdmainModel> findUser(Long pid, Long cid) {
        return fuMapper.findUser(pid,cid);
    }
}
