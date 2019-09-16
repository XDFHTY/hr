package com.cj.hcensus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cj.core.entity.PatrolTaskProvince;
import com.cj.hcensus.domain.PatCensusModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


/**
 * @author： 刘磊
 * @Description: 巡查任务省表
 * @date： 2019/5/20 18:38
 **/
@Repository("hcensusPatrolTaskProvinceMapper")
public interface PTPCensusMapper extends BaseMapper<PatrolTaskProvince> {
    /**
     * 统计巡查情况
     * @param map
     * @return
     */
    List<PatCensusModel> findCensusP(Map map);
}
