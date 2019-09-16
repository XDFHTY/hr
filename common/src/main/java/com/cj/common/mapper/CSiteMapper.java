package com.cj.common.mapper;

import com.cj.common.domain.CSiteVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by win9 on 2019/5/22.
 */
public interface CSiteMapper {

    //按地区、类型查询站点列表
    List<CSiteVo> findAllByIds(@Param("type") Integer type, @Param("pid")Integer pid, @Param("cid")Integer cid);
}
