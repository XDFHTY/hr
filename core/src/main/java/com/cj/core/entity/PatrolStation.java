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
@ApiModel(value = "patrol_station")
public class PatrolStation implements Serializable {
    /**
     * 巡查周期市表主键
     */
    @ApiModelProperty(name = "patrolStationId",value = "巡查周期市表主键",dataType = "java.lang.Long")
    @TableId(type = IdType.AUTO)
    private Long patrolStationId;

    /**
     * 巡查周期记录省表id
     */
    @ApiModelProperty(name = "patrolCycleId",value = "巡查周期记录省表id",dataType = "java.lang.Long")
    private Long patrolCycleId;

    /**
     * 台站id
     */
    @ApiModelProperty(name = "siteId",value = "台站id",dataType = "java.lang.Long")
    private Long siteId;

    /**
     * 市id
     */
    @ApiModelProperty(name = "cityId",value = "市id",dataType = "java.lang.Long")
    private Long cityId;

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