package com.cj.common.service;

import com.cj.common.domain.CSiteVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by win9 on 2019/5/22.
 */
public interface CSiteService {

    //按地区、类型查询站点列表
    List<CSiteVo> findAll(Integer type, Integer pid, Integer cid, HttpServletRequest request);
}
