package com.cj.hafter.service;

import com.cj.core.domain.Pager;
import com.cj.hafter.entity.DeclareVo;
import com.cj.hafter.entity.RepairRecordVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 售后记录 业务模块
 * Created by JuLei on 2019/5/31.
 */
public interface RecordsService {


    /**
     * 查询已完成和未完成的售后任务
     * 员工 ：可见所有未指派的任务 和 指派给他的任务
     * 办事处员工： 可见归属地下未指派的任务 和 指派给他的任务
     * 其他： 可见指派给他的任务
     */
    Pager findAll(Pager pager, HttpServletRequest request);

    //查询维修记录
    List<RepairRecordVo> findRepairRecord(Long declareId, HttpServletRequest request);

    //新增维修记录
    int insertRepairRecord(List<RepairRecordVo> recordVos, HttpServletRequest request);

    //追加记录   修改描述 和 新增图片、视频
    int updateRepairRecord(List<RepairRecordVo> recordVos, HttpServletRequest request);

    //根据台站id查询历史申报列表
    Pager findAllBySiteId(Pager pager, HttpServletRequest request);

    //修改任务状态
    int updateDeclareState(DeclareVo declareVo, HttpServletRequest request);
}
