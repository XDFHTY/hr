package com.cj.hpatrol.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cj.core.domain.Pager;
import com.cj.core.entity.PatrolTaskStation;
import com.cj.hpatrol.domain.PatrolTaskStationModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author： 刘磊
 * @Description: 巡查任务台站
 * @date： 2019/5/20 18:20
 **/
public interface PTSPatrolMapper extends BaseMapper<PatrolTaskStation> {
    /**
     * 查询巡查任务中台站任务是否有已完成
     * @param patrolTaskProvinceId
     * @return
     */
    List<PatrolTaskStation> findStateByPatrolTaskProvinceId(Long patrolTaskProvinceId);

    /**
     * 根据巡查任务省id查询
     * @param patrolTaskProvinceId
     * @return
     */
    List<PatrolTaskStationModel> findByPatrolTaskProvinceId(Long patrolTaskProvinceId);

    /**
     * 根据巡查任务省id删除
     * @param patrolTaskProvinceId
     * @return
     */
    int deleteByPatrolTaskProvinceId(Long patrolTaskProvinceId);
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
    List<PatrolTaskStationModel> findPage(Pager pager);
}
