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
@ApiModel(value = "查询人员列表 参数")
public class VoFindAdmin extends Admin {

//    @ApiModelProperty(name = "fullName",value = "姓名",dataType = "java.lang.String")
//    private String fullName;
//
//
//    @ApiModelProperty(name = "phone",value = "电话",dataType = "java.lang.String")
//    private String phone;


    @ApiModelProperty(name = "departmentName",value = "部门名称",dataType = "java.lang.String")
    private String departmentName;

    @ApiModelProperty(name = "roleId",value = "角色ID",dataType = "java.lang.Long")
    private long roleId;

    @ApiModelProperty(name = "roleName",value = "部门名称",dataType = "java.lang.String")
    private String roleName;

//    @ApiModelProperty(name = "provinceId",value = "省id",dataType = "java.lang.Long")
//    private long provinceId;
//
//    @ApiModelProperty(name = "cityId",value = "市id",dataType = "java.lang.Long")
//    private long cityId;


    @ApiModelProperty(name = "voAdminInfo",value = "姓名、手机号码、部门ID必填，省ID、市ID选填,",dataType = "AdminInfo")
    private VoAdminInfo voAdminInfo;
}
