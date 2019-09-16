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
@ApiModel(value = "patrol_task_province")
public class PatrolTaskProvince implements Serializable {
    /**
     * 巡查任务省表主键
     */
    @ApiModelProperty(name = "patrolTaskProvinceId",value = "巡查任务省表主键",dataType = "java.lang.Long")
    @TableId(type = IdType.AUTO)
    private Long patrolTaskProvinceId;

    /**
     * 任务名称
     */
    @ApiModelProperty(name = "taskName",value = "任务名称",dataType = "java.lang.String")
    private String taskName;

    /**
     * 巡查人id
     */
    @ApiModelProperty(name = "patrolId",value = "巡查人id",dataType = "java.lang.Long")
    private Long patrolId;

    /**
     * 省id
     */
    @ApiModelProperty(name = "provinceId",value = "省id",dataType = "java.lang.Long")
    private Long provinceId;

    /**
     * 任务类型
     */
    @ApiModelProperty(name = "taskType",value = "任务类型",dataType = "java.lang.String")
    private String taskType;

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

    private static final long serialVersionUID = 1L;
}