package com.cj.hafter.service;

import com.cj.core.domain.Pager;
import com.cj.hafter.entity.RepairRecordVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by JuLei on 2019/6/3.
 */
public interface BRecordsService {

    //分页查询售后记录
    Pager findAll(Pager pager, HttpServletRequest request);

    //查询维护次数列表
    List<Map> findNumById(Long declareId, HttpServletRequest request);

    //查询维护详情
    List<RepairRecordVo> findRecordsById(Long saleNumId, HttpServletRequest request);

    //编辑处理详情
    int updateRecord(RepairRecordVo repairRecordVo, HttpServletRequest request);

    //删除售后图片或视频
    int deleteSaleImg(Long resourceId, HttpServletRequest request);
}
