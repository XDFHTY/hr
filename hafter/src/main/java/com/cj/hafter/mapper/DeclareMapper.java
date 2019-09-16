package com.cj.hafter.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cj.core.domain.Pager;

import com.cj.core.entity.DeclareData;
import com.cj.core.entity.Resources;
import com.cj.core.entity.SaleNum;
import com.cj.hafter.entity.DeclareVo;
import com.cj.hafter.entity.RepairRecordVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by JuLei on 2019/5/28.
 */
public interface DeclareMapper extends BaseMapper<DeclareData> {

    //分页查询售后申报
    List<DeclareVo> findAll(Pager pager);

    List<Resources> findDeclareImgById(Long declareId);

    List<Resources> findRepairImgById(Long repairId);


    //查询归属地下  指派给他和未指派的任务
    List<DeclareVo> findFRecords(Pager pager);

    //查询指派给他的任务
    List<DeclareVo> findDeclareByExeId(Pager pager);

    //查询维修记录
    List<RepairRecordVo> findRepairRecord(@Param("declareId") Long declareId);

    //查看当前申报的维护次数
    Integer findSaleNumById(@Param("declareId")Long declareId);

    //新增申报维护记录
    void insertSaleNum(SaleNum saleNum);

    //根据台站id查询历史申报列表
    List<DeclareVo> findAllBySiteId(Pager pager);

    //分页查询售后记录
    List<DeclareVo> findAllRecords(Pager pager);

    //查询最后维护人和最后维护时间
    Map findLastMaintainPeopleAndTime(@Param("declareId") Long declareId);

    //查询维护次数列表
    List<Map> findNumById(@Param("declareId")Long declareId);

    //查询维护详情
    List<RepairRecordVo> findRecordsById(@Param("saleNumId")Long saleNumId);
}
