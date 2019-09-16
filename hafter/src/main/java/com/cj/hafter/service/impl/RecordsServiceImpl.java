package com.cj.hafter.service.impl;

import com.cj.core.domain.Pager;
import com.cj.core.entity.Resources;
import com.cj.core.entity.SaleNum;
import com.cj.hafter.entity.DeclareVo;
import com.cj.hafter.entity.RepairRecordVo;
import com.cj.hafter.mapper.AResourcesMapper;
import com.cj.hafter.mapper.DeclareMapper;
import com.cj.hafter.mapper.RepairRecordMapper;
import com.cj.hafter.service.RecordsService;
import org.aspectj.weaver.patterns.Declare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 售后记录 业务模块
 * Created by JuLei on 2019/5/31.
 */
@Service
@Transactional
public class RecordsServiceImpl implements RecordsService {


    @Autowired
    private DeclareMapper declareMapper;

    @Autowired
    private RepairRecordMapper repairRecordMapper;

    @Autowired
    private AResourcesMapper resourcesMapper;

    /**
     * 查询已完成和未完成的售后任务
     * 员工 ：可见所有未指派的任务 和 指派给他的任务
     * 办事处员工： 可见归属地下未指派的任务 和 指派给他的任务
     * 其他： 可见指派给他的任务
     */
    @Override
    public Pager findAll(Pager pager, HttpServletRequest request) {
        HttpSession session = request.getSession();
        //有归属地就查询归属地下的  没有归属地就查全部
        Long pid = (Long) session.getAttribute("pid");
        Long cid = (Long) session.getAttribute("cid");
        Long id = (Long) session.getAttribute("id");
        Map map1 = new HashMap();
        if (pid != 0){
            map1.put("pid",pid);
        }
        if (cid != 0){
            map1.put("cid",cid);
        }
        map1.put("id",id);
        pager.setParameters(map1);
        //获取操作人角色
        List<Map> roles  = (List<Map>) session.getAttribute("roles");
        Map map = roles.get(0);
        String roleName = (String) map.get("roleName");

        //返回对象
        List<DeclareVo> declares;
        if("员工".equals(roleName) || "办事处员工".equals(roleName)){
            //查询归属地下  指派给他和未指派的任务   员工没有归属地
            declares = this.declareMapper.findFRecords(pager);
        }else {
            //查询指派给他的任务
            declares = this.declareMapper.findDeclareByExeId(pager);
        }
        pager.setRecords(declares);
        return pager;
    }


    /**
     * 查询维修记录
     * @param declareId
     * @param request
     * @return
     */
    @Override
    public List<RepairRecordVo> findRepairRecord(Long declareId, HttpServletRequest request) {
        return this.declareMapper.findRepairRecord(declareId);
    }


    /**
     * 新增维修记录
     * @param siteVos
     * @param request
     * @return
     */
    @Override
    public int insertRepairRecord(List<RepairRecordVo> recordVos, HttpServletRequest request) {
        //获取操作人id
        Long id = (Long) request.getSession().getAttribute("id");
        Date nowDate = new Date();


        if (recordVos!=null && recordVos.size()!=0){

            //查看当前申报的维护次数
            Integer num = this.declareMapper.findSaleNumById(recordVos.get(0).getDeclareId());
            //新增申报维护记录
            SaleNum saleNum = new SaleNum();
            saleNum.setDeclareId(recordVos.get(0).getDeclareId());
            saleNum.setFounderId(id);
            saleNum.setCreateTime(nowDate);
            if (num == null){
                saleNum.setNum(1);
            }else {
                saleNum.setNum(num + 1);
            }

            this.declareMapper.insertSaleNum(saleNum);


            for (RepairRecordVo recordVo:recordVos){
                recordVo.setMaintainTime(nowDate);
                recordVo.setMaintainPeopleId(id);
                recordVo.setSaleNumId(saleNum.getSaleNumId());
                int i = this.repairRecordMapper.insert(recordVo);
                if (i == 0){
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//事务回滚
                    return 0;
                }
                //添加图片
                List<Resources> imgList = recordVo.getImgList();
                if (i > 0 && imgList != null && imgList.size() != 0) {
                    for (Resources resources : imgList) {
                        resources.setCreateTime(nowDate);//创建时间
                        resources.setFounderId(id);//创建人
                        resources.setRelationId(recordVo.getRepairRecordId());//记录id
                        //新增图片信息
                        resourcesMapper.insert(resources);
                    }
                }

            }
        }
        return 1;
    }


    /**
     * 追加记录   修改描述 和 新增图片、视频
     * @param recordVos
     * @param request
     * @return
     */
    @Override
    public int updateRepairRecord(List<RepairRecordVo> recordVos, HttpServletRequest request) {
        //获取操作人id
        Long id = (Long) request.getSession().getAttribute("id");
        Date nowDate = new Date();

        if (recordVos != null && recordVos.size() != 0) {
            for (RepairRecordVo recordVo:recordVos){
                //描述不为空 才执行sql  不然就全部值都为null 会报错
                if (recordVo.getDescribeContent() != null){
                    repairRecordMapper.updateById(recordVo);
                }

                //添加图片
                List<Resources> imgList = recordVo.getImgList();
                if (imgList != null && imgList.size() != 0) {
                    for (Resources resources : imgList) {
                        resources.setCreateTime(nowDate);//创建时间
                        resources.setFounderId(id);//创建人
                        resources.setRelationId(recordVo.getRepairRecordId());//记录id
                        //新增图片信息
                        resourcesMapper.insert(resources);
                    }
                }
            }
        }


        return 1;
    }


    /**
     * 根据台站id查询历史申报列表
     * @param pager
     * @param request
     * @return
     */
    @Override
    public Pager findAllBySiteId(Pager pager, HttpServletRequest request) {
        List<DeclareVo> list = declareMapper.findAllBySiteId(pager);
        pager.setRecords(list);
        return pager;
    }

    /**
     * 修改任务状态
     * @param declareVo
     * @param request
     * @return
     */
    @Override
    public int updateDeclareState(DeclareVo declareVo, HttpServletRequest request) {
        if ("已完成".equals(declareVo.getHandleState())){
            declareVo.setComTime(new Date());//设置完成时间
        }
        return this.declareMapper.updateById(declareVo);
    }
}
