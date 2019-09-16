package com.cj.hafter.service.impl;

import com.cj.core.domain.ApiResult;
import com.cj.core.domain.Pager;
import com.cj.core.entity.Resources;
import com.cj.core.entity.SaleType;
import com.cj.core.utils.excle.ImportExeclUtil;
import com.cj.hafter.entity.BCModel;
import com.cj.hafter.entity.DeclareVo;
import com.cj.hafter.entity.SaleInfo;
import com.cj.hafter.mapper.AResourcesMapper;
import com.cj.hafter.mapper.DeclareMapper;
import com.cj.hafter.mapper.STMapper;
import com.cj.hafter.service.AfterSaleService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * 售后管理
 * Created by JuLei on 2019/5/28.
 */
@Service
public class AfterSaleServiceImpl implements AfterSaleService {

    @Autowired
    private DeclareMapper declareMapper;

    @Autowired
    private AResourcesMapper resourcesMapper;
    @Autowired
    private STMapper stMapper;
    /**
     * 新增售后申报
     * @param declareVo
     * @param request
     * @return
     */
    @Override
    public int addDeclare(DeclareVo declareVo, HttpServletRequest request) {
        Date nowDate = new Date();
        //获取操作人id
        Long id = (Long) request.getSession().getAttribute("id");
        declareVo.setFounderId(id);
        declareVo.setCreateTime(nowDate);
        int i = declareMapper.insert(declareVo);
        //app端上传可以新增图片和视频
        List<Resources> imgList = declareVo.getImgList();
        if (i > 0 && imgList != null && imgList.size() != 0) {
            for (Resources resources : imgList) {
                resources.setCreateTime(nowDate);//创建时间
                resources.setFounderId(id);//创建人
                resources.setRelationId(declareVo.getDeclareId());//申报id
                //新增图片信息
                resourcesMapper.insert(resources);
            }
        }
        return i;
    }


    /**
     * 分页查询售后申报
     * @param pager
     * @param request
     * @return
     */
    @Override
    public Pager findAll(Pager pager, HttpServletRequest request) {
        pager.setRecords(this.declareMapper.findAll(pager));
        return pager;
    }

    /**
     * 编辑  修改执行人 和 执行时间
     * @param declareVo
     * @param request
     * @return
     */
    @Override
    public int update(DeclareVo declareVo, HttpServletRequest request) {
        return this.declareMapper.updateById(declareVo);
    }

    /**
     * 新增售后分类
     * @param list
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertBC(List<SaleType> list) {
        for(SaleType saleType : list){
            saleType.setAddState("2");
            stMapper.insert(saleType);
        }
        return 1;
    }

    /**
     * 修改售后分类
     * @param saleType
     * @return
     */
    @Override
    public int updateBC(SaleType saleType) {
        return stMapper.updateById(saleType);
    }

    /**
     * 查询分类列表
     * @param parameter
     * @return
     */
    @Override
    public List<BCModel> findBC(String parameter) {
        return stMapper.findBC(parameter);
    }

    /**
     * 导入售后分类
     * @param file
     * @param in
     * @return
     */
    @Override
    public ApiResult importInfo(MultipartFile file, InputStream in) {
        ApiResult apiResult;
        try {
            String fileName = file.getOriginalFilename(); //获取文件名
            Workbook workbook = ImportExeclUtil.chooseWorkbook(fileName, in);
            int sheets = workbook.getNumberOfSheets(); //获取sheet数量


            //遍历sheet  检查 父名称+子名称 是否有重复的值
            for (int i = 0; i < sheets; i++) {
                //读取sheet的第2行开始读取
                SaleInfo info = new SaleInfo();
                List<SaleInfo> readBaseInfo = ImportExeclUtil.readDateListT(workbook, info, 2, 0, i);
                if (readBaseInfo!=null){
                    for (SaleInfo data:readBaseInfo){
                        //查询一级分类
                        SaleType saleType1 = this.stMapper.findTypeByName(data.getType1(),"1",1L);
                        if (saleType1 == null){//没有这个分类
                            saleType1 = new SaleType();
                            saleType1.setSaleTypeName(data.getType1());//名称
                            saleType1.setParentId(1l);//父节点
                            saleType1.setLevel(1);//等级
                            //添加
                            this.stMapper.insertByName(saleType1);
                        }
                        //查询二级分类
                        SaleType saleType2 = this.stMapper.findTypeByName(data.getType2(),"2",saleType1.getSaleTypeId());
                        if (saleType2 == null){//没有这个分类
                            saleType2 = new SaleType();
                            saleType2.setSaleTypeName(data.getType2());//名称
                            saleType2.setParentId(saleType1.getSaleTypeId());//父节点
                            saleType2.setLevel(2);//等级
                            //添加
                            this.stMapper.insertByName(saleType2);
                        }
                        //查询三级分类
                        SaleType saleType3 = this.stMapper.findTypeByName(data.getType3(),"3",saleType2.getSaleTypeId());
                        if (saleType3 == null){//没有这个分类
                            saleType3 = new SaleType();
                            saleType3.setSaleTypeName(data.getType3());//名称
                            saleType3.setParentId(saleType2.getSaleTypeId());//父节点
                            saleType3.setLevel(3);//等级
                            //添加
                            this.stMapper.insertByName(saleType3);
                        }

                    }
                }
            }

        }catch (Exception e){
            e.printStackTrace();
            apiResult = ApiResult.FAIL();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//事务回滚
        }
        return null;
    }
}
