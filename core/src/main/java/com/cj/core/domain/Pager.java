package com.cj.core.domain;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pager<T> extends Page {

    /**
     * 传入的多个参数
     */
    @ApiModelProperty(name = "parameters",value = "多条件map集合",dataType = "HashMap")
    private T parameters;
    /**
     * 传入的单个参数，模糊查询用
     */
    @ApiModelProperty(name = "parameter",value = "单条件",dataType = "String")
    private String parameter;

}
