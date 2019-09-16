package com.cj.hbasic.domian;

import com.cj.core.entity.Resources;
import com.cj.core.entity.Site;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 站点信息 + 图片集合
 * Created by win9 on 2019/5/21.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = {"handler"})
public class SiteVo extends Site implements Serializable {

    @ApiModelProperty(name = "provinceName",value = "省",dataType = "java.lang.String")
    private String provinceName;

    @ApiModelProperty(name = "cityName",value = "市",dataType = "java.lang.String")
    private String cityName;

    @ApiModelProperty(name = "siteCompanyName",value = "单位名称",dataType = "java.lang.String")
    private String siteCompanyName;

    @ApiModelProperty(name = "productModelName",value = "产品型号名称",dataType = "java.lang.String")
    private String productModelName;

    @ApiModelProperty(name = "itemNumberName",value = "项目编号名称",dataType = "java.lang.String")
    private String itemNumberName;

    @ApiModelProperty(name = "siteTypeName",value = "台站类型名称",dataType = "java.lang.String")
    private String siteTypeName;

    @ApiModelProperty(name = "siteNatureName",value = "产品性质名称",dataType = "java.lang.String")
    private String siteNatureName;

    @ApiModelProperty(name = "siteUsageStateName",value = "使用状态名称",dataType = "java.lang.String")
    private String siteUsageStateName;

    @ApiModelProperty(name = "maintainPeople",value = "维护人",dataType = "java.lang.String")
    private String maintainPeople;

    @ApiModelProperty(name = "maintainTime",value = "维护时间",dataType = "java.util.Date")
    private Date maintainTime;


    @ApiModelProperty(name = "imgList",value = "图片集合",dataType = "List<Resources>")
    private List<Resources> imgList;
}
