package com.cj.hafter.service;

import com.cj.core.domain.ApiResult;
import com.cj.core.domain.Pager;
import com.cj.core.entity.SaleType;
import com.cj.hafter.entity.BCModel;
import com.cj.hafter.entity.DeclareVo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.List;

/**
 * 售后管理
 * Created by JuLei on 2019/5/28.
 */
public interface AfterSaleService {

    //新增售后申报
    int addDeclare(DeclareVo declareVo, HttpServletRequest request);

    //分页查询售后申报
    Pager findAll(Pager pager, HttpServletRequest request);

    //编辑  修改执行人 和 执行时间
    int update(DeclareVo declareVo, HttpServletRequest request);

    /**
     * 新增售后分类
     */
    int insertBC(List<SaleType> list);
    /**
     * 修改售后分类
     */
    int updateBC(SaleType saleType);
    /**
     * 查询分类列表
     */
    List<BCModel> findBC(String parameter);

    //导入售后分类
    ApiResult importInfo(MultipartFile file, InputStream in);
}
