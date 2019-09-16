package com.cj.hbasic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cj.core.domain.Pager;
import com.cj.core.entity.Resources;
import com.cj.core.entity.Site;
import com.cj.hbasic.domian.DeviceVo;
import com.cj.hbasic.domian.PatrolTask;
import com.cj.hbasic.domian.SiteStateVo;
import com.cj.hbasic.domian.SiteVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by win9 on 2019/5/21.
 */

public interface SitesMapper extends BaseMapper<Site> {

    //根据id查看台站信息 + 图片
    SiteVo selectBySiteId(Long siteId);

    //分页查询站点
    List<SiteVo> findAll(Pager pager);

    //分页查询站点 计数
    int findAllCount(Pager pager);

    List<Resources> findSiteImgById(Long siteId);

    //根据台站id  查询巡检记录
    List<PatrolTask> findPatrolTaskById(Pager pager);


    //查询台站信息
    List<SiteVo> findDataScreen(@Param("pid") Integer pid, @Param("cid") Integer cid, @Param("typeId") Integer siteTypeId);

    //统计站点状态
    SiteStateVo findSiteState(@Param("pid") Integer pid, @Param("cid") Integer cid, @Param("typeId") Integer siteTypeId);

    //查询最后维护人 和最后维护时间
    Map selectMaintain(Long siteId);
}
