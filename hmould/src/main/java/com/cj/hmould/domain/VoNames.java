package com.cj.hmould.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "巡检任务内容")
public class VoNames {


    @ApiModelProperty(name = "scimId",value = "主键")
    private long scimId;

    @ApiModelProperty(name = "patrolTaskStationId",value = "巡查任务台站表ID")
    private long patrolTaskStationId;


    @ApiModelProperty(name = "name",value = "检查项名称")
    private String name;

    @ApiModelProperty(name = "checkItemMsg",value = "检查项说明")
    private String checkItemMsg;

    @ApiModelProperty(name = "checkItemResult",value = "检查项结果（图片地址）")
    private String checkItemResult;

    @ApiModelProperty(name = "names",value = "子节点")
    private List<VoNames> names;

}
