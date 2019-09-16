package com.cj.hbasic.domian;

import com.cj.core.entity.Resources;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 文档管理
 * Created by JuLei on 2019/6/3.
 */
@Data
public class ResourcesVo extends Resources {
    //上传人姓名
    @ApiModelProperty(name = "fullName",value = "上传人姓名",dataType = "java.lang.String")
    private String fullName;

}
