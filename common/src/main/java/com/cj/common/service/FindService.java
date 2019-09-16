package com.cj.common.service;

import com.cj.core.entity.*;

import java.util.List;

/**
 * 公共的单表查询
 */

public interface FindService {

    //查部门
    public List<Department> findAllDepartment();

    //查项目编号
    public List<ItemNumber> findAllItemNum();

    //查台站类型
    public List<SiteType> findAllSiteType();

    //查询台站所属单位
    public List<SiteCompany> findAllSiteCompany();

    //查询站点性质
    public List<SiteNature> findAllSiteNature();

    //查询站点状态
    public List<SiteUsageState> findAllSiteUsageState();

    //查询产品型号
    public List<ProductModel> findAllProductModel();
}
