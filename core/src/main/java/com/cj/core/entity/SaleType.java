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
@ApiModel(value = "sale_type")
public class SaleType implements Serializable {
    /**
     * 售后分类表id主键
     */
    @ApiModelProperty(name = "saleTypeId",value = "售后分类表id主键",dataType = "java.lang.Long")
    @TableId(type = IdType.AUTO)
    private Long saleTypeId;

    /**
     * 父节点
     */
    @ApiModelProperty(name = "parentId",value = "父节点",dataType = "java.lang.Long")
    private Long parentId;

    /**
     * 分类名称
     */
    @ApiModelProperty(name = "saleTypeName",value = "分类名称",dataType = "java.lang.String")
    private String saleTypeName;

    /**
     * 分类等级
     */
    @ApiModelProperty(name = "level",value = "分类等级",dataType = "java.lang.Integer")
    private Integer level;

    /**
     * 添加状态（用于数据生成图表） 1-初始数据  2-新增数据
     */
    @ApiModelProperty(name = "addState",value = "添加状态",dataType = "java.lang.String")
    private String addState;

    private static final long serialVersionUID = 1L;
}