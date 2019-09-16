package com.cj.hafter.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import com.cj.core.entity.DeclareData;
import com.cj.core.entity.Resources;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
* Created by lw 2019-05-20 17:14:16
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "declare")
@JsonIgnoreProperties(value = {"handler"})
public class DeclareVo extends DeclareData implements Serializable {

    /**
     * 申报人姓名
     */
    @ApiModelProperty(name = "founderName",value = "申报人姓名",dataType = "java.lang.String")
    private String founderName;

    /**
     * 角色
     */
    @ApiModelProperty(name = "roleName",value = "角色",dataType = "java.lang.String")
    private String roleName;

    /**
     * 保修日期
     */
    @ApiModelProperty(name = "guaranteeState",value = "保修日期",dataType = "java.util.Date")
    private String siteGuaranteeTime;

    /**
     * 所属省
     */
    @ApiModelProperty(name = "provinceName",value = "省",dataType = "java.lang.String")
    private String provinceName;

    /**
     * 所属市
     */
    @ApiModelProperty(name = "cityName",value = "市",dataType = "java.lang.String")
    private String cityName;

    /**
     * 台站名称
     */
    @ApiModelProperty(name = "siteName",value = "台站名称",dataType = "java.lang.String")
    private String siteName;

    /**
     * 执行人姓名
     */
    @ApiModelProperty(name = "executorName",value = "执行人姓名",dataType = "java.lang.String")
    private String executorName;

    /**
     * 单位
     */
    @ApiModelProperty(name = "siteCompanyName", value = "单位名称", dataType = "java.lang.String")
    private String siteCompanyName;

    /**
     * 项目编号
     */
    @ApiModelProperty(name = "itemNumberName",value = "项目编号名称",dataType = "java.lang.String")
    private String itemNumberName;

    /**
     * 项目经理姓名
     */
    @ApiModelProperty(name = "projectManager",value = "项目经理姓名",dataType = "java.lang.String")
    private String projectManager;

    @ApiModelProperty(name = "siteTypeName",value = "台站类型名称",dataType = "java.lang.String")
    private String siteTypeName;

    @ApiModelProperty(name = "productModelName",value = "产品型号名称",dataType = "java.lang.S    tring")
    private String productModelName;

    @ApiModelProperty(name = "siteNatureName",value = "产品性质名称",dataType = "java.lang.String")
    private String siteNatureName;

    @ApiModelProperty(name = "siteUsageStateName",value = "使用状态名称",dataType = "java.lang.String")
    private String siteUsageStateName;

    @ApiModelProperty(name = "siteManufactureTime",value = "出厂日期",dataType = "java.util.Date")
    private Date siteManufactureTime;

    @ApiModelProperty(name = "lastMaintainTime",value = "最后处理时间",dataType = "java.util.Date")
    private Date lastMaintainTime;

    @ApiModelProperty(name = "lastMaintainPeople",value = "最后处理人",dataType = "java.lang.String")
    private String lastMaintainPeople;

    @ApiModelProperty(name = "imgList",value = "图片集合",dataType = "List<Resources>")
    private List<Resources> imgList;
}