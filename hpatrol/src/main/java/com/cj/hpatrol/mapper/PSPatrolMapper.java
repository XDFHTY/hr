package com.cj.hpatrol.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cj.core.entity.PatrolStation;
import com.cj.hpatrol.domain.PatrolStationModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author： 刘磊
 * @Description: 巡查周期市表
 * @date： 2019/5/20 18:37
 **/
public interface PSPatrolMapper extends BaseMapper<PatrolStation> {

    /**
     * 根据巡查周期省表id查询
     * @param patrolCycleId
     * @return
     */
    List<PatrolStationModel> findByPatrolCycleId(Long patrolCycleId);

    /**
     * 根据巡查周期省表id删除
     * @param patrolCycleId
     * @return
     */
    int deleteByPatrolCycleId(Long patrolCycleId);
}
