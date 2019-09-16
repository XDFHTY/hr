package com.cj.hcensus.service;

import com.cj.hcensus.domain.PatCensusModel;
import com.cj.hcensus.domain.RepCensusModel;
import com.cj.hcensus.domain.StaCensusModel;
import com.cj.hcensus.domain.WorCensusModel;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author： 刘磊
 * @Description: 统计管理业务层
 * @date： 2019/5/23 9:13
 **/
public interface CensusService {
    /**
     * 统计工作情况
     * @param map
     * @return
     */
    List<WorCensusModel> findCensusW(Map map);

    /**
     * 统计巡查情况
     * @param map
     * @return
     */
    List<PatCensusModel> findCensusP(Map map);

    /**
     * 统计维护情况
     * @param map
     * @return
     */
    List<RepCensusModel> findCensusR(Map map);

    /**
     * 统计台站状态
     * @param map
     * @return
     */
    StaCensusModel findCensusS(Map map);

    /**
     * 导出统计工作情况
     * @param map
     * @param response
     */
    String importW(Map map,HttpServletResponse response);
    /**
     * 导出统计巡查情况
     * @param map
     * @param response
     */
    String importP(Map map,HttpServletResponse response);
    /**
     * 导出统计维护情况
     * @param map
     * @param response
     */
    String importR(Map map,HttpServletResponse response);
    /**
     * 导出统计台站状态
     * @param map
     * @param response
     */
    String importS(Map map,HttpServletResponse response);
}
