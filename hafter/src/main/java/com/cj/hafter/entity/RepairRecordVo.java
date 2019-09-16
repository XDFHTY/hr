package com.cj.hafter.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.cj.core.entity.RepairRecord;
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
* Created by lw 2019-05-20 16:26:45
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = {"handler"})
public class RepairRecordVo extends RepairRecord implements Serializable {

    /**
     * 申报表id主键
     */
    @ApiModelProperty(name = "declareId",value = "申报表id主键",dataType = "java.lang.Long")
    private Long declareId;

    /**
     * 设备名称
     */
    @ApiModelProperty(name = "deviceName",value = "设备名称",dataType = "java.lang.String")
    private String deviceName;

    /**
     * 一级分类名称
     */
    @ApiModelProperty(name = "oneLevelName",value = "一级分类名称",dataType = "java.lang.String")
    private String oneLevelName;

    /**
     * 二级分类名称
     */
    @ApiModelProperty(name = "twoLevelName",value = "二级分类名称",dataType = "java.lang.String")
    private String twoLevelName;

    /**
     * 三级分类名称
     */
    @ApiModelProperty(name = "threeLevelName",value = "三级分类名称",dataType = "java.lang.String")
    private String threeLevelName;

    /**
     * 维护人姓名
     */
    @ApiModelProperty(name = "maintainPeopleName",value = "维护人姓名",dataType = "java.lang.String")
    private String maintainPeopleName;

    @ApiModelProperty(name = "imgList",value = "图片视频集合",dataType = "List<Resources>")
    private List<Resources> imgList;
}