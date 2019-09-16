package com.cj.hcensus.controller;

import com.cj.core.aop.Log;
import com.cj.core.domain.ApiResult;
import com.cj.core.domain.ResultUtil;
import com.cj.hcensus.domain.RepCensusModel;
import com.cj.hcensus.domain.StaCensusModel;
import com.cj.hcensus.service.CensusService;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author： 刘磊
 * @Description: 维护情况统计
 * @date： 2019/5/23 9:08
 **/
@RestController
@RequestMapping("/b-census/api/v1/repair")
@Api(tags = "后台-统计模块: 维护情况统计")
public class RepairController {

    @Autowired
    private CensusService censusService;

    /**
     * 统计维护情况
     * @param parameters
     * @return
     */
    @ApiOperation(value = "统计维护情况",response = RepCensusModel.class)
    @GetMapping("/findCensusR")
    @ApiImplicitParam(name = "parameters",
            value = "pid 省id cid 市id " +
            "start 开始时间 end 结束时间 type 分类",
            required = true,
            defaultValue = "{\"pid\":1,\"cid\":1," +
                    "\"start\":\"2019-05-23 14:23:33\",\"end\":\"2019-05-23 14:23:33\"," +
                    "\"type\":1}")
    @Log(name = "维护情况统计",value = "统计维护情况")
    public ApiResult findCensusR(String parameters){
        Map map = new Gson().fromJson(parameters,Map.class);
        return ResultUtil.result(censusService.findCensusR(map));
    }

    /**
     * 导出维护情况统计
     * @param parameters
     * @param response
     * @return
     */
    @ApiOperation(value = "导出维护情况统计",response = RepCensusModel.class)
    @GetMapping("/importR")
    @ApiImplicitParam(name = "parameters",
            value = "pid 省id cid 市id " +
                    "start 开始时间 end 结束时间 type 分类",
            required = true,
            defaultValue = "{\"pid\":1,\"cid\":1," +
                    "\"start\":\"2019-05-23 14:23:33\",\"end\":\"2019-05-23 14:23:33\"," +
                    "\"type\":1}")
    @Log(name = "维护情况统计",value = "导出维护情况统计")
    public ApiResult importR(String parameters,HttpServletResponse response){
        Map map = new Gson().fromJson(parameters,Map.class);
        return ResultUtil.result(censusService.importR(map,response));
    }
}
