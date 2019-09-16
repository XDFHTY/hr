package com.cj.hafter.controller;

import com.cj.core.aop.Log;
import com.cj.core.domain.ApiResult;
import com.cj.core.domain.ResultUtil;
import com.cj.core.entity.SaleType;
import com.cj.hafter.entity.BCModel;
import com.cj.hafter.service.AfterSaleService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.List;

/**
 * 后台售后模块
 * Created by JuLei on 2019/5/28.
 */
@RestController
@RequestMapping("/b-sale/api/v1/classify")
@Api(tags = "后台售后管理-售后分类管理")
public class BClassifyController {


    @Autowired
    private AfterSaleService afterSaleService;

    /**
     * 新增售后分类
     * @param list
     * @return
     */
    @ApiOperation(value = "新增售后分类",response = SaleType.class)
    @PostMapping("/insertBC")
    @Log(name = "售后分类管理", value = "新增售后分类")
    public ApiResult insertBC(@ApiParam(name = "json",
            value = "addState 可以不传 传就写2" +
                    "level 一级 1 二级 2 三级 3 int类型" +
                    "parentId 父id 一级传1" +
                    "saleTypeName 分类名",required = true) @RequestBody List<SaleType> list){
        //List<SaleType> list = new Gson().fromJson(json,new TypeToken<List<SaleType>>(){}.getType());
        return ResultUtil.result(afterSaleService.insertBC(list));
    }
    /**
     * 修改售后分类
     * @param json
     * @return
     */
    @ApiOperation(value = "修改售后分类",response = SaleType.class)
    @PutMapping("/updateBC")
    @Log(name = "售后分类管理", value = "修改售后分类")
    public ApiResult updateBC(@ApiParam(name = "json",
            value = "{\n" +
                    "    \"saleTypeId\": 0,\n" +
                    "    \"saleTypeName\": \"string\"\n" +
                    "  }",required = true) @RequestBody SaleType json){
//        SaleType saleType = new Gson().fromJson(json,SaleType.class);
        return ResultUtil.result(afterSaleService.updateBC(json));
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



    /**
     *  功能描述：导入售后分类
     *  参数：Excel文件
     *  返回：导入成功或失败
     */
    @ApiOperation("导入售后分类")
    @Log(name = "售后分类管理 ==> 导入售后分类")
    @ApiParam(value = "导入售后分类",required = true)
    @PostMapping("/importInfo")
    public ApiResult importInfo(MultipartFile file, HttpServletRequest request){

        //返回对象
        ApiResult apiResult;

        if(file == null) {
            apiResult = ApiResult.FAIL(); //没有数据
            apiResult.setMsg("没有数据");
            return apiResult;
        }
        try{
            //获取文件流
            InputStream in = file.getInputStream();
            apiResult = this.afterSaleService.importInfo(file, in);
        }catch (Exception e){ //异常处理
            apiResult = ApiResult.FAIL();
            e.printStackTrace();
        }
        return apiResult;
    }
}
