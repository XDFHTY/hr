package com.cj.hpatrol.domain;

import com.cj.core.entity.PatrolTaskStation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author： 刘磊
 * @Description: 周期任务台站实体类
 * @date： 2019/5/21 10:07
 **/
@Data
@ApiModel(value = "周期任务台站实体类")
public class PatrolTaskStationModel extends PatrolTaskStation {

    /**
     * 台站名字
     */
    @ApiModelProperty(name = "siteName",value = "台站名字",dataType = "java.lang.String")
    private String siteName;

    /**
     * 台站所属省
     */
    @ApiModelProperty(name = "siteProvinceName",value = "台站所属省id",dataType = "java.lang.String")
    private String siteProvinceName;

    /**
     * 台站所属市
     */
    @ApiModelProperty(name = "siteCityName",value = "台站所属市id",dataType = "java.lang.String")
    private String siteCityName;

    /**
     * 项目编号
     */
    @ApiModelProperty(name = "itemNumber",value = "项目编号",dataType = "java.lang.String")
    private String itemNumber;

    /**
     * 台站类型
     */
    @ApiModelProperty(name = "siteType",value = "台站类型",dataType = "java.lang.String")
    private String siteType;

    /**
     * 台站编号
     */
    @ApiModelProperty(name = "siteNum",value = "台站编号",dataType = "java.lang.String")
    private String siteNum;

    /**
     * 所属单位
     */
    @ApiModelProperty(name = "siteCompanyName",value = "所属单位",dataType = "java.lang.String")
    private String siteCompanyName;

    /**
     * 巡查人名字
     */
    @ApiModelProperty(name = "patrolName",value = "巡查人名字",dataType = "java.lang.String")
    private String patrolName;

    /**
     * 系统使用的角色名ROLE_XXX
     */
    @ApiModelProperty(name = "roleName",value = "系统使用的角色名ROLE_XXX",dataType = "java.lang.String")
    private String roleName;
}
