package com.cj.hpatrol.controller;

import com.cj.core.aop.Log;
import com.cj.core.domain.ApiResult;
import com.cj.core.domain.Pager;
import com.cj.core.domain.ResultUtil;
import com.cj.core.entity.SiteCheckItemMsg;
import com.cj.hmould.domain.VoNames;
import com.cj.hmould.service.ModuldService;
import com.cj.hpatrol.domain.PatrolTaskModel;
import com.cj.hpatrol.service.PatrolService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author： 刘磊
 * @Description: 巡查记录管理
 * @date： 2019/5/21 17:45
 **/
@RestController
@RequestMapping("/b-patrol/api/v1/tasks")
@Api(tags = "后台-巡查模块: 巡查记录管理")
public class PatrolTaskSController {
    @Autowired
    private PatrolService patrolService;
    @Autowired
    private ModuldService moduldService;
    /**
     * 查询巡查记录
     * @param current
     * @param parameter
     * @return
     */
    @ApiOperation(value = "查询巡查记录",response = PatrolTaskModel.class)
    @GetMapping("/findPatrolTaskStation/{current}")
    @Log(name = "巡查记录管理",value = "查询巡查记录")
    public ApiResult findPatrolTaskStation(@PathVariable int current , String parameter){
        Pager pager = new Pager();
        pager.setCurrent(current);
        pager.setParameter(parameter);
        return ResultUtil.result(patrolService.findPatrolTaskStation(pager));
    }

    /**
     * 根据任务id查询巡查任务内容
     * @param patrolTaskStationId
     * @return
     */
    @ApiOperation(value = "根据任务id查询巡查任务内容",response = VoNames.class)
    @GetMapping("/findContent/{patrolTaskStationId}")
    @Log(name = "巡查记录管理",value = "根据任务id查询巡查任务内容")
    public ApiResult findContent(@PathVariable Long patrolTaskStationId){
        return ResultUtil.result(moduldService.findSiteCheckItemMsgByPatrolTaskStationId(patrolTaskStationId));
    }
    /**
     * 修改任务内容
     * @param json
     * @return
     */
    @ApiOperation(value = "修改任务内容",response = SiteCheckItemMsg.class )
    @PutMapping("/updateContent")
    @Log(name = "巡查记录管理",value = "修改任务内容")
    public ApiResult updateContent(@ApiParam(name = "json",
            value = "[\n" +
                    "  {\n" +
                    "    \"checkItemMsg\": \"string\",\n" +
                    "    \"checkItemName1\": \"string\",\n" +
                    "    \"checkItemName2\": \"string\",\n" +
                    "    \"checkItemName3\": \"string\",\n" +
                    "    \"checkItemName4\": \"string\",\n" +
                    "    \"checkItemResult\": \"string\",\n" +
                    "    \"patrolTaskStationId\": 0,\n" +
                    "    \"scimId\": 0\n" +
                    "  }\n" +
                    "]",required = true) @RequestBody List<SiteCheckItemMsg> json){
//        List<SiteCheckItemMsg> list = new Gson().fromJson(json,new TypeToken<List<SiteCheckItemMsg>>(){}.getType());
        return ResultUtil.result(moduldService.addSiteCheckItemMsg(json));
    }
}
