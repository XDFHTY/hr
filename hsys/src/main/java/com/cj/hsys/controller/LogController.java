package com.cj.hsys.controller;

import com.cj.core.aop.Log;
import com.cj.core.domain.ApiResult;
import com.cj.core.domain.Pager;
import com.cj.core.domain.ResultUtil;
import com.cj.core.entity.OperateLog;
import com.cj.core.service.LogService;
import com.cj.core.domain.VoLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/system/api/v1/log")
@Api(tags = "系统管理: 日志管理")
public class LogController {

    @Resource
    private LogService logService;


    @ApiOperation(value = "查询日志", response = OperateLog.class)
    @GetMapping("/findLog/{current}")
    @Log(name = "日志管理", value = "查询日志")
    public ApiResult findLog(@PathVariable long current) {
        Pager<VoLog> pager = new Pager<>();
        pager.setCurrent(current);
        return ResultUtil.result(logService.findLog(pager));
    }
}
