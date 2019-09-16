package com.cj.hbasic.service;

import com.cj.core.domain.Pager;
import com.cj.hbasic.domian.PatrolTask;
import com.cj.hbasic.domian.SiteVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by win9 on 2019/5/21.
 */
public interface SiteService {

    //新增站点
    int addSite(SiteVo siteVo, HttpServletRequest request);

    //编辑台站
    int updateSite(SiteVo siteVo, HttpServletRequest request);

    //删除台站图片
    int deleteSiteImgById(Long resourceId, HttpServletRequest request);

    //根据id查看台站信息
    SiteVo findSiteById(Long siteId, HttpServletRequest request);

    //模糊搜索所有字段，分页查询站点
    Pager findAll(Pager pager,HttpServletRequest request);

    //根据台站id  查询巡检记录
    Pager findPatrolTaskById(Pager pager, HttpServletRequest request);

    //根据台站id  删除台站
    void deleteById(Long siteId, HttpServletRequest request);

    //根据台站id查询设备列表
    Pager findDevicesById(Pager pager, HttpServletRequest request);

    //查询数据大屏和统计
    Map findDataScreen(Integer pid, Integer cid, Integer siteTypeId, HttpServletRequest request);
}
