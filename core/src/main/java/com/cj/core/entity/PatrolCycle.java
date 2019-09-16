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
@ApiModel(value = "patrol_cycle")
public class PatrolCycle implements Serializable {
    /**
     * 巡查周期记录省表主键
     */
    @ApiModelProperty(name = "patrolCycleId",value = "巡查周期记录省表主键",dataType = "java.lang.Long")
    @TableId(type = IdType.AUTO)
    private Long patrolCycleId;

    /**
     * 任务名称
     */
    @ApiModelProperty(name = "taskName",value = "任务名称",dataType = "java.lang.String")
    private String taskName;

    /**
     * 巡查省id
     */
    @ApiModelProperty(name = "provinceId",value = "巡查省id",dataType = "java.lang.Long")
    private Long provinceId;

    /**
     * 生成人名字
     */
    @ApiModelProperty(name = "createName",value = "生成人名字",dataType = "java.lang.String")
    private String createName;

    /**
     * 巡查人id
     */
    @ApiModelProperty(name = "patrolId",value = "巡查人id",dataType = "java.lang.Long")
    private Long patrolId;

    /**
     * 开始时间
     */
    @ApiModelProperty(name = "startTime",value = "开始时间",dataType = "java.util.Date")
    private Date startTime;

    /**
     * 结束时间
     */
    @ApiModelProperty(name = "endTime",value = "结束时间",dataType = "java.util.Date")
    private Date endTime;

    /**
     * 周期 月/次
     */
    @ApiModelProperty(name = "cycle",value = "周期 月/次",dataType = "java.lang.Integer")
    @TableId(type = IdType.AUTO)
    private Integer cycle;

    /**
     * 提前天数
     */
    @ApiModelProperty(name = "advance",value = "提前天数",dataType = "java.lang.Integer")
    private Integer advance;

    /**
     * 执行次数
     */
    @ApiModelProperty(name = "executeNum",value = "执行次数",dataType = "java.lang.Integer")
    private Integer executeNum;

    private static final long serialVersionUID = 1L;
}