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
@ApiModel(value = "repair_record")
public class RepairRecord implements Serializable {
    /**
     * 维修记录表id
     */
    @ApiModelProperty(name = "repairRecordId",value = "维修记录表id",dataType = "java.lang.Long")
    @TableId(type = IdType.AUTO)
    private Long repairRecordId;

    /**
     * 次数-维护表id
     */
    @ApiModelProperty(name = "saleNumId",value = "售后维修-记录表主键",dataType = "java.lang.Long")
    private Long saleNumId;

    /**
     * 设备信息表id
     */
    @ApiModelProperty(name = "deviceId",value = "设备信息表id主键",dataType = "java.lang.Long")
    private Long deviceId;

    /**
     * 一级分类id
     */
    @ApiModelProperty(name = "oneLevelId",value = "一级分类id",dataType = "java.lang.Long")
    private Long oneLevelId;

    /**
     * 二级分类id
     */
    @ApiModelProperty(name = "twoLevelId",value = "二级分类id",dataType = "java.lang.Long")
    private Long twoLevelId;

    /**
     * 三级分类id
     */
    @ApiModelProperty(name = "threeLevelId",value = "三级分类id",dataType = "java.lang.Long")
    private Long threeLevelId;

    /**
     * 申报内容
     */
    @ApiModelProperty(name = "describeContent",value = "申报内容",dataType = "java.lang.String")
    private String describeContent;

    /**
     * 维护时间
     */
    @ApiModelProperty(name = "maintainTime",value = "维护时间",dataType = "java.util.Date")
    private Date maintainTime;

    /**
     * 维护人id
     */
    @ApiModelProperty(name = "maintainPeopleId",value = "维护人id",dataType = "java.lang.Long")
    private Long maintainPeopleId;


    private static final long serialVersionUID = 1L;
}