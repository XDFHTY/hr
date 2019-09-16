package com.cj.hafter.controller;

import com.cj.core.aop.Log;
import com.cj.core.domain.ApiResult;
import com.cj.core.domain.Pager;
import com.cj.core.domain.ResultUtil;
import com.cj.hafter.entity.BCModel;
import com.cj.hafter.entity.DeclareVo;
import com.cj.hafter.entity.RepairRecordVo;
import com.cj.hafter.service.AfterSaleService;
import com.cj.hafter.service.RecordsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 前台售后模块
 * Created by JuLei on 2019/5/28.
 */
@RestController
@RequestMapping("/f-sale/api/v1/records")
@Api(tags = "前台售后模块-售后记录管理")
public class FRecordsController {

    @Autowired
    private AfterSaleService afterSaleService;
    @Autowired
    private RecordsService recordsService;

    /**
     * 查询已完成和未完成的售后任务
     * 员工 ：可见所有未指派的任务 和 指派给他的任务
     * 办事处员工： 可见归属地下未指派的任务 和 指派给他的任务
     * 其他： 可见指派给他的任务
     * 状态：1-未完成和处理中  2-已完成
     */
    @GetMapping("/findAll/{current}")
    @ApiOperation(value = "分页查询售后任务", response = DeclareVo.class)
    @Log(name = "售后记录管理", value = "分页查询售后任务")
    public ApiResult findAll(@PathVariable(value = "current") Integer current,
                             String parameter,
                             HttpServletRequest request) {

        Pager pager = new Pager();
        pager.setCurrent(current);
        pager.setParameter(parameter);

        Pager pager1 = this.recordsService.findAll(pager,request);
        ApiResult apiResult = ApiResult.SUCCESS();
        apiResult.setData(pager1);
        return apiResult;

    }


    /**
     * 查询维修记录
     */
    @GetMapping("/findRepairRecord/{declareId}")
    @ApiOperation(value = "查询维修记录", response = RepairRecordVo.class)
    @Log(name = "售后记录管理", value = "查询维修记录")
    public ApiResult findRepairRecord(@PathVariable(value = "declareId") Long declareId,
                             HttpServletRequest request) {


        List<RepairRecordVo> list = this.recordsService.findRepairRecord(declareId,request);
        ApiResult apiResult = ApiResult.SUCCESS();
        apiResult.setData(list);
        return apiResult;

    }




    /**
     * 新增维修记录
     */
    @ApiOperation(value = "新增维修记录")
    @PostMapping("/addRepairRecord")
    @Log(name = "售后记录管理", value = "新增维修记录")
    public ApiResult insertRepairRecord(@RequestBody List<RepairRecordVo> recordVos, HttpServletRequest request) {
        ApiResult apiResult;
        int i = this.recordsService.insertRepairRecord(recordVos,request);
        if (i > 0) {
            apiResult = ApiResult.SUCCESS();
        }else {
            apiResult = ApiResult.FAIL();
        }
        return apiResult;
    }



    /**
     * 追加记录   修改描述 和 新增图片、视频
     */
    @ApiOperation(value = "追加记录")
    @PutMapping("/updateRepairRecord")
    @Log(name = "售后记录管理", value = "追加记录")
    public ApiResult updateRepairRecord(@RequestBody List<RepairRecordVo> recordVos, HttpServletRequest request) {
        ApiResult apiResult;
        int i = this.recordsService.updateRepairRecord(recordVos,request);
        if (i > 0) {
            apiResult = ApiResult.SUCCESS();
        }else {
            apiResult = ApiResult.FAIL();
        }
        return apiResult;
    }



    /**
     * 根据台站id查询历史申报列表
     */
    @GetMapping("/findAllBySiteId/{current}")
    @ApiOperation(value = "根据台站id查询历史任务列表", response = DeclareVo.class)
    @Log(name = "售后记录管理", value = "根据台站id查询历史任务列表")
    public ApiResult findAllBySiteId(@PathVariable(value = "current") Integer current,
                             String parameter,
                             HttpServletRequest request) {

        Pager pager = new Pager();
        pager.setCurrent(current);
        pager.setParameter(parameter);

        Pager pager1 = this.recordsService.findAllBySiteId(pager,request);
        ApiResult apiResult = ApiResult.SUCCESS();
        apiResult.setData(pager1);
        return apiResult;

    }


    /**
     * 修改任务状态
     */
    @ApiOperation(value = "修改任务状态")
    @PutMapping("/updateDeclareState")
    @Log(name = "售后记录管理", value = "修改任务状态")
    public ApiResult updateDeclareState(@RequestBody DeclareVo declareVo, HttpServletRequest request) {
        ApiResult apiResult;
        int i = this.recordsService.updateDeclareState(declareVo,request);
        if (i > 0) {
            apiResult = ApiResult.SUCCESS();
        }else {
            apiResult = ApiResult.FAIL();
        }
        return apiResult;
    }

    /**
     * 查询分类列表
     * @param parameter
     * @return
     */
    @ApiOperation(value = "查询分类列表",response = BCModel.class)
    @GetMapping("/findBC")
    @ApiParam(name = "parameter",value = "搜索结果",required = true)
    @Log(name = "售后分类管理",value = "查询分类列表")
    public ApiResult findBC(String parameter){
        return ResultUtil.result(afterSaleService.findBC(parameter));
    }

}
