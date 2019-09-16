package com.cj.hbasic.controller;

import com.cj.core.aop.Log;
import com.cj.core.domain.ApiResult;
import com.cj.core.domain.Pager;
import com.cj.core.entity.Resources;
import com.cj.hbasic.domian.DeviceVo;
import com.cj.hbasic.domian.ResourcesVo;
import com.cj.hbasic.domian.SiteVo;
import com.cj.hbasic.service.DocumentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * 文档管理
 * Created by JuLei on 2019/6/3.
 */
@RestController
@RequestMapping("/b-document/api/v1/info")
@Api(tags = "后台-文档管理")
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @GetMapping("/findAll/{current}")
    @ApiOperation(value = "分页查询文档列表", response = ResourcesVo.class)
    @Log(name = "文档管理", value = "分页查询文档列表")
    public ApiResult findAll(@PathVariable(value = "current") Integer current, String parameter, HttpServletRequest request) {

        Pager pager = new Pager();
        pager.setCurrent(current);
        pager.setParameter(parameter);

        Pager pager1 = this.documentService.findAll(pager,request);
        ApiResult apiResult = ApiResult.SUCCESS();
        apiResult.setData(pager1);
        return apiResult;

    }

    @ApiOperation(value = "上传文档")
    @PostMapping("/addDocument")
    @Log(name = "文档管理", value = "上传文档")
    public ApiResult addDocument(@RequestBody ResourcesVo resourcesVo, HttpServletRequest request) {
        ApiResult apiResult;
        int i = this.documentService.addDocument(resourcesVo,request);
        if (i > 0) {
            apiResult = ApiResult.SUCCESS();
        }else {
            apiResult = ApiResult.FAIL();
        }
        return apiResult;
    }


    /**
     * 删除文档
     */
    @ApiOperation(value = "删除文档")
    @DeleteMapping("/delete/{resourceIds}")
    @Log(name = "文档管理", value = "删除文档")
    public ApiResult deleteById(@PathVariable(value = "resourceIds") String resourceIds, HttpServletRequest request) {
        String[] split = resourceIds.split(",");
        List<String> ids = Arrays.asList(split);

        this.documentService.deleteById(ids,request);
        ApiResult apiResult = ApiResult.SUCCESS();
        return apiResult;
    }

}
