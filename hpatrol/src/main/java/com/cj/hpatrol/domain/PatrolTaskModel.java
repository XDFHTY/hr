package com.cj.hpatrol.domain;

import com.cj.core.entity.PatrolTaskProvince;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author： 刘磊
 * @Description: 巡查任务实体类
 * @date： 2019/5/21 9:23
 **/
@Data
@ApiModel(value = "巡查任务实体类")
@JsonIgnoreProperties(value = {"handler"})
public class PatrolTaskModel extends PatrolTaskProvince {

    /**
     * 巡查人名字
     */
    @ApiModelProperty(name = "patrolName",value = "巡查人名字",dataType = "java.lang.String")
    private String patrolName;

    /**
     * 省
     */
    @ApiModelProperty(name = "provinceName",value = "省",dataType = "java.lang.String")
    private String provinceName;

    /**
     * 巡查状态
     */
    @ApiModelProperty(name = "patrolState",value = "巡查状态",dataType = "java.lang.String")
    private String patrolState;

    /**
     * 周期任务台站
     */
    @ApiModelProperty(name = "listTSM",value = "周期任务台站")
    private List<PatrolTaskStationModel> listTSM;
}
