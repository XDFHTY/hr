package com.cj.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* Created by lw 2019-05-20 16:26:45
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "region_2017")
public class Region2017 implements Serializable {
    /**
     * 省市区表id主键
     */
    @ApiModelProperty(name = "id",value = "省市区表id主键",dataType = "java.lang.Integer")
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 父级ID
     */
    @ApiModelProperty(name = "parentId",value = "父级ID",dataType = "java.lang.Integer")
    private Integer parentId;

    /**
     * 层级
     */
    @ApiModelProperty(name = "level",value = "层级",dataType = "java.lang.Byte")
    private Byte level;

    /**
     * 行政代码
     */
    @ApiModelProperty(name = "areaCode",value = "行政代码",dataType = "java.lang.Long")
    private Long areaCode;

    /**
     * 邮政编码
     */
    @ApiModelProperty(name = "zipCode",value = "邮政编码",dataType = "java.lang.Integer")
    private Integer zipCode;

    /**
     * 区号
     */
    @ApiModelProperty(name = "cityCode",value = "区号",dataType = "java.lang.String")
    private String cityCode;

    /**
     * 名称
     */
    @ApiModelProperty(name = "name",value = "名称",dataType = "java.lang.String")
    private String name;

    /**
     * 简称
     */
    @ApiModelProperty(name = "shortName",value = "简称",dataType = "java.lang.String")
    private String shortName;

    /**
     * 组合名
     */
    @ApiModelProperty(name = "mergerName",value = "组合名",dataType = "java.lang.String")
    private String mergerName;

    /**
     * 拼音
     */
    @ApiModelProperty(name = "pinyin",value = "拼音",dataType = "java.lang.String")
    private String pinyin;

    /**
     * 经度
     */
    @ApiModelProperty(name = "lng",value = "经度",dataType = "java.math.BigDecimal")
    private BigDecimal lng;

    /**
     * 纬度
     */
    @ApiModelProperty(name = "lat",value = "纬度",dataType = "java.math.BigDecimal")
    private BigDecimal lat;

    private static final long serialVersionUID = 1L;
}