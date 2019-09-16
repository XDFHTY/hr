package com.cj.common.controller;

import com.cj.common.domain.AdmainModel;
import com.cj.common.service.FUService;
import com.cj.core.aop.Log;
import com.cj.core.domain.ApiResult;
import com.cj.core.domain.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author： 刘磊
 * @Description: 人员查询
 * @date： 2019/5/28 14:10
 **/
@RestController
@RequestMapping("/common/api/v1/fu")
@Api(tags = "公共接口: 人员查询")
public class FUController {

    @Autowired
    private FUService fuService;


    /**
     * 根据角色id和部门id查询
     * @param pid 角色id
     * @param cid 部门id
     * @return
     */
    @ApiOperation(value = "查询员工列表",response = AdmainModel.class)
    @GetMapping("/findUser/{pid}/{cid}")
    @Log(name = "人员查询", value = "查询员工列表")
    public ApiResult findUser(@PathVariable(value = "pid") Long pid,
                              @PathVariable(value = "cid") Long cid){

        return ResultUtil.result(fuService.findUser(pid,cid));
    }

}
