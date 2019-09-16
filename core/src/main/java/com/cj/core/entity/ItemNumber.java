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
@ApiModel(value = "item_number")
public class ItemNumber implements Serializable {
    /**
     * 项目编号表id主键
     */
    @ApiModelProperty(name = "itemNumberId",value = "项目编号表id主键",dataType = "java.lang.Long")
    @TableId(type = IdType.AUTO)
    private Long itemNumberId;

    /**
     * 项目编号
     */
    @ApiModelProperty(name = "itemNumberName",value = "项目编号",dataType = "java.lang.String")
    private String itemNumberName;

    private static final long serialVersionUID = 1L;
}