package com.cj.hafter.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cj.core.entity.SaleType;
import com.cj.hafter.entity.BCModel;
import com.cj.hafter.entity.SaleInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author： 刘磊
 * @Description: ${description}
 * @date： 2019/5/31 10:28
 **/
public interface STMapper extends BaseMapper<SaleType> {
    /**
     * 查询分类列表
     * @param parameter
     * @return
     */
    List<BCModel> findBC(@Param("parameter") String parameter);

    //根据名称查询分类
    SaleType findTypeByName(@Param("name") String type1,@Param("level") String level,@Param("parentId") Long parentId);

    //添加
    void insertByName(SaleType saleType1);
}
