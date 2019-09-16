package com.cj.hcensus.controller;

import com.cj.core.aop.Log;
import com.cj.core.domain.ApiResult;
import com.cj.core.domain.ResultUtil;
import com.cj.hcensus.domain.PatCensusModel;
import com.cj.hcensus.domain.RepCensusModel;
import com.cj.hcensus.service.CensusService;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author： 刘磊
 * @Description: 巡查情况统计
 * @date： 2019/5/23 9:08
 **/
@RestController
@RequestMapping("/b-census/api/v1/patrol")
@Api(tags = "后台-统计模块: 巡查情况统计")
public class PatrolController {

    @Autowired
    private CensusService censusService;
    /**
     * 统计巡查情况
     * @param parameters
     * @return
     */
    @ApiOperation(value = "统计巡查情况",response = PatCensusModel.class)
    @GetMapping("/findCensusP")
    @ApiImplicitParam(name = "parameters",
            value = "pid 省id cid 市id " +
                    "start 开始时间 end 结束时间",
            required = true,
            defaultValue = "{\"pid\":1,\"cid\":1," +
                    "\"start\":\"2019-05-23 14:23:33\",\"end\":\"2019-05-23 14:23:33\"}")
    @Log(name = "巡查情况统计",value = "统计巡查情况")
    public ApiResult findCensusP(String parameters){
        Map map = new Gson().fromJson(parameters,Map.class);
        return ResultUtil.result(censusService.findCensusP(map));
    }

    /**
     * 导出统计巡查情况
     * @param parameters
     * @param response
     */
    @ApiOperation(value = "导出统计巡查情况",response = PatCensusModel.class)
    @GetMapping("/importP")
    @ApiImplicitParam(name = "parameters",
            value = "pid 省id cid 市id " +
                    "start 开始时间 end 结束时间",
            required = true,
            defaultValue = "{\"pid\":1,\"cid\":1," +
                    "\"start\":\"2019-05-23 14:23:33\",\"end\":\"2019-05-23 14:23:33\"}")
    @Log(name = "巡查情况统计",value = "导出统计巡查情况")
    public ApiResult importP(String parameters,HttpServletResponse response){
        Map map = new Gson().fromJson(parameters,Map.class);
        return ResultUtil.result(censusService.importP(map,response));
    }
}
