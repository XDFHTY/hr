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
@ApiModel(value = "site_type")
public class SiteType implements Serializable {
    /**
     * 台站类型表id主键
     */
    @ApiModelProperty(name = "siteTypeId",value = "台站类型表id主键",dataType = "java.lang.Long")
    @TableId(type = IdType.AUTO)
    private Long siteTypeId;

    /**
     * 台站类型
     */
    @ApiModelProperty(name = "siteTypeName",value = "台站类型",dataType = "java.lang.String")
    private String siteTypeName;

    private static final long serialVersionUID = 1L;
}