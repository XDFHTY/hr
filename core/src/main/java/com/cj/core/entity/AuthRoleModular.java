package com.cj.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "角色-模块化关系表")
public class AuthRoleModular implements Serializable {
    /**
     * 角色-模块化关系表
     */
    @ApiModelProperty(name = "id",value = "id",dataType = "Long")
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 角色表主键id
     */
    @ApiModelProperty(name = "roleId",value = "角色表主键id",dataType = "Long")
    private Long roleId;

    /**
     * 模块化表主键id
     */
    @ApiModelProperty(name = "modularId",value = "模块化表主键id",dataType = "Long")
    private Long modularId;

}