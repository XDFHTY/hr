package com.cj.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* Created by lw 2019-05-20 16:26:45
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "auth_role")
public class AuthRole implements Serializable {
    /**
     * 权限角色表主键
     */
    @ApiModelProperty(name = "roleId",value = "权限角色表主键",dataType = "java.lang.Long")
    @TableId(type = IdType.AUTO)
    private Long roleId;

    /**
     * 系统使用的角色名ROLE_XXX
     */
    @ApiModelProperty(name = "roleName",value = "系统使用的角色名ROLE_XXX",dataType = "java.lang.String")
    private String roleName;

    /**
     * 角色等级
     */
    @ApiModelProperty(name = "roleGrade",value = "角色等级",dataType = "java.lang.String")
    private String roleGrade;

    /**
     * 状态 0-禁用 1-使用 默认1
     */
    @ApiModelProperty(name = "roleState",value = "状态 0-禁用 1-使用 默认1",dataType = "java.lang.String")
    private String roleState;

    private static final long serialVersionUID = 1L;
}