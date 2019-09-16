package com.cj.hmould.domain;

import com.cj.core.entity.CheckItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "检查项列表")
public class VoCheckItem extends CheckItem {


    @ApiModelProperty(name = "child",value = "子节点",dataType = "List<VoCheckItem>")
    private List<VoCheckItem> child;

    @ApiModelProperty(name = "select",value = "台站是否拥有当前节点",dataType = "Boolean")
    private boolean select;
}
