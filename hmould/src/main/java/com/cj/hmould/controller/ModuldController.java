package com.cj.hmould.controller;

import com.cj.core.aop.Log;
import com.cj.core.domain.ApiResult;
import com.cj.core.domain.Pager;
import com.cj.core.domain.ResultUtil;
import com.cj.core.entity.CheckItem;
import com.cj.hmould.domain.UpdateSiteModuldVo;
import com.cj.hmould.domain.VoModuleAndSiteMoule;
import com.cj.hmould.service.ModuldService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/b-hmould/api/v1/mould")
@Api(tags = "模板管理: 后台模板管理")
public class ModuldController {

    @Resource
    private ModuldService moduldService;


    @GetMapping("/findSite/{pid}/{cid}/{siteTypeId}/{current}")
    @ApiOperation(value = "查询台站列表,省id,市id,台站类型id,页码")
    @Log(name = "模板管理", value = "查询台站列表")
    public ApiResult findSite(@PathVariable long pid,@PathVariable long cid,@PathVariable long siteTypeId,@PathVariable long current) {
        Pager<Map> pager = new Pager();
        Map map = new HashMap();
        map.put("pid",pid>0?pid:null);
        map.put("cid",cid>0?cid:null);
        map.put("siteTypeId",siteTypeId>0?siteTypeId:null);
        pager.setParameters(map);
        pager.setCurrent(current);
        return ResultUtil.result(moduldService.findSite(pager));
    }


    @GetMapping("/findModule/{siteId}")
    @ApiOperation(value = "查询系统及台站模板节点信息", response = VoModuleAndSiteMoule.class)
    @Log(name = "模板管理", value = "查询系统及台站模板节点信息")
    public ApiResult findModule(@PathVariable long siteId) {
        return ResultUtil.result(moduldService.findModuleAndSiteMoule(siteId));
    }

    @PutMapping("/updateSiteModuld")
    @ApiOperation("更新台站模板节点信息")
    @Log(name = "模板管理", value = "更新台站模板节点信息")
    public ApiResult updateSiteModuld(@RequestBody UpdateSiteModuldVo updateSiteModuldVo) {

        return ResultUtil.result(moduldService.UpdateSiteModuld(updateSiteModuldVo));
    }

    @PostMapping("/addChild")
    @ApiOperation("新增台站模板节点信息")
    @Log(name = "模板管理", value = "更新台站节点信息")
    public ApiResult addChild(@RequestBody CheckItem checkItem) {
        return ResultUtil.result(moduldService.addChild(checkItem));
    }

    @DeleteMapping("/delChild/{checkItemId}")
    @ApiOperation("删除台站模板节点信息")
    @Log(name = "模板管理", value = "删除台站模板节点信息")
    public ApiResult delChild(@PathVariable long checkItemId) {
        return ResultUtil.result(moduldService.delChild(checkItemId));
    }

    @PutMapping("/upChild")
    @ApiOperation("修改台站模板节点信息")
    @Log(name = "模板管理", value = "修改台站模板节点信息")
    public ApiResult upChild(@RequestBody CheckItem checkItem) {
        return ResultUtil.result(moduldService.upChild(checkItem));
    }


}
