package com.cj.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* Created by lw 2019-05-20 16:26:45
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "auth_modular")
public class AuthModular implements Serializable {
    /**
     * 权限资源表主键
     */
    @ApiModelProperty(name = "modularId",value = "权限资源表主键",dataType = "java.lang.Integer")
    @TableId(type = IdType.AUTO)
    private Integer modularId;

    /**
     * 名称
     */
    @ApiModelProperty(name = "pageName",value = "名称",dataType = "java.lang.String")
    private String pageName;

    /**
     * 请求路径
     */
    @ApiModelProperty(name = "pageUrl",value = "请求路径",dataType = "java.lang.String")
    private String pageUrl;

    /**
     * 请求方式resful方法头
     */
    @ApiModelProperty(name = "pageMethod",value = "请求方式resful方法头",dataType = "java.lang.String")
    private String pageMethod;

    /**
     * 分类，1-一级目录，0-请求
     */
    @ApiModelProperty(name = "pageType",value = "分类，1-一级目录，0-请求",dataType = "java.lang.String")
    private String pageType;

    /**
     * 排序
     */
    @ApiModelProperty(name = "pageSort",value = "排序",dataType = "java.lang.Integer")
    private Integer pageSort;

    /**
     * 父级页面ID
     */
    @ApiModelProperty(name = "parentId",value = "父级页面ID",dataType = "java.lang.Integer")
    private Integer parentId;

    /**
     * 备用
     */
    @ApiModelProperty(name = "spare1",value = "备用",dataType = "java.lang.String")
    private String spare1;

    /**
     * 状态（0-已删除，1-正常）
     */
    @ApiModelProperty(name = "state",value = "状态（0-已删除，1-正常）",dataType = "java.lang.String")
    private String state;

    /**
     * 创建时间
     */
    @ApiModelProperty(name = "createTime",value = "创建时间",dataType = "java.util.Date")
    private Date createTime;

    private static final long serialVersionUID = 1L;
}