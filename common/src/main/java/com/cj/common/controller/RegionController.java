package com.cj.common.controller;

import com.cj.common.domain.VoRegion;
import com.cj.common.service.RegionService;
import com.cj.core.aop.Log;
import com.cj.core.domain.ApiResult;
import com.cj.core.domain.ResultUtil;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/common/api/v1/area")
@Api(tags = "公共接口: 地区信息")
public class RegionController {


    @Resource
    private RegionService regionService;

    Gson gson = new Gson();

    @GetMapping("/region2")
    @ApiOperation(value = "查询所有地区信息二级", response = VoRegion.class)
    @Log(name = "地区信息", value = "查询所有地区信息二级")
    public ApiResult findAllRegion2() {


        return ResultUtil.result(regionService.findAllRegion2());

    }

    @GetMapping("/region3")
    @ApiOperation(value = "查询所有地区信息三级", response = VoRegion.class)
    @Log(name = "地区信息", value = "查询所有地区信息三级")
    public ApiResult findAllRegion3() {
        return ResultUtil.result(regionService.findAllRegion3());

    }
    @GetMapping("/regionp")
    @ApiOperation(value = "查询省信息", response = VoRegion.class)
    @Log(name = "地区信息", value = "查询省信息")
    public ApiResult findAllRegionP() {
        return ResultUtil.result(regionService.findAllRegionP());

    }
    @GetMapping("/regionc")
    @ApiOperation(value = "查询市信息", response = VoRegion.class)
    @Log(name = "地区信息", value = "查询市信息")
    @ApiImplicitParam(name = "pid",value = "省ID",required = true)
    public ApiResult findAllRegionC(long pid) {
        return ResultUtil.result(regionService.findAllRegionC(pid));

    }
    @GetMapping("/regiona")
    @ApiOperation(value = "查询区县信息", response = VoRegion.class)
    @Log(name = "地区信息", value = "查询区县信息")
    @ApiImplicitParam(name = "cid",value = "市ID",required = true)
    public ApiResult findAllRegionA(long cid) {
        return ResultUtil.result(regionService.findAllRegionA(cid));

    }
}
