package com.cj.common.service.impl;

import com.cj.common.domain.CSiteVo;
import com.cj.common.mapper.CSiteMapper;
import com.cj.common.service.CSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 台站查询
 * Created by win9 on 2019/5/22.
 */
@Service
public class CSiteServiceImpl implements CSiteService {

    @Autowired
    private CSiteMapper cSiteMapper;

    /**
     * 按地区、类型查询站点列表
     * @param type
     * @param pid
     * @param cid
     * @param request
     * @return
     */
    @Override
    public List<CSiteVo> findAll(Integer type, Integer pid, Integer cid, HttpServletRequest request) {
        return this.cSiteMapper.findAllByIds(type,pid,cid);
    }
}
