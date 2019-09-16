package com.cj.hcensus.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author： 刘磊
 * @Description: 巡查情况实体类
 * @date： 2019/5/23 10:20
 **/
@Data
@ApiModel(value = "巡查情况实体类")
@JsonIgnoreProperties(value = {"handler"})
public class PatCensusModel implements Serializable {

    /**
     * 任务类型
     */
    @ApiModelProperty(name = "taskType",value = "任务类型",dataType = "java.lang.String")
    private String taskType;

    /**
     * 站点数
     */
    @ApiModelProperty(name = "staNum",value = "站点数",dataType = "java.lang.Integer")
    private Integer staNum;

    /**
     * 巡查次数
     */
    @ApiModelProperty(name = "patNum",value = "巡查次数",dataType = "java.lang.Integer")
    private Integer patNum;
}
