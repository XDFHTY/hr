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
@ApiModel(value = "key_64")
public class Key64 implements Serializable {
    /**
     * admin-user-唯一主键
     */
    @ApiModelProperty(name = "id",value = "admin-user-唯一主键",dataType = "java.lang.Long")
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    @ApiModelProperty(name = "stub",value = "",dataType = "java.lang.String")
    private String stub;

    private static final long serialVersionUID = 1L;
}