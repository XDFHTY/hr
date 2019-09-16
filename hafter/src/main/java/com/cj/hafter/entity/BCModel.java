package com.cj.hafter.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author： 刘磊
 * @Description: ${description}
 * @date： 2019/5/31 10:04
 **/
@Data
@ApiModel(value = "分类实体类")
@JsonIgnoreProperties(value = {"handler"})
public class BCModel {

    /**
     * 售后分类表id
     */
    @ApiModelProperty(name = "id",value = "售后分类表id",dataType = "java.lang.Long")
    private Long id;
    /**
     * 分类名称
     */
    @ApiModelProperty(name = "name",value = "分类名称",dataType = "java.lang.String")
    private String name;
    /**
     * 子类
     */
    @ApiModelProperty(name = "child",value = "子类",dataType = "java.util.List")
    private List<BCModel> child;
}
