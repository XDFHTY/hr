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
@ApiModel(value = "site_check_item_msg")
public class SiteCheckItemMsg implements Serializable {
    /**
     * 巡检任务-内容记录表主键
     */
    @ApiModelProperty(name = "scimId",value = "巡检任务-内容记录表主键",dataType = "java.lang.Long")
    @TableId(type = IdType.AUTO)
    private Long scimId;

    /**
     * 巡查任务台站表ID
     */
    @ApiModelProperty(name = "patrolTaskStationId",value = "巡查任务台站表ID",dataType = "java.lang.Long")
    private Long patrolTaskStationId;

    /**
     * 检查项名称1级
     */
    @ApiModelProperty(name = "checkItemName1",value = "检查项名称1级",dataType = "java.lang.String")
    private String checkItemName1;

    /**
     * 检查项名称2级
     */
    @ApiModelProperty(name = "checkItemName2",value = "检查项名称2级",dataType = "java.lang.String")
    private String checkItemName2;

    /**
     * 检查项名称3级
     */
    @ApiModelProperty(name = "checkItemName3",value = "检查项名称3级",dataType = "java.lang.String")
    private String checkItemName3;

    /**
     * 检查项名称4级
     */
    @ApiModelProperty(name = "checkItemName4",value = "检查项名称4级",dataType = "java.lang.String")
    private String checkItemName4;

    /**
     * 检查项说明（第二级才有）
     */
    @ApiModelProperty(name = "checkItemMsg",value = "检查项说明（第二级才有）",dataType = "java.lang.String")
    private String checkItemMsg;

    /**
     * 检查项结果（第四级才有）
     */
    @ApiModelProperty(name = "checkItemResult",value = "检查项结果（第四级才有）",dataType = "java.lang.String")
    private String checkItemResult;

    private static final long serialVersionUID = 1L;
}