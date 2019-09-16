package com.cj.core.domain;

import com.cj.core.entity.OperateLog;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "日志查询 结果")
public class VoLog extends OperateLog {


    @ApiModelProperty(name = "fullName",value = "姓名",dataType = "java.lang.String")
    private String fullName;

    @ApiModelProperty(name = "roleName",value = "角色",dataType = "java.lang.String")
    private String roleName;
}
