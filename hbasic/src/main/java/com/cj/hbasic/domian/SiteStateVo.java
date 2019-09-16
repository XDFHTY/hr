package com.cj.hbasic.domian;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 站点状态统计实体类
 * Created by win9 on 2019/5/23.
 */

@Data
public class SiteStateVo {


    @ApiModelProperty(name = "siteTotal", value = "站点总数", dataType = "java.lang.Integer")
    private Integer siteTotal;

    @ApiModelProperty(name = "normalNmu", value = "正常站点数", dataType = "java.lang.Integer")
    private Integer normalNmu;

    @ApiModelProperty(name = "abnormalNum", value = "异常站点数", dataType = "java.lang.Integer")
    private Integer abnormalNum;

    @ApiModelProperty(name = "maintainNum", value = "维护站点数量", dataType = "java.lang.Integer")
    private Integer maintainNum;
}
