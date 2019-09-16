package com.cj.common.controller;

import com.cj.common.domain.CSiteVo;
import com.cj.common.service.CSiteService;
import com.cj.core.aop.Log;
import com.cj.core.domain.ApiResult;
import com.cj.core.domain.Pager;
import com.cj.core.entity.Site;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 站点查询
 * Created by win9 on 2019/5/22.
 */
@RestController
@RequestMapping("/common/api/v1/site")
@Api(tags = "公共接口: 站点查询")
public class CSiteController {

    @Autowired
    private CSiteService siteService;

    /**
     * 按地区、类型查询站点列表
     */
    @GetMapping("/findAll/{type}/{pid}/{cid}")
    @ApiOperation(value = "按地区、类型查询站点列表")
    @Log(name = "公共接口", value = "按地区、类型查询站点列表")
    public ApiResult findAll(@PathVariable(value = "type") Integer type,
                             @PathVariable(value = "pid") Integer pid,
                             @PathVariable(value = "cid") Integer cid,
                             HttpServletRequest request) {

        List<CSiteVo> siteVoList = this.siteService.findAll(type,pid,cid,request);
        ApiResult apiResult = ApiResult.SUCCESS();
        apiResult.setData(siteVoList);
        return apiResult;

    }

}
