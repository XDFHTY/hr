package com.cj.hpatrol.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cj.core.domain.Pager;
import com.cj.core.entity.PatrolTaskProvince;
import com.cj.hpatrol.domain.PatrolTaskModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author： 刘磊
 * @Description: 巡查任务省表
 * @date： 2019/5/20 18:38
 **/
public interface PTPPatrolMapper extends BaseMapper<PatrolTaskProvince> {
    /**
     * 查询条数
     * @param pager
     * @return
     */
    int findCount(Pager pager);

    /**
     * 查询内容
     * @param pager
     * @return
     */
    List<PatrolTaskModel> findPage(Pager pager);

    /**
     * 根据用户查询巡查未完成的任务
     * @param pager
     * @return
     */
    List<PatrolTaskModel> findCycle(Pager pager);

    /**
     * 根据用户查询巡查任务历史
     * @param pager
     * @return
     */
    List<PatrolTaskModel> findHistory(Pager pager);

    /**
     * 根据台站查询巡查任务
     * @param pager
     * @return
     */
    List<PatrolTaskModel> findBySiteId(Pager pager);
}
