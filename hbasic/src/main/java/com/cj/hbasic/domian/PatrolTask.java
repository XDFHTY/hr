package com.cj.hbasic.domian;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 巡查记录 实体类
 * Created by win9 on 2019/5/22.
 */
@Data
public class PatrolTask {

    @ApiModelProperty(name = "patrolTaskStationId",value = "巡查任务台站表主键",dataType = "java.lang.Long")
    private Long patrolTaskStationId;

    @ApiModelProperty(name = "uploadTime",value = "提交时间",dataType = "java.util.Date")
    private Date uploadTime;

    @ApiModelProperty(name = "reachTime",value = "到站打卡时间",dataType = "java.util.Date")
    private Date reachTime;

    @ApiModelProperty(name = "leaveTime",value = "离站打卡时间",dataType = "java.util.Date")
    private Date leaveTime;

    @ApiModelProperty(name = "patrolId",value = "巡查人id",dataType = "java.lang.Long")
    private Long patrolId;

    @ApiModelProperty(name = "patrolName",value = "巡查人姓名",dataType = "java.lang.String")
    private String patrolName;

    @ApiModelProperty(name = "roleName",value = "角色",dataType = "java.lang.String")
    private String roleName;

    @ApiModelProperty(name = "departmentName",value = "部门",dataType = "java.lang.String")
    private String departmentName;

}
