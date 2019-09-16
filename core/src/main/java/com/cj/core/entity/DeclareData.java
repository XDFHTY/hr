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
* Created by lw 2019-05-20 17:14:16
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "declare")
public class DeclareData implements Serializable {
    /**
     * 申报表id主键
     */
    @ApiModelProperty(name = "declareId",value = "申报表id主键",dataType = "java.lang.Long")
    @TableId(type = IdType.AUTO)
    private Long declareId;

    /**
     * 联系人
     */
    @ApiModelProperty(name = "contactsName",value = "联系人",dataType = "java.lang.String")
    private String contactsName;

    /**
     * 电话
     */
    @ApiModelProperty(name = "phone",value = "电话",dataType = "java.lang.String")
    private String phone;

    /**
     * 站点id
     */
    @ApiModelProperty(name = "siteId",value = "站点id",dataType = "java.lang.Long")
    private Long siteId;

    /**
     * 申报类型
     */
    @ApiModelProperty(name = "declareType",value = "申报类型",dataType = "java.lang.String")
    private String declareType;

    /**
     * 申报内容
     */
    @ApiModelProperty(name = "declareContent",value = "申报内容",dataType = "java.lang.String")
    private String declareContent;

    /**
     * 申报人id
     */
    @ApiModelProperty(name = "founderId",value = "申报人id",dataType = "java.lang.Long")
    private Long founderId;

    /**
     * 执行人id
     */
    @ApiModelProperty(name = "executorId",value = "执行人id",dataType = "java.lang.Long")
    private Long executorId;

    /**
     * 执行时间
     */
    @ApiModelProperty(name = "executionTime",value = "执行时间",dataType = "java.util.Date")
    private Date executionTime;

    /**
     * 处理进度
     */
    @ApiModelProperty(name = "handleState",value = "处理进度",dataType = "java.lang.String")
    private String handleState;

    /**
     * 创建时间
     */
    @ApiModelProperty(name = "createTime",value = "创建时间",dataType = "java.util.Date")
    private Date createTime;

    /**
     * 完成时间
     */
    @ApiModelProperty(name = "comTime",value = "完成时间",dataType = "java.util.Date")
    private Date comTime;


    private static final long serialVersionUID = 1L;
}