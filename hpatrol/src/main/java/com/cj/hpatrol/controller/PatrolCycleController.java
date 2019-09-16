package com.cj.hpatrol.controller;

import com.cj.core.aop.Log;
import com.cj.core.domain.ApiResult;
import com.cj.core.domain.Pager;
import com.cj.core.domain.ResultUtil;
import com.cj.core.entity.PatrolCycle;
import com.cj.hpatrol.domain.PatrolCycleModel;
import com.cj.hpatrol.domain.PatrolTaskModel;
import com.cj.hpatrol.service.PatrolService;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author： 刘磊
 * @Description: 周期巡查管理
 * @date： 2019/5/20 17:34
 **/
@RestController
@RequestMapping("/b-patrol/api/v1/cycle")
@Api(tags = "后台-巡查模块: 周期巡查管理")
public class PatrolCycleController {

    @Autowired
    private PatrolService patrolService;
    /**
     * 新增周期巡查计划
     * @param json
     * @return
     */
    @ApiOperation(value = "新增周期巡查计划",response = PatrolCycleModel.class )
    @PostMapping("/inerstPatrolCycle")
    @Log(name = "周期巡查管理",value = "新增周期巡查计划")
    public ApiResult inerstPatrolCycle(@ApiParam(name = "json",
            value = "{\n" +
                    "        \"taskName\": \"测试任务名字1\",\n" +
                    "        \"provinceId\": 省id 552770,\n" +
                    "        \"patrolId\": \"执行人id 未指派不填594\",\n" +
                    "        \"startTime\": \"2019-05-21 16:49:25\",\n" +
                    "        \"endTime\": \"2019-05-21 16:49:27\",\n" +
                    "        \"cycle\": 周期 月/次int,\n" +
                    "        \"advance\": 提前天数int,\n" +
                    "        \"executeNum\": 执行次数添加时为0 int,\n" +
                    "        \"listPSM\": [\n" +
                    "          {\n" +
                    "            \"siteId\": 台站id1,\n" +
                    "            \"cityId\": 市id552771,\n" +
                    "            \"startTime\": \"2019-05-21 16:53:35\",\n" +
                    "            \"endTime\": \"2019-05-21 16:53:37\"\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"siteId\": 2,\n" +
                    "            \"cityId\": 552771,\n" +
                    "            \"startTime\": \"2019-05-21 16:53:35\",\n" +
                    "            \"endTime\": \"2019-05-21 16:53:37\"\n" +
                    "          },\n" +
                    "          {\n" +
                    "            \"siteId\": 3,\n" +
                    "            \"cityId\": 552771,\n" +
                    "            \"startTime\": \"2019-05-21 16:53:35\",\n" +
                    "            \"endTime\": \"2019-05-21 16:53:37\"\n" +
                    "          }\n" +
                    "        ]\n" +
                    "      }",required = true) @RequestBody PatrolCycleModel json, HttpSession session){
//        PatrolCycleModel patrolCycleModel = new Gson().fromJson(json,PatrolCycleModel.class);
        return ResultUtil.result(patrolService.inerstPatrolCycle(json,session));
    }

    /**
     * 删除周期巡查计划
     * @param list
     * @return
     */
    @ApiOperation(value = "删除周期巡查计划")
    @DeleteMapping("/deletePatrolCycle")
    @Log(name = "周期巡查管理",value = "删除周期巡查计划")
    public ApiResult deletePatrolCycle(@RequestBody List<Long> list){
        return ResultUtil.result(patrolService.deletePatrolCycle(list));
    }

    /**
     * 修改巡查人名字
     * @param patrolCycle
     * @return
     */
    @ApiOperation(value = "修改巡查人名字")
    @PutMapping("/updatePatrolName")
    @Log(name = "周期巡查管理",value = "修改巡查人名字")
    public ApiResult updatePatrolName(@ApiParam(name = "patrolCycle",
            value = "{\n" +
                    "  \"patrolCycleId\": 1,\n" +
                    "  \"patrolId\": \"666\"\n" +
                    "}",required = true) @RequestBody PatrolCycle patrolCycle){
        return ResultUtil.result(patrolService.updatePatrolName(patrolCycle));
    }

    /**
     * 查询周期巡查计划
     * @param current
     * @param parameter
     * @return
     */
    @ApiOperation(value = "查询周期巡查计划",response = PatrolCycleModel.class)
    @GetMapping("/findPatrolCycle/{current}")
    @Log(name = "周期巡查管理",value = "查询周期巡查计划")
    public ApiResult findPatrolCycle(@PathVariable int current ,String parameter){
        Pager pager = new Pager();
        pager.setCurrent(current);
        pager.setParameter(parameter);
        return ResultUtil.result(patrolService.findPatrolCycle(pager));
    }

}
