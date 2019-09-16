package com.cj.hmould.domain;


import com.cj.core.entity.SiteCheckItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "查询系统内所有模板树形结构及台站拥有的节点ID 返回值")
public class VoModuleAndSiteMoule {

    @ApiModelProperty(name = "voCheckItems",value = "系统节点列表",dataType = "List<VoCheckItem>")
    private List<VoCheckItem> voCheckItems;


//    @ApiModelProperty(name = "siteCheckItems",value = "台站拥有的节点ID",dataType = "Long")
//    private List<SiteCheckItem>  siteCheckItems;

}
