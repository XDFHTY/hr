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
@ApiModel(value = "auth_customer_role")
public class AuthCustomerRole implements Serializable {
    /**
     * 用户—角色关系表主键
     */
    @ApiModelProperty(name = "id",value = "用户—角色关系表主键",dataType = "java.lang.Long")
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户id-包括admin和user ID
     */
    @ApiModelProperty(name = "customerId",value = "用户id-包括admin和user ID",dataType = "java.lang.Long")
    private Long customerId;

    /**
     * 角色id
     */
    @ApiModelProperty(name = "roleId",value = "角色id",dataType = "java.lang.Long")
    private Long roleId;

    private static final long serialVersionUID = 1L;
}