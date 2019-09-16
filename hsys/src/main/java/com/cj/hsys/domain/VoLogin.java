package com.cj.hsys.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "登录 类")
public class VoLogin {

    /**
     * 管理员账号
     */
    @ApiModelProperty(name = "adminName",value = "管理员账号",dataType = "java.lang.String")
    private String adminName;

    /**
     * 管理员密码
     */
    @ApiModelProperty(name = "adminPass",value = "管理员密码",dataType = "java.lang.String")
    private String adminPass;

    /**
     * 管理员账号
     */
    @ApiModelProperty(name = "client",value = "端口（APP/PC)",dataType = "java.lang.String")
    private String client;
}
