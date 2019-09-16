package com.cj.hsys.domain;

import com.cj.core.entity.Admin;
import com.cj.core.entity.AdminInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "添加/修改 账号 参数")
public class VoAdmin {


    @ApiModelProperty(name = "adminId",value = "用户ID",dataType = "Long",required = true)
    private long adminId;


    @ApiModelProperty(name = "adminName",value = "用户名",dataType = "String",required = true)
    private String adminName;


    @ApiModelProperty(name = "roleId",value = "角色ID",dataType = "java.lang.Long",required = true)
    private Long roleId;


    @ApiModelProperty(name = "adminInfo",value = "姓名、手机号码、部门ID必填，省ID、市ID选填,",dataType = "AdminInfo")
    private AdminInfo adminInfo;
}
