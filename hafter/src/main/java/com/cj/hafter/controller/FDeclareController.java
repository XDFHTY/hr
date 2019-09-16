package com.cj.hafter.controller;

import com.cj.core.aop.Log;
import com.cj.core.domain.ApiResult;
import com.cj.core.domain.Pager;
import com.cj.hafter.entity.DeclareVo;
import com.cj.hafter.service.AfterSaleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 前台售后模块
 * Created by JuLei on 2019/5/28.
 */
@RestController
@RequestMapping("/f-sale/api/v1/declare")
@Api(tags = "前台售后模块-申报管理")
public class FDeclareController {

    @Autowired
    private AfterSaleService afterSaleService;


    /**
     * 新增售后申报
     */
    @ApiOperation(value = "新增售后申报")
    @PostMapping("/addDeclare")
    @Log(name = "申报管理", value = "新增售后申报")
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

}
