package com.cj.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
* Created by lw 2019-05-20 16:26:45
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "sale_num")
public class SaleNum implements Serializable {
    /**
     * 售后维修-记录表主键
     */
    @ApiModelProperty(name = "saleNumId",value = "售后维修-记录表主键",dataType = "java.lang.Long")
    @TableId(type = IdType.AUTO)
    private Long saleNumId;

    /**
     * 申报id
     */
    @ApiModelProperty(name = "declareId",value = "申报表id",dataType = "java.lang.Long")
    private Long declareId;

    /**
     * 次数
     */
    @ApiModelProperty(name = "num",value = "次数",dataType = "java.lang.Integer")
    private Integer num;

    /**
     * 创建人id
     */
    @ApiModelProperty(name = "founderId",value = "创建人id",dataType = "java.lang.Long")
    private Long founderId;

    /**
     * 创建时间
     */
    @ApiModelProperty(name = "createTime",value = "创建时间",dataType = "java.util.Date")
    private Date createTime;



    private static final long serialVersionUID = 1L;
}