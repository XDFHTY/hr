package com.cj.hpatrol.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cj.core.domain.Pager;
import com.cj.core.entity.PatrolCycle;
import com.cj.hpatrol.domain.PatrolCycleModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author： 刘磊
 * @Description: 巡查周期记录省表
 * @date： 2019/5/20 18:37
 **/
public interface PCPatrolMapper extends BaseMapper<PatrolCycle> {

    /**
     * 查询总条数
     * @param pager
     * @return
     */
    int findCount(Pager pager);

    /**
     * 分页查询内容
     * @param pager
     * @return
     */
    List<PatrolCycleModel> findPage(Pager pager);

    /**
     * 查询所有
     * @return
     */
    List<PatrolCycleModel> findAll();
}
