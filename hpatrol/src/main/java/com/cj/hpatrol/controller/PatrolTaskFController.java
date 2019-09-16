package com.cj.hpatrol.controller;

import com.cj.core.aop.Log;
import com.cj.core.domain.ApiResult;
import com.cj.core.domain.Pager;
import com.cj.core.domain.ResultUtil;
import com.cj.core.entity.SiteCheckItemMsg;
import com.cj.hmould.domain.VoCheckItem;
import com.cj.hmould.domain.VoNames;
import com.cj.hmould.service.ModuldService;
import com.cj.hpatrol.domain.PatrolTaskModel;
import com.cj.hpatrol.service.PatrolService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author： 刘磊
 * @Description: APP巡查管理
 * @date： 2019/5/22 16:00
 **/
@RestController
@RequestMapping("/f-patrol/api/v1/taskf")
@Api(tags = "APP-巡查模块: APP巡查管理")
public class PatrolTaskFController {

    @Autowired
    private PatrolService patrolService;

    @Autowired
    private ModuldService moduldService;
    /**
     * 查询巡查任务
     * @param current
     * @return
     */
    @ApiOperation(value = "查询巡查任务",response = PatrolTaskModel.class)
    @GetMapping("/findCycle/{current}")
    @Log(name = "APP巡查管理",value = "查询巡查任务")
    public ApiResult findCycle(@PathVariable int current ,HttpSession session){
        Pager pager = new Pager();
        pager.setCurrent(current);
        return ResultUtil.result(patrolService.findCycle(pager,session));
    }
    /**
     * 查询巡查任务历史
     * @param current
     * @return
     */
    @ApiOperation(value = "查询巡查任务历史",response = PatrolTaskModel.class)
    @GetMapping("/findHistory/{current}")
    @Log(name = "APP巡查管理",value = "查询巡查任务历史")
    public ApiResult findHistory(@PathVariable int current ,HttpSession session){
        Pager pager = new Pager();
        pager.setCurrent(current);
        return ResultUtil.result(patrolService.findHistory(pager,session));
    }

    /**
     * 根据台站查询巡查任务
     * @param current
     * @param parameter
     * @return
     */
    @ApiOperation(value = "根据台站查询巡查任务",response = PatrolTaskModel.class)
    @GetMapping("/findBySiteId/{current}")
    @Log(name = "APP巡查管理",value = "根据台站查询巡查任务")
    public ApiResult findBySiteId(@PathVariable int current , String parameter,HttpSession session){
        Pager pager = new Pager();
        pager.setCurrent(current);
        pager.setParameter(parameter);
        return ResultUtil.result(patrolService.findBySiteId(pager,session));
    }

    /**
     * 根据台站查询巡查任务模板
     * @param siteId
     * @return
     */
    @ApiOperation(value = "根据台站查询巡查任务模板",response = VoCheckItem.class)
    @GetMapping("/findModel/{siteId}")
    @Log(name = "APP巡查管理",value = "根据台站查询巡查任务模板")
    public ApiResult findModel(@PathVariable Long siteId,HttpSession session){
        String roles = ((List<Map>)session.getAttribute("roles"))
                .get(0)
                .get("roleName")
                .toString();
        return ResultUtil.result(moduldService.findModuldBySiteId(siteId,roles));
    }

    /**
     * 根据任务id查询巡查任务内容
     * @param patrolTaskStationId
     * @return
     */
    @ApiOperation(value = "根据任务id查询巡查任务内容",response = VoNames.class)
    @GetMapping("/findContent/{patrolTaskStationId}")
    @Log(name = "APP巡查管理",value = "根据任务id查询巡查任务内容")
    public ApiResult findContent(@PathVariable Long patrolTaskStationId){
        return ResultUtil.result(moduldService.findSiteCheckItemMsgByPatrolTaskStationId(patrolTaskStationId));
    }
    /**
     * 新增任务内容
     * @param list
     * @return
     */
    @ApiOperation(value = "新增任务内容",response = SiteCheckItemMsg.class )
    @PostMapping("/insertContent")
    @Log(name = "APP巡查管理",value = "新增任务内容")
    public ApiResult insertContent(@ApiParam(name = "json",
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
                    "]",required = true) List<SiteCheckItemMsg> list){
        return ResultUtil.result(moduldService.addSiteCheckItemMsg(list));
    }

    /**
     * 签到 1 到站 2离站
     * @param i 1-到站 2-离站
     * @param id 台站任务id
     * @return
     */
    @ApiOperation(value = "签到")
    @PutMapping("/sign/{i}/{id}")
    @Log(name = "APP巡查管理",value = "签到")
    public ApiResult sign(@PathVariable int i,@PathVariable Long id){
        return ResultUtil.result(patrolService.sign(i,id));
    }
}
