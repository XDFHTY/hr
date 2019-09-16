package com.cj.hcensus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cj.core.entity.RepairRecord;
import com.cj.hcensus.domain.RepCensusModel;
import com.cj.hcensus.domain.StaCensusModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author： 刘磊
 * @Description: 维护记录表
 * @date： 2019/5/23 9:26
 **/
public interface RRCensusMapper extends BaseMapper<RepairRecord> {

    /**
     * 统计维护状态
     * @param map
     * @return
     */
    List<RepCensusModel> findCensusR(Map map);
}
