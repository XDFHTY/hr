package com.cj.hcensus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cj.core.entity.Site;
import com.cj.hcensus.domain.StaCensusModel;
import com.cj.hcensus.domain.WorCensusModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author： 刘磊
 * @Description: 台站信息表
 * @date： 2019/5/23 9:17
 **/
public interface SCensusMapper extends BaseMapper<Site> {
    /**
     * 统计站点状态
     * @param map
     * @return
     */
    StaCensusModel findCensusS(Map map);

    /**
     * 统计工作情况
     * @param map
     * @return
     */
    List<WorCensusModel> findCensusW(Map map);
}
