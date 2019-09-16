package com.cj.hcensus.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author： 刘磊
 * @Description: 台站状态实体类
 * @date： 2019/5/23 10:04
 **/
@Data
@ApiModel(value = "台站状态实体类")
@JsonIgnoreProperties(value = {"handler"})
public class StaCensusModel implements Serializable {

    /**
     * 正常
     */
    @ApiModelProperty(name = "nor",value = "正常",dataType = "java.lang.Integer")
    private Integer nor;
    /**
     * 异常
     */
    @ApiModelProperty(name = "abn",value = "异常",dataType = "java.lang.Integer")
    private Integer abn;
    /**
     * 处理中
     */
    @ApiModelProperty(name = "inp",value = "处理中",dataType = "java.lang.Integer")
    private Integer inp;
}
