package com.cj.hpatrol.controller;

import com.cj.core.aop.Log;
import com.cj.core.domain.ApiResult;
import com.cj.core.domain.Pager;
import com.cj.core.domain.ResultUtil;
import com.cj.hpatrol.domain.PatrolTaskModel;
import com.cj.hpatrol.service.PatrolService;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author： 刘磊
 * @Description: 巡查任务管理
 * @date： 2019/5/21 17:43
 **/
@RestController
@RequestMapping("/b-patrol/api/v1/task")
@Api(tags = "后台-巡查模块: 巡查任务管理")
public class PatrolTaskController {
    @Autowired
    private PatrolService patrolService;

    /**
     * 新增专项巡查计划
     * @param json
     * @return
     */
    @ApiOperation(value = "新增专项巡查计划",response = PatrolTaskModel.class )
    @PostMapping("/inerstPatrolTask")
    @Log(name = "巡查任务管理",value = "新增专项巡查计划")
    public ApiResult inerstPatrolTask(@ApiParam(name = "json",
            value = "{\n" +
                    "        \"taskName\": \"测试任务名字2\",\n" +
                    "        \"patrolId\": 767,\n" +
                    "        \"provinceId\": 552770,\n" +
                    "        \"taskType\": \"专项任务\",\n" +
                    "        \"startTime\": \"2019-05-22 11:28:30\",\n" +
                    "        \"endTime\": \"2019-05-22 11:28:32\",\n" +
                    "        \"listTSM\": [\n" +
                    "          {\n" +
                    "            \"siteId\": 1,\n" +
                    "            \"patrolId\": 767,\n" +
                    "            \"patrolState\": \"0\"\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"siteId\": 2,\n" +
                    "            \"patrolId\": 767,\n" +
                    "            \"patrolState\": \"0\"\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"siteId\": 3,\n" +
                    "            \"patrolId\": 767,\n" +
                    "            \"patrolState\": \"0\"\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }",required = true) @RequestBody PatrolTaskModel json){
//        PatrolTaskModel patrolTaskModel = new Gson().fromJson(json,PatrolTaskModel.class);
        return ResultUtil.result(patrolService.inerstPatrolTask(json));
    }

    /**
     * 删除专项巡查计划
     * @param list
     * @return
     */
    @ApiOperation(value = "删除专项巡查计划")
    @DeleteMapping("/deletePatrolTask")
    @Log(name = "巡查任务管理",value = "删除专项巡查计划")
    public ApiResult deletePatrolTask(@RequestBody List<Long> list){
        return ResultUtil.result(patrolService.deletePatrolTask(list));
    }

    /**
     * 查询专项巡查计划
     * @param current
     * @param parameter
     * @return
     */
    @ApiOperation(value = "查询专项巡查计划",response = PatrolTaskModel.class)
    @GetMapping("/findPatrolTask/{current}")
    @Log(name = "巡查任务管理",value = "查询专项巡查计划")
    public ApiResult findPatrolTask(@PathVariable int current ,String parameter){
        Pager pager = new Pager();
        pager.setCurrent(current);
        pager.setParameter(parameter);
        return ResultUtil.result(patrolService.findPatrolTask(pager));
    }
}
