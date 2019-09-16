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
@ApiModel(value = "site_usage_state")
public class SiteUsageState implements Serializable {
    /**
     * 站点使用状态表id主键
     */
    @ApiModelProperty(name = "siteUsageStateId",value = "站点使用状态表id主键",dataType = "java.lang.Long")
    @TableId(type = IdType.AUTO)
    private Long siteUsageStateId;

    /**
     * 站点使用状态
     */
    @ApiModelProperty(name = "siteUsageStateName",value = "站点使用状态",dataType = "java.lang.String")
    private String siteUsageStateName;

    private static final long serialVersionUID = 1L;
}