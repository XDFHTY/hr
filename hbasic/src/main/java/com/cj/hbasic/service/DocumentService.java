package com.cj.hbasic.service;

import com.cj.core.domain.Pager;
import com.cj.hbasic.domian.ResourcesVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by JuLei on 2019/6/3.
 */
public interface DocumentService {

    //分页查询文档列表
    Pager findAll(Pager pager, HttpServletRequest request);

    //上传文档
    int addDocument(ResourcesVo resourcesVo, HttpServletRequest request);

    //删除文档
    void deleteById(List<String> ids, HttpServletRequest request);
}
