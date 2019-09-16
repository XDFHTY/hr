package com.cj.common.controller;

import com.cj.common.domain.VoRegion;
import com.cj.common.service.FindService;
import com.cj.core.aop.Log;
import com.cj.core.domain.ApiResult;
import com.cj.core.domain.ResultUtil;
import com.cj.core.entity.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/common/api/v1/tableMsg")
@Api(tags = "公共接口: 台站信息查询")
public class TableMsgController {

    @Resource
    private FindService findService;

    @GetMapping("/findAllDepartment")
    @ApiOperation(value = "查询部门列表", response = Department.class)
    @Log(name = "台站信息", value = "查询部门列表")
    public ApiResult findAllDepartment() {
        return ResultUtil.result(findService.findAllDepartment());

    }

    @GetMapping("/findAllItemNum")
    @ApiOperation(value = "查询项目编号", response = ItemNumber.class)
    @Log(name = "台站信息", value = "查询项目编号")
    public ApiResult findAllItemNum() {

        return ResultUtil.result(findService.findAllItemNum());
    }

    @GetMapping("/findAllSiteType")
    @ApiOperation(value = "查询台站类型", response = SiteType.class)
    @Log(name = "台站信息", value = "查询台站类型")
    public ApiResult findAllSiteType() {

        return ResultUtil.result(findService.findAllSiteType());
    }


    @GetMapping("/findAllSiteCompany")
    @ApiOperation(value = "查询台站所属单位", response = SiteCompany.class)
    @Log(name = "台站信息", value = "查询台站所属单位")
    public ApiResult findAllSiteCompany() {

        return ResultUtil.result(findService.findAllSiteCompany());
    }

    @GetMapping("/findAllSiteNature")
    @ApiOperation(value = "查询站点性质", response = SiteNature.class)
    @Log(name = "台站信息", value = "查询站点性质")
    public ApiResult findAllSiteNature() {

        return ResultUtil.result(findService.findAllSiteNature());
    }

    @GetMapping("/findAllSiteUsageState")
    @ApiOperation(value = "查询站点状态", response = SiteUsageState.class)
    @Log(name = "台站信息", value = "查询站点状态")
    public ApiResult findAllSiteUsageState() {

        return ResultUtil.result(findService.findAllSiteUsageState());
    }

    @GetMapping("/findAllProductModel")
    @ApiOperation(value = "查询产品型号", response = ProductModel.class)
    @Log(name = "台站信息", value = "查询产品型号")
    public ApiResult findAllProductModel() {

        return ResultUtil.result(findService.findAllProductModel());
    }


}
