package com.cj.hbasic.service.impl;

import com.cj.core.domain.Pager;
import com.cj.core.entity.Device;
import com.cj.core.entity.Resources;
import com.cj.core.entity.Site;
import com.cj.hbasic.domian.DeviceVo;
import com.cj.hbasic.domian.PatrolTask;
import com.cj.hbasic.domian.SiteStateVo;
import com.cj.hbasic.domian.SiteVo;
import com.cj.hbasic.mapper.DeviceMapper;
import com.cj.hbasic.mapper.ResourcesMapper;

import com.cj.hbasic.mapper.SitesMapper;
import com.cj.hbasic.service.SiteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.management.relation.Role;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * 站点管理
 * Created by win9 on 2019/5/21.
 */
@Service
@Transactional
public class SiteServiceImpl implements SiteService {

    @Value("${web.path}")
    private String path;

    @Autowired
    private SitesMapper siteMapper;

    @Autowired
    private ResourcesMapper resourcesMapper;

    @Autowired
    private DeviceMapper deviceMapper;



    /**
     * 新增站点
     *
     * @param siteVo
     * @return
     */
    @Override
    public int addSite(SiteVo siteVo, HttpServletRequest request) {
        //获取操作人id
        Long id = (Long) request.getSession().getAttribute("id");

        Date nowDate = new Date();
        siteVo.setCreateTime(nowDate);

        //新增站点信息
        int i = siteMapper.insert(siteVo);

        List<Resources> imgList = siteVo.getImgList();
        if (i > 0 && imgList != null && imgList.size() != 0){
            for (Resources resources:imgList){
                resources.setCreateTime(nowDate);//创建时间
                resources.setFounderId(id);//创建人
                resources.setResourceType("台站图片");//图片类型
                resources.setRelationId(siteVo.getSiteId());//台站id
                //新增图片信息
                resourcesMapper.insert(resources);
            }

           /* //生成二维码    前端生成
            String text = "\"siteId\":" + siteVo.getSiteId();//二维码内容
            try {
                String path = QRCodeUtil.encode(text, "", "h:/", true);
            } catch (Exception e) {
                //二维码生成失败
                e.printStackTrace();
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//事务回滚
                return -2;
            }*/

        }
        return i;
    }


    /**
     * 编辑 台站
     *
     * @param siteVo
     * @param request
     * @return
     */
    @Override
    public int updateSite(SiteVo siteVo, HttpServletRequest request) {
        //获取操作人id
        Long id = (Long) request.getSession().getAttribute("id");
        Date nowDate = new Date();

        int i = siteMapper.updateById(siteVo);

        List<Resources> imgList = siteVo.getImgList();
        if (imgList != null && imgList.size()!=0){
            for (Resources resources:imgList){
                if (resources.getResourceId() != null){
                    //修改
                    resourcesMapper.updateById(resources);
                }else {
                    //新增
                    resources.setCreateTime(nowDate);//创建时间
                    resources.setFounderId(id);//创建人
                    resources.setResourceType("台站图片");//图片类型
                    resources.setRelationId(siteVo.getSiteId());//台站id
                    //新增图片信息
                    resourcesMapper.insert(resources);
                }

            }
        }


        return 1;
    }

    /**
     * 删除台站图片
     * @param resourceId
     * @param request
     * @return
     */
    @Override
    public int deleteSiteImgById(Long resourceId, HttpServletRequest request) {
        int i = resourcesMapper.deleteById(resourceId);
        return i;
    }

    /**
     * 根据id查看台站信息 + 图片
     * @param siteId
     * @param request
     * @return
     */
    @Override
    public SiteVo findSiteById(Long siteId, HttpServletRequest request) {
        //根据id查看台站信息 + 图片
        SiteVo siteVo = siteMapper.selectBySiteId(siteId);
        //查询最后维护人 和最后维护时间
        Map map = siteMapper.selectMaintain(siteId);
        if (map != null){
            if (map.get("maintainTime")!=null){
                siteVo.setMaintainTime((Date) map.get("maintainTime"));
            }
            if (map.get("fullName") != null){
                siteVo.setMaintainPeople((String) map.get("fullName"));
            }
        }
        return siteVo;
    }

    /**
     * 模糊搜索所有字段，分页查询站点
     * @param page
     * @return
     */
    @Override
    public Pager findAll(Pager pager,HttpServletRequest request) {
        HttpSession session = request.getSession();
        //获取操作人角色
       /* List<Map> roles  = (List<Map>) session.getAttribute("roles");
        Map map = roles.get(0);
        String roleName = (String) map.get("roleName");

        if ("用户".equals(roleName)){
            Long pid = (Long) session.getAttribute("pid");
            Long cid = (Long) session.getAttribute("cid");
            Map map1 = new HashMap();
            if (pid != 0){
                map1.put("pid",pid);
            }
            if (cid != 0){
                map1.put("cid",cid);
            }
            pager.setParameters(map1);
        }*/

        //有归属地就查询归属地下的  没有归属地就查全部
        Long pid = (Long) session.getAttribute("pid");
        Long cid = (Long) session.getAttribute("cid");
        Map map1 = new HashMap();
        if (pid != 0){
            map1.put("pid",pid);
        }
        if (cid != 0){
            map1.put("cid",cid);
        }
        pager.setParameters(map1);

        //分页查询站点
        List<SiteVo> siteVo = this.siteMapper.findAll(pager);
        pager.setRecords(siteVo);

        return pager;
    }

    /**
     * 根据台站id  查询巡检记录
     * @param siteId
     * @param request
     * @return
     */
    @Override
    public Pager findPatrolTaskById(Pager pager, HttpServletRequest request) {
        List<PatrolTask> patrolTasks = this.siteMapper.findPatrolTaskById(pager);
        pager.setRecords(patrolTasks);
        return pager;
    }


    /**
     * 根据台站id  删除台站
     * @param siteId
     * @param request
     */
    @Override
    public void deleteById(Long siteId, HttpServletRequest request) {
        Site site = new Site();
        site.setSiteId(siteId);
        site.setIsDeleteState("0");//删除状态 0-已删除 1-正常
        siteMapper.updateById(site);
    }

    /**
     * 根据台站id查询设备列表
     * @param pager
     * @param request
     * @return
     */
    @Override
    public Pager findDevicesById(Pager pager, HttpServletRequest request) {
        List<DeviceVo> deviceVoList = this.deviceMapper.findDevicesBySiteId(pager);
        pager.setRecords(deviceVoList);
        return pager;
    }

    @Override
    public Map findDataScreen(Integer pid, Integer cid, Integer siteTypeId, HttpServletRequest request) {
        //查询台站信息
        List<SiteVo> sites = this.siteMapper.findDataScreen(pid,cid,siteTypeId);

        //统计站点状态
        SiteStateVo siteStateVo = this.siteMapper.findSiteState(pid,cid,siteTypeId);

        Map map = new HashMap();
        map.put("sites",sites);
        map.put("siteState",siteStateVo);

        return map;
    }
}
