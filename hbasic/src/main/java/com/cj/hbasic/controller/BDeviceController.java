package com.cj.hbasic.controller;

import com.cj.core.aop.Log;
import com.cj.core.domain.ApiResult;
import com.cj.core.domain.Pager;
import com.cj.core.entity.Site;
import com.cj.hbasic.domian.DeviceVo;
import com.cj.hbasic.domian.SiteVo;
import com.cj.hbasic.service.DeviceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 设备管理-后台
 * Created by win9 on 2019/5/22.
 */
@RestController
@RequestMapping("/b-site/api/v1/device")
@Api(tags = "后台台站管理-设备管理")
public class BDeviceController {

    @Autowired
    private DeviceService deviceService;

    /**
     * 分页查询归属地下的 设备列表
     */
    @GetMapping("/findAll/{current}")
    @ApiOperation(value = "分页查询设备信息", response = DeviceVo.class)
    @Log(name = "设备管理", value = "分页查询设备信息")
    public ApiResult findAll(@PathVariable(value = "current") Integer current, String parameter, HttpServletRequest request) {

        Pager pager = new Pager();
        pager.setCurrent(current);
        pager.setParameter(parameter);

        Pager pager1 = this.deviceService.findAll(pager,request);
        ApiResult apiResult = ApiResult.SUCCESS();
        apiResult.setData(pager1);
        return apiResult;

    }

    /**
     * 根据设备id 查询设备详情
     */
    @ApiOperation(value = "根据设备id查询设备详情",response = DeviceVo.class)
    @GetMapping("/findDevices/{deviceId}")
    @Log(name = "设备管理", value = "根据设备id查询设备详情")
    public ApiResult findDevicesById(@PathVariable(value = "deviceId") Integer deviceId, HttpServletRequest request) {
        DeviceVo deviceVo = this.deviceService.findDevicesById(deviceId,request);
        ApiResult apiResult = ApiResult.SUCCESS();
        apiResult.setData(deviceVo);
        return apiResult;
    }


    /**
     * 新增设备
     */
    @ApiOperation(value = "新增设备")
    @PostMapping("/addDevice")
    @Log(name = "设备管理", value = "新增设备")
    public ApiResult addDevice(@RequestBody DeviceVo deviceVo, HttpServletRequest request) {
        ApiResult apiResult;
        int i = this.deviceService.addSite(deviceVo,request);
        if (i > 0) {
            apiResult = ApiResult.SUCCESS();
        }else {
            apiResult = ApiResult.FAIL();
        }
        return apiResult;
    }


    /**
     * 删除设备图片
     */
    @ApiOperation(value = "删除设备图片")
    @DeleteMapping("/deleteDeviceImg/{resourceId}")
    @Log(name = "设备管理", value = "删除设备图片")
    public ApiResult deleteDeviceImg(@PathVariable(value = "resourceId") Long resourceId, HttpServletRequest request) {
        ApiResult apiResult;
        int i = this.deviceService.deleteDeviceImgById(resourceId,request);
        if (i > 0) {
            apiResult = ApiResult.SUCCESS();
        }else {
            apiResult = ApiResult.FAIL();
        }
        return apiResult;
    }



    /**
     * 编辑设备
     */
    @ApiOperation(value = "编辑设备")
    @PutMapping("/updateDevice")
    @Log(name = "设备管理", value = "编辑设备")
    public ApiResult updateDevice(@RequestBody DeviceVo deviceVo, HttpServletRequest request) {
        ApiResult apiResult;
        int i = this.deviceService.updateSite(deviceVo,request);
        if (i > 0) {
            apiResult = ApiResult.SUCCESS();
        }else {
            apiResult = ApiResult.FAIL();
        }
        return apiResult;
    }



    /**
     * 删除设备
     */
    @ApiOperation(value = "根据设备id删除设备")
    @DeleteMapping("/delete/{deviceId}")
    @Log(name = "台站管理", value = "删除设备")
    public ApiResult deleteById(@PathVariable(value = "deviceId") Long deviceId, HttpServletRequest request) {

        this.deviceService.deleteById(deviceId,request);
        ApiResult apiResult = ApiResult.SUCCESS();
        return apiResult;
    }


}
