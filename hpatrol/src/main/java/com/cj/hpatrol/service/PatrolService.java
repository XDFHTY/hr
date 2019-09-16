package com.cj.hpatrol.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cj.core.domain.Pager;
import com.cj.core.entity.PatrolCycle;
import com.cj.hpatrol.domain.PatrolCycleModel;
import com.cj.hpatrol.domain.PatrolTaskModel;
import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author： 刘磊
 * @Description: 巡查业务层
 * @date： 2019/5/20 17:38
 **/
public interface PatrolService {
    /**
     * 新增周期巡查计划
     */
    int inerstPatrolCycle(PatrolCycleModel patrolCycleModel, HttpSession session);
    /**
     * 新增专项巡查计划
     */
    int inerstPatrolTask(PatrolTaskModel patrolTaskModel);
    /**
     * 删除周期巡查计划
     */
    int deletePatrolCycle(List<Long> list);
    /**
     * 删除专项巡查计划
     */
    int deletePatrolTask(List<Long> list);
    /**
     * 修改巡查人名字
     */
    int updatePatrolName(PatrolCycle patrolCycle);
    /**
     * 查询周期巡查计划
     */
    Pager findPatrolCycle(Pager pager);
    /**
     * 查询专项巡查计划
     */
    Pager findPatrolTask(Pager pager);
    /**
     * 查询巡查记录
     */
    Pager findPatrolTaskStation(Pager pager);
    /**
     * 根据用户和类型查询巡查任务
     */
    Pager findCycle(Pager pager,HttpSession session);
    /**
     * 根据用户和类型查询巡查任务历史
     */
    Pager findHistory(Pager pager,HttpSession session);
    /**
     * 根据台站查询巡查任务
     */
    Pager findBySiteId(Pager pager,HttpSession session);
    /**
     * 签到 1 到站 2离站
     */
    int sign(int i,Long id);
}
