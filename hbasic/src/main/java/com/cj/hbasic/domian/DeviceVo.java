package com.cj.hbasic.domian;

import com.cj.core.entity.Device;
import com.cj.core.entity.Resources;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by win9 on 2019/5/22.
 */
@Data
@JsonIgnoreProperties(value = {"handler"})
public class DeviceVo extends Device implements Serializable {



    @ApiModelProperty(name = "siteProvinceId",value = "台站所属省id",dataType = "java.lang.Long")
    private Long siteProvinceId;


    @ApiModelProperty(name = "siteCityId",value = "台站所属市id",dataType = "java.lang.Long")
    private Long siteCityId;

    @ApiModelProperty(name = "provinceName",value = "台站所属省",dataType = "java.lang.String")
    private String provinceName;

    @ApiModelProperty(name = "cityName",value = "台站所属市",dataType = "java.lang.String")
    private String cityName;

    @ApiModelProperty(name = "siteName",value = "台站名称",dataType = "java.lang.String")
    private String siteName;

    @ApiModelProperty(name = "num",value = "维护次数",dataType = "java.lang.Integer")
    private Integer num;

    @ApiModelProperty(name = "imgList",value = "图片集合",dataType = "List<Resources>")
    private List<Resources> imgList;


}
