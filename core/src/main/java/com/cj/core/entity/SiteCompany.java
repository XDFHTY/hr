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
@ApiModel(value = "site_company")
public class SiteCompany implements Serializable {
    /**
     * 所属单位表id主键
     */
    @ApiModelProperty(name = "siteCompanyId",value = "所属单位表id主键",dataType = "java.lang.Long")
    @TableId(type = IdType.AUTO)
    private Long siteCompanyId;

    /**
     * 所属单位
     */
    @ApiModelProperty(name = "siteCompanyName",value = "所属单位",dataType = "java.lang.String")
    private String siteCompanyName;

    private static final long serialVersionUID = 1L;
}