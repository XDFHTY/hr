package com.cj.hbasic.controller;

import com.cj.core.aop.Log;
import com.cj.core.domain.ApiResult;

import com.cj.core.domain.Pager;
import com.cj.core.entity.Site;
import com.cj.hbasic.domian.DeviceVo;
import com.cj.hbasic.domian.PatrolTask;
import com.cj.hbasic.domian.SiteVo;
import com.cj.hbasic.service.SiteService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 后台 站点管理
 * Created by win9 on 2019/5/21.
 */
@RestController
@RequestMapping("/b-site/api/v1/site")
@Api(tags = "后台台站管理-台站管理")
public class BSiteController {

    @Autowired
    private SiteService siteService;


    /**
     * 模糊搜索所有字段，分页查询站点
     * 有归属地的用户 只能看到归属地下面的台站
     * @return
     */
    @GetMapping("/findAll/{current}")
    @ApiOperation(value = "分页查询台站信息", response = SiteVo.class)
    @Log(name = "台站管理", value = "分页查询台站信息")
    public ApiResult findAll(@PathVariable(value = "current") Integer current,String parameter,HttpServletRequest request) {

        Pager pager = new Pager();
        pager.setCurrent(current);
        pager.setParameter(parameter);

        Pager pager1 = this.siteService.findAll(pager,request);
        ApiResult apiResult = ApiResult.SUCCESS();
        apiResult.setData(pager1);
        return apiResult;

    }


    /**
     * 新增站点
     */
    @ApiOperation(value = "新增台站")
    @PostMapping("/addSite")
    @Log(name = "台站管理", value = "新增台站")
    public ApiResult insertOrderList(@RequestBody SiteVo siteVo, HttpServletRequest request) {
        ApiResult apiResult;
        int i = this.siteService.addSite(siteVo,request);
        if (i > 0) {
            apiResult = ApiResult.SUCCESS();
        }else {
            apiResult = ApiResult.FAIL();
        }
        return apiResult;
    }


    /**
     * 编辑台站
     */
    @ApiOperation(value = "编辑台站")
    @PutMapping("/updateSite")
    @Log(name = "台站管理", value = "编辑台站")
    public ApiResult updateSite(@RequestBody SiteVo siteVo, HttpServletRequest request) {
        ApiResult apiResult;
        int i = this.siteService.updateSite(siteVo,request);
        if (i > 0) {
            apiResult = ApiResult.SUCCESS();
        }else {
            apiResult = ApiResult.FAIL();
        }
        return apiResult;
    }


    @ApiOperation(value = "删除台站图片")
    @DeleteMapping("/deleteSiteImg/{resourceId}")
    @Log(name = "台站管理", value = "删除台站图片")
    public ApiResult deleteSiteImgById(@PathVariable(value = "resourceId") Long resourceId, HttpServletRequest request) {
        ApiResult apiResult;
        int i = this.siteService.deleteSiteImgById(resourceId,request);
        if (i > 0) {
            apiResult = ApiResult.SUCCESS();
        }else {
            apiResult = ApiResult.FAIL();
        }
        return apiResult;
    }


    @ApiOperation(value = "根据id查看台站信息",response = SiteVo.class)
    @GetMapping("/findSite/{siteId}")
    @Log(name = "台站管理", value = "根据id查看台站信息")
    public ApiResult findSiteById(@PathVariable(value = "siteId") Long siteId, HttpServletRequest request) {

        SiteVo siteVo = this.siteService.findSiteById(siteId,request);
        ApiResult apiResult = ApiResult.SUCCESS();
        apiResult.setData(siteVo);
        return apiResult;
    }

    /**
     * 根据台站id  查询巡检记录
     */
    @ApiOperation(value = "根据台站id查询巡检记录", response = PatrolTask.class)
    @GetMapping("/findPatrolTask/{current}")
    @Log(name = "台站管理", value = "根据台站id查询巡检记录")
    public ApiResult findPatrolTaskById(@PathVariable(value = "current") Integer current,String parameter, HttpServletRequest request) {
        Pager pager = new Pager();
        pager.setCurrent(current);
        pager.setParameter(parameter);

        Pager p = this.siteService.findPatrolTaskById(pager,request);
        ApiResult apiResult = ApiResult.SUCCESS();
        apiResult.setData(p);
        return apiResult;
    }


    /**
     * 根据台站id  删除台站
     */
    @ApiOperation(value = "根据台站id删除台站")
    @DeleteMapping("/delete/{siteId}")
    @Log(name = "台站管理", value = "根据台站id删除台站")
    public ApiResult deleteById(@PathVariable(value = "siteId") Long siteId, HttpServletRequest request) {

        this.siteService.deleteById(siteId,request);
        ApiResult apiResult = ApiResult.SUCCESS();
        return apiResult;
    }

    /**
     * 根据台站id  查询设备列表
     */
    @ApiOperation(value = "根据台站id查询设备列表",response = DeviceVo.class)
    @GetMapping("/findDevices/{current}")
    @Log(name = "台站管理", value = "根据台站id查询设备列表")
    public ApiResult findDevicesById(@PathVariable(value = "current") Integer current,String parameter, HttpServletRequest request) {
        Pager pager = new Pager();
        pager.setCurrent(current);
        pager.setParameter(parameter);

        Pager p = this.siteService.findDevicesById(pager,request);
        ApiResult apiResult = ApiResult.SUCCESS();
        apiResult.setData(p);
        return apiResult;
    }

}
