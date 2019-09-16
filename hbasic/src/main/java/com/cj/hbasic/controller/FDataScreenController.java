package com.cj.hbasic.controller;

import com.cj.core.aop.Log;
import com.cj.core.domain.ApiResult;
import com.cj.hbasic.domian.SiteVo;
import com.cj.hbasic.service.SiteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 前台 数据大屏 模块
 * Created by win9 on 2019/5/22.
 */
@RestController
@RequestMapping("/f-screen/api/v1/info")
@Api(tags = "前台数据大屏")
public class FDataScreenController {


    @Autowired
    private SiteService siteService;


    /**
     * 根据省、市 、台站类型   查询所有台站信息 和 站点状态统计
     */
    @ApiOperation(value = "查询数据大屏和统计")
    @GetMapping("/findDataScreen/{pid}/{cid}/{siteTypeId}")
    @Log(name = "数据大屏", value = "查询数据大屏和统计")
    public ApiResult findDataScreen(@PathVariable(value = "pid") Integer pid,
                                    @PathVariable(value = "cid") Integer cid,
                                    @PathVariable(value = "siteTypeId") Integer siteTypeId, HttpServletRequest request) {

        Map siteVo = this.siteService.findDataScreen(pid,cid,siteTypeId,request);
        ApiResult apiResult = ApiResult.SUCCESS();
        apiResult.setData(siteVo);
        return apiResult;
    }

    /**
     * 根据台站id 查看详情  查询 最后维护时间和维护人
     * 员工可以看  其他角色不能看  数据库权限配置
     */
    @ApiOperation(value = "根据id查看台站详情",response = SiteVo.class)
    @GetMapping("/findSite/{siteId}")
    @Log(name = "数据大屏", value = "根据id查看台站详情")
    public ApiResult findSiteById(@PathVariable(value = "siteId") Long siteId, HttpServletRequest request) {

        SiteVo siteVo = this.siteService.findSiteById(siteId,request);
        ApiResult apiResult = ApiResult.SUCCESS();
        apiResult.setData(siteVo);
        return apiResult;
    }


}
