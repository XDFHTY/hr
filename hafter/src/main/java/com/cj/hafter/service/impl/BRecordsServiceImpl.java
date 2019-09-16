package com.cj.hafter.service.impl;

import com.cj.core.domain.Pager;
import com.cj.hafter.entity.DeclareVo;
import com.cj.hafter.entity.RepairRecordVo;
import com.cj.hafter.mapper.AResourcesMapper;
import com.cj.hafter.mapper.DeclareMapper;
import com.cj.hafter.mapper.RepairRecordMapper;
import com.cj.hafter.service.BRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 后台售后记录管理
 * Created by JuLei on 2019/6/3.
 */
@Service
public class BRecordsServiceImpl implements BRecordsService {

    @Autowired
    private DeclareMapper declareMapper;

    @Autowired
    private RepairRecordMapper repairRecordMapper;

    @Autowired
    private AResourcesMapper aResourcesMapper;

    /**
     * 分页查询售后记录
     *
     * @param pager
     * @param request
     * @return
     */
    @Override
    public Pager findAll(Pager pager, HttpServletRequest request) {
        List<DeclareVo> list = declareMapper.findAllRecords(pager);
        if (list != null && list.size()!=0){
            for (DeclareVo info :list){
                //查询最后维护人和最后维护时间
                Map map = this.declareMapper.findLastMaintainPeopleAndTime(info.getDeclareId());
                if (map != null){
                    if (map.get("fullName") != null){
                        info.setLastMaintainPeople((String) map.get("fullName"));
                    }
                    if (map.get("maintainTime") != null){
                        info.setLastMaintainTime((Date) map.get("maintainTime"));
                    }
                }

            }
        }


        pager.setRecords(list);
        return pager;
    }


    /**
     * 查询维护次数列表
     * @param declareId
     * @param request
     * @return
     */
    @Override
    public List<Map> findNumById(Long declareId, HttpServletRequest request) {
        return this.declareMapper.findNumById(declareId);
    }

    /**
     * 查询维护详情
     * @param saleNumId
     * @param request
     * @return
     */
    @Override
    public List<RepairRecordVo> findRecordsById(Long saleNumId, HttpServletRequest request) {
        return this.declareMapper.findRecordsById(saleNumId);
    }

    /**
     * 编辑处理详情
     * @param repairRecordVo
     * @param request
     * @return
     */
    @Override
    public int updateRecord(RepairRecordVo repairRecordVo, HttpServletRequest request) {
        return this.repairRecordMapper.updateById(repairRecordVo);
    }

    /**
     * 删除售后图片或视频
     * @param resourceId
     * @param request
     * @return
     */
    @Override
    public int deleteSaleImg(Long resourceId, HttpServletRequest request) {
        return this.aResourcesMapper.deleteById(resourceId);
    }
}
