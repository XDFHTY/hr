package com.cj.hbasic.controller;

import com.cj.core.aop.Log;
import com.cj.core.domain.ApiResult;
import com.cj.core.domain.Pager;
import com.cj.hbasic.domian.DeviceVo;
import com.cj.hbasic.domian.SiteVo;
import com.cj.hbasic.service.DeviceService;
import com.cj.hbasic.service.SiteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 前台 台站管理
 * Created by win9 on 2019/5/22.
 */
@RestController
@RequestMapping("/f-site/api/v1/site")
@Api(tags = "巡查预览-巡查预览")
public class FSiteController {

    @Autowired
    private SiteService siteService;


    @Autowired
    private DeviceService deviceService;

    /**
     * 根据台站id 查台站详情
     */
    @ApiOperation(value = "根据id查看台站信息",response = SiteVo.class)
    @GetMapping("/findSite/{siteId}")
    @Log(name = "巡查预览", value = "根据id查看台站信息")
    public ApiResult findSiteById(@PathVariable(value = "siteId") Long siteId, HttpServletRequest request) {

        SiteVo siteVo = this.siteService.findSiteById(siteId,request);
        ApiResult apiResult = ApiResult.SUCCESS();
        apiResult.setData(siteVo);
        return apiResult;
    }



    /**
     * 根据台站id  查询设备列表
     */
    @ApiOperation(value = "根据台站id查询设备列表",response = DeviceVo.class)
    @GetMapping("/findDevices/{current}")
    @Log(name = "巡查预览", value = "根据台站id查询设备列表")
    public ApiResult findDevicesById(@PathVariable(value = "current") Integer current,String parameter, HttpServletRequest request) {
        Pager pager = new Pager();
        pager.setCurrent(current);
        pager.setParameter(parameter);

        Pager p = this.siteService.findDevicesById(pager,request);
        ApiResult apiResult = ApiResult.SUCCESS();
        apiResult.setData(p);
        return apiResult;
    }



    /**
     * 根据设备id 查询设备详情
     */
    @ApiOperation(value = "根据设备id查询设备详情",response = DeviceVo.class)
    @GetMapping("/findDevice/{deviceId}")
    @Log(name = "巡查预览", value = "根据设备id查询设备详情")
    public ApiResult findDevicesById(@PathVariable(value = "deviceId") Integer deviceId, HttpServletRequest request) {
        DeviceVo deviceVo = this.deviceService.findDevicesById(deviceId,request);
        ApiResult apiResult = ApiResult.SUCCESS();
        apiResult.setData(deviceVo);
        return apiResult;
    }
}
