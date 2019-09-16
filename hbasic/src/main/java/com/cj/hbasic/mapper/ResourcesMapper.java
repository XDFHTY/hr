package com.cj.hbasic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cj.core.domain.Pager;
import com.cj.core.entity.Resources;
import com.cj.hbasic.domian.ResourcesVo;

import java.util.List;

/**
 * Created by win9 on 2019/5/21.
 */
public interface ResourcesMapper extends BaseMapper<Resources> {
    //把这个台站的台站图片全部删除
    void deleteBySiteId(Long siteId);

    //分页查询文档列表
    List<ResourcesVo> findAllDocument(Pager pager);
}
