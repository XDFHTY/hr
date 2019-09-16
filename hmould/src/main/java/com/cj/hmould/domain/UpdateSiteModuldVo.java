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
@ApiModel(value = "更新台站节点信息参数")
public class UpdateSiteModuldVo {
    @ApiModelProperty(name = "siteId",value = "台站ID",dataType = "Long")
    private long siteId;

    @ApiModelProperty(name = "siteCheckItems",value = "台站拥有的节点ID",dataType = "Long")
    private List<SiteCheckItem> siteCheckItems;
}
