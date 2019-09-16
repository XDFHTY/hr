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
@ApiModel(value = "patrol_task_station")
public class PatrolTaskStation implements Serializable {
    /**
     * 巡查任务台站表主键
     */
    @ApiModelProperty(name = "patrolTaskStationId",value = "巡查任务台站表主键",dataType = "java.lang.Long")
    @TableId(type = IdType.AUTO)
    private Long patrolTaskStationId;

    /**
     * 巡查任务省表id
     */
    @ApiModelProperty(name = "patrolTaskProvinceId",value = "巡查任务省表id",dataType = "java.lang.Long")
    private Long patrolTaskProvinceId;

    /**
     * 台站id
     */
    @ApiModelProperty(name = "siteId",value = "台站id",dataType = "java.lang.Long")
    private Long siteId;

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
     * 到站打卡时间
     */
    @ApiModelProperty(name = "reachTime",value = "到站打卡时间",dataType = "java.util.Date")
    private Date reachTime;

    /**
     * 离站打卡时间
     */
    @ApiModelProperty(name = "leaveTime",value = "离站打卡时间",dataType = "java.util.Date")
    private Date leaveTime;

    /**
     * 上传时间
     */
    @ApiModelProperty(name = "uploadTime",value = "上传时间",dataType = "java.util.Date")
    private Date uploadTime;

    /**
     * 任务状态 0-待巡查 1-已巡查
     */
    @ApiModelProperty(name = "patrolState",value = "任务状态 0-待巡查 1-已巡查",dataType = "java.lang.String")
    private String patrolState;

    private static final long serialVersionUID = 1L;
}