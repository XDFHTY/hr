package com.cj.hafter.controller;

import com.cj.core.aop.Log;
import com.cj.core.domain.ApiResult;
import com.cj.core.domain.Pager;
import com.cj.hafter.entity.DeclareVo;
import com.cj.hafter.service.AfterSaleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 后台售后模块
 * Created by JuLei on 2019/5/28.
 */
@RestController
@RequestMapping("/b-sale/api/v1/declare")
@Api(tags = "后台售后管理-售后申报管理")
public class BDeclareController {

    @Autowired
    private AfterSaleService afterSaleService;


    /**
     * 新增售后申报
     */
    @ApiOperation(value = "新增售后申报")
    @PostMapping("/addDeclare")
    @Log(name = "售后申报管理", value = "新增售后申报")
    public ApiResult addDeclare(@RequestBody DeclareVo declareVo, HttpServletRequest request) {
        ApiResult apiResult;
        int i = this.afterSaleService.addDeclare(declareVo,request);
        if (i > 0) {
            apiResult = ApiResult.SUCCESS();
        }else {
            apiResult = ApiResult.FAIL();
        }
        return apiResult;
    }


    @GetMapping("/findAll/{current}")
    @ApiOperation(value = "分页查询售后申报", response = DeclareVo.class)
    @Log(name = "售后申报管理", value = "分页查询售后申报")
    public ApiResult findAll(@PathVariable(value = "current") Integer current,String parameter,HttpServletRequest request) {

        Pager pager = new Pager();
        pager.setCurrent(current);
        pager.setParameter(parameter);

        Pager pager1 = this.afterSaleService.findAll(pager,request);
        ApiResult apiResult = ApiResult.SUCCESS();
        apiResult.setData(pager1);
        return apiResult;

    }


    /**
     * 编辑  修改执行人 和 执行时间
     */
    @ApiOperation(value = "编辑(修改执行人和执行时间)")
    @PutMapping("/updateDeclare")
    @Log(name = "售后申报管理", value = "编辑(修改执行人和执行时间)")
    public ApiResult updateDeclare(@RequestBody DeclareVo declareVo, HttpServletRequest request) {
        ApiResult apiResult;
        int i = this.afterSaleService.update(declareVo,request);
        if (i > 0) {
            apiResult = ApiResult.SUCCESS();
        }else {
            apiResult = ApiResult.FAIL();
        }
        return apiResult;
    }

}
