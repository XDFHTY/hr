package com.cj.hbasic.service.impl;

import com.cj.core.domain.Pager;
import com.cj.core.entity.Resources;
import com.cj.hbasic.domian.ResourcesVo;
import com.cj.hbasic.mapper.ResourcesMapper;
import com.cj.hbasic.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * 文档管理
 * Created by JuLei on 2019/6/3.
 */
@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private ResourcesMapper resourcesMapper;

    /**
     * 分页查询文档列表
     * @param pager
     * @param request
     * @return
     */
    @Override
    public Pager findAll(Pager pager, HttpServletRequest request) {
        List<ResourcesVo> list = this.resourcesMapper.findAllDocument(pager);
        pager.setRecords(list);
        return pager;
    }

    /**
     * 上传文档
     * @param resourcesVo
     * @param request
     * @return
     */
    @Override
    public int addDocument(ResourcesVo resourcesVo, HttpServletRequest request) {
        //获取操作人id
        Long id = (Long) request.getSession().getAttribute("id");
        resourcesVo.setCreateTime(new Date());
        resourcesVo.setFounderId(id);
        resourcesVo.setResourceType("文档");
        return this.resourcesMapper.insert(resourcesVo);
    }

    /**
     * 删除文档
     *
     * @param ids
     * @param request
     */
    @Override
    public void deleteById(List<String> ids, HttpServletRequest request) {
        if (ids!=null && ids.size() != 0){
            for (String id:ids){
                this.resourcesMapper.deleteById(Long.valueOf(id));
            }
        }

    }
}
