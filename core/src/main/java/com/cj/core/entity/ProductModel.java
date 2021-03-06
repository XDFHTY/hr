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
@ApiModel(value = "product_model")
public class ProductModel implements Serializable {
    /**
     * 产品型号表id主键
     */
    @ApiModelProperty(name = "productModelId",value = "产品型号表id主键",dataType = "java.lang.Long")
    @TableId(type = IdType.AUTO)
    private Long productModelId;

    /**
     * 产品型号
     */
    @ApiModelProperty(name = "productModelName",value = "产品型号",dataType = "java.lang.String")
    private String productModelName;

    private static final long serialVersionUID = 1L;
}