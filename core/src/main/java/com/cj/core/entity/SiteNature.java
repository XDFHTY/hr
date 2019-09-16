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
@ApiModel(value = "site_nature")
public class SiteNature implements Serializable {
    /**
     * 站点性质表id主键
     */
    @ApiModelProperty(name = "siteNatureId",value = "站点性质表id主键",dataType = "java.lang.Long")
    @TableId(type = IdType.AUTO)
    private Long siteNatureId;

    /**
     * 站点性质表id
     */
    @ApiModelProperty(name = "siteNatureName",value = "站点性质表id",dataType = "java.lang.String")
    private String siteNatureName;

    private static final long serialVersionUID = 1L;
}