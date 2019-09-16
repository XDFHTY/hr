package com.cj.hsys.domain;

import com.cj.core.entity.AdminInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoAdminInfo extends AdminInfo {

    @ApiModelProperty(name = "departmentName",value = "部门名称",dataType = "java.lang.String")
    private String departmentName;
}
