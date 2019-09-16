package com.cj.common.service.impl;

import com.cj.common.mapper.*;
import com.cj.common.service.FindService;
import com.cj.core.entity.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class FindServiceImpl implements FindService {


    @Resource
    private DepartmentMapper departmentMapper;

    @Resource
    private ItemNumMapper itemNumMapper;

    @Resource
    private SiteTypeMapper siteTypeMapper;

    @Resource
    private SiteCompanyMapper siteCompanyMapper;

    @Resource
    private SiteNatureMapper siteNatureMapper;

    @Resource
    private SiteUsageStateMapper siteUsageStateMapper;

    @Resource
    private ProductModelMapper productModelMapper;

    @Override
    public List<Department> findAllDepartment() {
        return departmentMapper.selectList(null);
    }

    @Override
    public List<ItemNumber> findAllItemNum() {
        return itemNumMapper.selectList(null);
    }

    @Override
    public List<SiteType> findAllSiteType() {
        return siteTypeMapper.selectList(null);
    }

    @Override
    public List<SiteCompany> findAllSiteCompany() {
        return siteCompanyMapper.selectList(null);
    }

    @Override
    public List<SiteNature> findAllSiteNature() {
        return siteNatureMapper.selectList(null);
    }

    @Override
    public List<SiteUsageState> findAllSiteUsageState() {
        return siteUsageStateMapper.selectList(null);
    }

    @Override
    public List<ProductModel> findAllProductModel() {
        return productModelMapper.selectList(null);
    }
}
