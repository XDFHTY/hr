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
@ApiModel(value = "mid_site_check_item")
public class MidSiteCheckItem implements Serializable {
    /**
     * 台站-检查项关联表id主键
     */
    @ApiModelProperty(name = "midSciId",value = "台站-检查项关联表id主键",dataType = "java.lang.Long")
    @TableId(type = IdType.AUTO)
    private Long midSciId;

    /**
     * 台站id
     */
    @ApiModelProperty(name = "siteId",value = "台站id",dataType = "java.lang.Long")
    private Long siteId;

    /**
     * 检查项id
     */
    @ApiModelProperty(name = "checkItemId",value = "检查项id",dataType = "java.lang.Long")
    private Long checkItemId;

    private static final long serialVersionUID = 1L;
}