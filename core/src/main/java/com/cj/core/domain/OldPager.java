package com.cj.core.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * <b> 分页通用类 </b>
 *
 * @author kangxu
 * @param <T>
 *
 */
@Data
@ApiModel(value = "分页对象")
public class OldPager<T> implements Serializable {
    /**
     * page 页码
     */
    @ApiModelProperty(name = "page",value = "页码",dataType = "Integer")
    private int page = 1;
    /**
     * size 每页大小
     */
    @ApiModelProperty(name = "size",value = "每页大小",dataType = "Integer")
    private int size = 10; //limit 第二个参数


    private int minRow = 0;  //limit 中的第一个参数，开始下标

    /**
     * pageTotal 总页数
     */
    @ApiModelProperty(name = "pageTotal",value = "总页数",dataType = "Integer")
    private int pageTotal;
    /**
     * recordTotal 总条数
     */
    @ApiModelProperty(name = "recordTotal",value = "总条数",dataType = "Integer")
    private int recordTotal = 0;
    /**
     * 传入的多个参数
     */
    @ApiModelProperty(name = "parameters",value = "多条件map集合",dataType = "HashMap")
    private Map<String, Object> parameters = new HashMap<>();
    /**
     * 传入的单个参数，模糊查询用
     */
    @ApiModelProperty(name = "parameter",value = "单条件",dataType = "String")
    private T parameter;

    /**
     * content 返回的每页的内容
     */
    @ApiModelProperty(name = "content",value = "返回的每页的内容")
    private Object content;

    public void setRecordTotal(int recordTotal) {
        this.recordTotal = recordTotal;
        this.pageTotal = recordTotal%this.size>0? recordTotal/this.size+ 1:recordTotal/this.size;
    }

    public int getMinRow() {
        return ((this.page - 1) * this.size)<0?0:(this.page - 1) * this.size;
    }

    public void setLists(List<List<?>> lists){
        List<Total> totals = (List<Total>)lists.get(1);
        this.recordTotal = totals.get(0).getTotal();
        this.content = lists.get(0);
        this.pageTotal = this.recordTotal%this.size>0? this.recordTotal/this.size+1:this.recordTotal/this.size;
    }
}