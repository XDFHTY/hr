package com.cj.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* Created by lw 2019-05-20 16:26:45
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "department")
public class Department implements Serializable {
    /**
     * 部门表id主键
     */
    @ApiModelProperty(name = "departmentId",value = "部门表id主键",dataType = "java.lang.Long")
    @TableId(type = IdType.AUTO)
    private Long departmentId;

    /**
     * 部门名称
     */
    @ApiModelProperty(name = "departmentName",value = "部门名称",dataType = "java.lang.String")
    private String departmentName;

    private static final long serialVersionUID = 1L;
}