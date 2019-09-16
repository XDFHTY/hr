package com.cj.hpatrol.domain;

import com.cj.core.entity.PatrolStation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author： 刘磊
 * @Description: 周期计划台站实体类
 * @date： 2019/5/21 9:13
 **/
@Data
@ApiModel(value = "周期计划台站实体类")
public class PatrolStationModel extends PatrolStation {

    /**
     * 台站名字
     */
    @ApiModelProperty(name = "siteName",value = "台站名字",dataType = "java.lang.String")
    private String siteName;

    /**
     * 市名字
     */
    @ApiModelProperty(name = "cityName",value = "市名字",dataType = "java.lang.String")
    private String cityName;
}
