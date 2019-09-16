package com.cj.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* Created by lw 2019-05-20 16:26:45
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "admin")
public class Admin implements Serializable {
    /**
     * 管理员基础表主键
     */
    @ApiModelProperty(name = "adminId",value = "管理员基础表主键",dataType = "java.lang.Long")
    @TableId(type = IdType.INPUT)
    private Long adminId;

    /**
     * 管理员账号
     */
    @ApiModelProperty(name = "adminName",value = "管理员账号",dataType = "java.lang.String")
    private String adminName;

    /**
     * 管理员密码
     */
    @ApiModelProperty(name = "adminPass",value = "管理员密码",dataType = "java.lang.String")
    private String adminPass;

    /**
     * 盐值
     */
    @ApiModelProperty(name = "saltVal",value = "盐值",dataType = "java.lang.String")
    private String saltVal;

    /**
     * 管理员分类，1-管理员（暂时不使用）
     */
    @ApiModelProperty(name = "adminType",value = "管理员分类，1-管理员（暂时不使用）",dataType = "java.lang.String")
    private String adminType;

    @ApiModelProperty(name = "operatorId",value = "操作员ID",dataType = "java.lang.Long")
    private Long operatorId;
    /**
     * 状态，1-正常，0-禁用（删除），-1-停用
     */
    @ApiModelProperty(name = "adminState",value = "状态，1-正常，0-禁用（删除），-1-停用",dataType = "java.lang.String")
    private String adminState;


    /**
     * 创建时间
     */
    @ApiModelProperty(name = "createTime",value = "创建时间",dataType = "java.util.Date")
    private Date createTime;

    /**
     * 最后更新时间
     */
    @ApiModelProperty(name = "updateTime",value = "最后更新时间",dataType = "java.util.Date")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}