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
@ApiModel(value = "admin_info")
public class AdminInfo implements Serializable {
    /**
     * 管理员扩展信息表主键
     */
    @ApiModelProperty(name = "adminInfoId",value = "管理员扩展信息表主键",dataType = "java.lang.Long")
    @TableId(type = IdType.AUTO)
    private Long adminInfoId;

    /**
     * 管理员id
     */
    @ApiModelProperty(name = "adminId",value = "管理员id",dataType = "java.lang.Long")
    private Long adminId;

    /**
     * 所属部门id
     */
    @ApiModelProperty(name = "departmentId",value = "所属部门id",dataType = "java.lang.Long")
    private Long departmentId;

    /**
     * 管理员姓名
     */
    @ApiModelProperty(name = "fullName",value = "管理员姓名",dataType = "java.lang.String")
    private String fullName;

    /**
     * 管理员电话
     */
    @ApiModelProperty(name = "phone",value = "管理员电话",dataType = "java.lang.String")
    private String phone;

    /**
     * 归属省id
     */
    @ApiModelProperty(name = "provinceId",value = "归属省id",dataType = "java.lang.Long")
    private Long provinceId;

    /**
     * 归属市id
     */
    @ApiModelProperty(name = "cityId",value = "归属市id",dataType = "java.lang.Long")
    private Long cityId;

    /**
     * 头像地址
     */
    @ApiModelProperty(name = "heardUrl",value = "头像地址",dataType = "java.lang.String")
    private String heardUrl;

    /**
     * 管理员昵称
     */
    @ApiModelProperty(name = "nickName",value = "管理员昵称",dataType = "java.lang.String")
    private String nickName;

    private static final long serialVersionUID = 1L;
}