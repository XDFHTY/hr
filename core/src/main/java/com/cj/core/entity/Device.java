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
@ApiModel(value = "device")
public class Device implements Serializable {
    /**
     * 设备信息表id主键
     */
    @ApiModelProperty(name = "deviceId",value = "设备信息表id主键",dataType = "java.lang.Long")
    @TableId(type = IdType.AUTO)
    private Long deviceId;

    /**
     * 台站id
     */
    @ApiModelProperty(name = "siteId",value = "台站id",dataType = "java.lang.Long")
    private Long siteId;

    /**
     * 设备子系统号
     */
    @ApiModelProperty(name = "deviceSystemNum",value = "设备子系统号",dataType = "java.lang.String")
    private String deviceSystemNum;

    /**
     * 设备名称
     */
    @ApiModelProperty(name = "deviceName",value = "设备名称",dataType = "java.lang.String")
    private String deviceName;

    /**
     * 设备型号
     */
    @ApiModelProperty(name = "deviceModel",value = "设备型号",dataType = "java.lang.String")
    private String deviceModel;

    /**
     * 设备序号
     */
    @ApiModelProperty(name = "deviceSerialNum",value = "设备序号",dataType = "java.lang.String")
    private String deviceSerialNum;

    /**
     * 设备描述
     */
    @ApiModelProperty(name = "deviceDescribe",value = "设备描述",dataType = "java.lang.String")
    private String deviceDescribe;

    /**
     * 设备状态
     */
    @ApiModelProperty(name = "deviceState",value = "设备状态",dataType = "java.lang.String")
    private String deviceState;

    /**
     * 创建时间
     */
    @ApiModelProperty(name = "createTime",value = "创建时间",dataType = "java.util.Date")
    private Date createTime;

    /**
     * 删除状态 0-已删除 1-正常
     */
    @ApiModelProperty(name = "isDeleteState",value = "删除状态 0-已删除 1-正常",dataType = "java.lang.String")
    private String isDeleteState;

    private static final long serialVersionUID = 1L;
}