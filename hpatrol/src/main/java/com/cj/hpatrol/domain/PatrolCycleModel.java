package com.cj.hpatrol.domain;

import com.cj.core.entity.PatrolCycle;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author： 刘磊
 * @Description: 周期计划实体类
 * @date： 2019/5/21 9:03
 **/
@Data
@ApiModel(value = "周期计划实体类")
@JsonIgnoreProperties(value = {"handler"})
public class PatrolCycleModel extends PatrolCycle {

    /**
     * 所属省
     */
    @ApiModelProperty(name = "provinceName",value = "台站所属省",dataType = "java.lang.String")
    private String provinceName;
    /**
     * 巡查人名字
     */
    @ApiModelProperty(name = "patrolName",value = "巡查人名字",dataType = "java.lang.String")
    private String patrolName;
    /**
     * 周期计划台站
     */
    @ApiModelProperty(name = "listPSM",value = "周期计划台站")
    private List<PatrolStationModel> listPSM;
}
