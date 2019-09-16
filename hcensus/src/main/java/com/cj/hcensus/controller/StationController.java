package com.cj.hcensus.controller;

import com.cj.core.aop.Log;
import com.cj.core.domain.ApiResult;
import com.cj.core.domain.ResultUtil;
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
 * @Description: 站点情况统计
 * @date： 2019/5/23 9:07
 **/
@RestController
@RequestMapping("/b-census/api/v1/station")
@Api(tags = "后台-统计模块: 站点情况统计")
public class StationController {

    @Autowired
    private CensusService censusService;

    /**
     * 统计台站状态
     * @param parameters
     * @return
     */
    @ApiOperation(value = "统计台站状态",response = StaCensusModel.class)
    @GetMapping("/findCensusS")
    @ApiImplicitParam(name = "parameters",value = "pid 省id cid 市id",
            required = true,
            defaultValue = "{\"pid\":1,\"cid\":1}")
    @Log(name = "站点情况统计",value = "统计台站状态")
    public ApiResult findCensusS(String parameters){
        Map map = new Gson().fromJson(parameters,Map.class);
        return ResultUtil.result(censusService.findCensusS(map));
    }

    /**
     * 导出统计台站状态
     * @param parameters
     * @param response
     * @return
     */
    @ApiOperation(value = "导出统计台站状态",response = StaCensusModel.class)
    @GetMapping("/importS")
    @ApiImplicitParam(name = "parameters",value = "pid 省id cid 市id",
            required = true,
            defaultValue = "{\"pid\":1,\"cid\":1}")
    @Log(name = "站点情况统计",value = "导出统计台站状态")
    public ApiResult importS(String parameters,HttpServletResponse response){
        Map map = new Gson().fromJson(parameters,Map.class);
        return ResultUtil.result(censusService.importS(map,response));
    }
}
