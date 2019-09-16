package com.cj.hafter.controller;

import com.cj.core.aop.Log;
import com.cj.core.domain.ApiResult;
import com.cj.core.domain.Pager;
import com.cj.hafter.entity.DeclareVo;
import com.cj.hafter.entity.RepairRecordVo;
import com.cj.hafter.service.BRecordsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 后台售后模块
 * Created by JuLei on 2019/5/28.
 */
@RestController
@RequestMapping("/b-sale/api/v1/records")
@Api(tags = "后台售后管理-售后记录管理")
public class BRecordsController {

    @Autowired
    private BRecordsService bRecordsService;

    @GetMapping("/findAll/{current}")
    @ApiOperation(value = "分页查询售后记录", response = DeclareVo.class)
    @Log(name = "售后记录管理", value = "分页查询售后记录")
    public ApiResult findAll(@PathVariable(value = "current") Integer current, String parameter, HttpServletRequest request) {

        Pager pager = new Pager();
        pager.setCurrent(current);
        pager.setParameter(parameter);

        Pager pager1 = this.bRecordsService.findAll(pager,request);
        ApiResult apiResult = ApiResult.SUCCESS();
        apiResult.setData(pager1);
        return apiResult;

    }


    @GetMapping("/findNumById/{declareId}")
    @ApiOperation(value = "查询处理次数列表")
    @Log(name = "售后记录管理", value = "查询处理次数列表")
    public ApiResult findNumById(@PathVariable(value = "declareId") Long declareId, HttpServletRequest request) {



        List<Map> maps = this.bRecordsService.findNumById(declareId,request);
        ApiResult apiResult = ApiResult.SUCCESS();
        apiResult.setData(maps);
        return apiResult;

    }


    @GetMapping("/findRecordsById/{saleNumId}")
    @ApiOperation(value = "查询处理详情", response = RepairRecordVo.class)
    @Log(name = "售后记录管理", value = "查询处理详情")
    public ApiResult findRecordsById(@PathVariable(value = "saleNumId") Long saleNumId, HttpServletRequest request) {



        List<RepairRecordVo> list = this.bRecordsService.findRecordsById(saleNumId,request);
        ApiResult apiResult = ApiResult.SUCCESS();
        apiResult.setData(list);
        return apiResult;

    }

    /**
     * 编辑处理详情
     */
    @ApiOperation(value = "编辑处理详情")
    @PutMapping("/updateRecord")
    @Log(name = "售后申报管理", value = "编辑处理详情")
    public ApiResult updateRecord(@RequestBody RepairRecordVo repairRecordVo, HttpServletRequest request) {
        ApiResult apiResult;
        int i = this.bRecordsService.updateRecord(repairRecordVo,request);
        if (i > 0) {
            apiResult = ApiResult.SUCCESS();
        }else {
            apiResult = ApiResult.FAIL();
        }
        return apiResult;
    }


    /**
     * 删除售后图片或视频
     */
    @ApiOperation(value = "删除售后图片或视频")
    @DeleteMapping("/deleteSaleImg/{resourceId}")
    @Log(name = "售后申报管理", value = "删除售后图片或视频")
    public ApiResult deleteSaleImg(@PathVariable(value = "resourceId") Long resourceId, HttpServletRequest request) {
        ApiResult apiResult;
        int i = this.bRecordsService.deleteSaleImg(resourceId,request);
        if (i > 0) {
            apiResult = ApiResult.SUCCESS();
        }else {
            apiResult = ApiResult.FAIL();
        }
        return apiResult;
    }

}
