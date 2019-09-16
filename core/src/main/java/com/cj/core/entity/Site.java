package com.cj.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
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
@ApiModel(value = "site")
public class Site implements Serializable {
    /**
     * 台站信息表id主键
     */
    @ApiModelProperty(name = "siteId",value = "台站信息表id主键",dataType = "java.lang.Long")
    @TableId(type = IdType.AUTO)
    private Long siteId;

    /**
     * 台站名称
     */
    @ApiModelProperty(name = "siteName",value = "台站名称",dataType = "java.lang.String")
    private String siteName;

    /**
     * 台站编号
     */
    @ApiModelProperty(name = "siteNum",value = "台站编号",dataType = "java.lang.String")
    private String siteNum;

    /**
     * 经度
     */
    @ApiModelProperty(name = "siteLongitude",value = "经度",dataType = "java.math.BigDecimal")
    private BigDecimal siteLongitude;

    /**
     * 纬度
     */
    @ApiModelProperty(name = "siteLatitude",value = "纬度",dataType = "java.math.BigDecimal")
    private BigDecimal siteLatitude;

    /**
     * 台站地址
     */
    @ApiModelProperty(name = "siteAddress",value = "台站地址",dataType = "java.lang.String")
    private String siteAddress;

    /**
     * 台站所属省id
     */
    @ApiModelProperty(name = "siteProvinceId",value = "台站所属省id",dataType = "java.lang.Long")
    private Long siteProvinceId;

    /**
     * 台站所属市id
     */
    @ApiModelProperty(name = "siteCityId",value = "台站所属市id",dataType = "java.lang.Long")
    private Long siteCityId;

    /**
     * 台站所属区id
     */
    @ApiModelProperty(name = "siteArea",value = "台站所属区id",dataType = "java.lang.Long")
    private Long siteArea;

    /**
     * 所属单位表id
     */
    @ApiModelProperty(name = "siteCompanyId",value = "所属单位表id",dataType = "java.lang.Long")
    private Long siteCompanyId;

    /**
     * 系统型号
     */
    @ApiModelProperty(name = "siteSystemType",value = "系统型号",dataType = "java.lang.String")
    private String siteSystemType;

    /**
     * 产品型号表id
     */
    @ApiModelProperty(name = "productModelId",value = "产品型号表id",dataType = "java.lang.Long")
    private Long productModelId;

    /**
     * 项目编号id
     */
    @ApiModelProperty(name = "itemNumberId",value = "项目编号id",dataType = "java.lang.Long")
    private Long itemNumberId;

    /**
     * 项目经理姓名
     */
    @ApiModelProperty(name = "projectManager",value = "项目经理姓名",dataType = "java.lang.String")
    private String projectManager;

    /**
     * 台站类型表id
     */
    @ApiModelProperty(name = "siteTypeId",value = "台站类型表id",dataType = "java.lang.Long")
    private Long siteTypeId;

    /**
     * 出厂日期
     */
    @ApiModelProperty(name = "siteManufactureTime",value = "出厂日期",dataType = "java.util.Date")
    private Date siteManufactureTime;

    /**
     * 保修日期
     */
    @ApiModelProperty(name = "siteGuaranteeTime",value = "保修日期",dataType = "java.util.Date")
    private Date siteGuaranteeTime;

    /**
     * 验收日期
     */
    @ApiModelProperty(name = "siteAcceptanceTime",value = "验收日期",dataType = "java.util.Date")
    private Date siteAcceptanceTime;

    /**
     * 集成厂商
     */
    @ApiModelProperty(name = "integrateFirm",value = "集成厂商",dataType = "java.lang.String")
    private String integrateFirm;

    /**
     * 站点性质表id
     */
    @ApiModelProperty(name = "siteNatureId",value = "站点性质表id",dataType = "java.lang.Long")
    private Long siteNatureId;

    /**
     * 使用状态表id
     */
    @ApiModelProperty(name = "siteUsageStateId",value = "使用状态表id",dataType = "java.lang.Long")
    private Long siteUsageStateId;

    /**
     * 天线高度
     */
    @ApiModelProperty(name = "antennaHeight",value = "天线高度",dataType = "java.lang.String")
    private String antennaHeight;

    /**
     * 站点序号
     */
    @ApiModelProperty(name = "siteSerialNumber",value = "站点序号",dataType = "java.lang.String")
    private String siteSerialNumber;

    /**
     * 核心设备
     */
    @ApiModelProperty(name = "coreEquipment",value = "核心设备",dataType = "java.lang.String")
    private String coreEquipment;

    /**
     * 操作系统版本
     */
    @ApiModelProperty(name = "operSysVirsion",value = "操作系统版本",dataType = "java.lang.String")
    private String operSysVirsion;

    /**
     * 监控系统版本
     */
    @ApiModelProperty(name = "monSoftVersion",value = "监控系统版本",dataType = "java.lang.String")
    private String monSoftVersion;

    /**
     * 其他软件信息
     */
    @ApiModelProperty(name = "otherSoftInfo",value = "其他软件信息",dataType = "java.lang.String")
    private String otherSoftInfo;

    /**
     * 无人站关机服务
     */
    @ApiModelProperty(name = "isShutdown",value = "无人站关机服务",dataType = "java.lang.String")
    private String isShutdown;

    /**
     * 站点描述
     */
    @ApiModelProperty(name = "siteDescribe",value = "站点描述",dataType = "java.lang.String")
    private String siteDescribe;

    /**
     * 售后状态 1-正常 2-处理中 3-异常
     */
    @ApiModelProperty(name = "siteSaleState",value = "售后状态 1-正常 2-处理中 3-异常",dataType = "java.lang.String")
    private String siteSaleState;

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