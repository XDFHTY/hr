package com.cj.hcensus.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author： 刘磊
 * @Description: 维护情况实体类
 * @date： 2019/5/23 10:14
 **/
@Data
@ApiModel(value = "维护情况实体类")
@JsonIgnoreProperties(value = {"handler"})
public class RepCensusModel implements Serializable {

    /**
     * id
     */
    @ApiModelProperty(name = "id",value = "id",dataType = "java.lang.Long")
    private Long id;

    /**
     * 名字
     */
    @ApiModelProperty(name = "name",value = "售后分类名字",dataType = "java.lang.String")
    private String name;

    /**
     * 次数
     */
    @ApiModelProperty(name = "num",value = "次数",dataType = "java.lang.Integer")
    private Integer num;

    /**
     * 添加状态（用于数据生成图表） 1-初始数据  2-新增数据
     */
    @ApiModelProperty(name = "addState",value = "添加状态",dataType = "java.lang.String")
    private String addState;

    private List<RepCensusModel> list;
}
