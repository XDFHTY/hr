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
@ApiModel(value = "resources")
public class Resources implements Serializable {
    /**
     * 静态资源表id主键
     */
    @ApiModelProperty(name = "resourceId",value = "静态资源表id主键",dataType = "java.lang.Long")
    @TableId(type = IdType.AUTO)
    private Long resourceId;

    /**
     * 图片地址
     */
    @ApiModelProperty(name = "resourceUrl",value = "图片地址",dataType = "java.lang.String")
    private String resourceUrl;

    /**
     * 图片类型
     */
    @ApiModelProperty(name = "resourceType",value = "图片类型",dataType = "java.lang.String")
    private String resourceType;

    /**
     * 关联id
     */
    @ApiModelProperty(name = "relationId",value = "关联id",dataType = "java.lang.Long")
    private Long relationId;

    /**
     * 文件名称
     */
    @ApiModelProperty(name = "fileName",value = "文件名称",dataType = "java.lang.String")
    private String fileName;

    /**
     * 创建时间
     */
    @ApiModelProperty(name = "createTime",value = "创建时间",dataType = "java.util.Date")
    private Date createTime;

    /**
     * 创建人id
     */
    @ApiModelProperty(name = "founderId",value = "创建人id",dataType = "java.lang.Long")
    private Long founderId;

    private static final long serialVersionUID = 1L;
}