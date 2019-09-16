package com.cj.common.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author： 刘磊
 * @Description: ${description}
 * @date： 2019/5/28 14:22
 **/
@Data
@ApiModel(value = "员工信息实体类")
@JsonIgnoreProperties(value = {"handler"})
public class AdmainModel {

    /**
     * 管理员id
     */
    @ApiModelProperty(name = "adminId",value = "管理员id",dataType = "java.lang.Long")
    private Long adminId;

    /**
     * 管理员姓名
     */
    @ApiModelProperty(name = "fullName",value = "管理员姓名",dataType = "java.lang.String")
    private String fullName;

    /**
     * 归属省id
     */
    @ApiModelProperty(name = "provinceId",value = "归属省id",dataType = "java.lang.Long")
    private Long provinceId;

    /**
     * 省
     */
    @ApiModelProperty(name = "provinceName",value = "省",dataType = "java.lang.String")
    private String provinceName;

    /**
     * 归属市id
     */
    @ApiModelProperty(name = "cityId",value = "归属市id",dataType = "java.lang.Long")
    private Long cityId;

    /**
     * 市
     */
    @ApiModelProperty(name = "cityName",value = "市",dataType = "java.lang.String")
    private String cityName;
}
