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
@ApiModel(value = "check_item")
public class CheckItem implements Serializable {
    /**
     * 检查项表id主键
     */
    @ApiModelProperty(name = "checkItemId",value = "检查项表id主键",dataType = "java.lang.Long")
    @TableId(type = IdType.AUTO)
    private Long checkItemId;

    /**
     * 检查项名称
     */
    @ApiModelProperty(name = "checkItemName",value = "检查项名称",dataType = "java.lang.String")
    private String checkItemName;

    /**
     * 父节点id
     */
    @ApiModelProperty(name = "parentId",value = "父节点id",dataType = "java.lang.Long")
    private Long parentId;

    /**
     * 层级
     */
    @ApiModelProperty(name = "level",value = "层级",dataType = "java.lang.Integer")
    private Integer level;

    private static final long serialVersionUID = 1L;
}