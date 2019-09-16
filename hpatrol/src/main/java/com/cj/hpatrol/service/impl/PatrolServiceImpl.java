package com.cj.hpatrol.service.impl;

import com.cj.core.domain.Pager;
import com.cj.core.entity.PatrolCycle;
import com.cj.core.entity.PatrolTaskStation;
import com.cj.core.exception.MyException;
import com.cj.hpatrol.domain.PatrolCycleModel;
import com.cj.hpatrol.domain.PatrolStationModel;
import com.cj.hpatrol.domain.PatrolTaskModel;
import com.cj.hpatrol.domain.PatrolTaskStationModel;
import com.cj.hpatrol.mapper.PCPatrolMapper;
import com.cj.hpatrol.mapper.PSPatrolMapper;
import com.cj.hpatrol.mapper.PTPPatrolMapper;
import com.cj.hpatrol.mapper.PTSPatrolMapper;
import com.cj.hpatrol.service.PatrolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author： 刘磊
 * @Description: 巡查业务实现层
 * @date： 2019/5/20 17:39
 **/
@Service
@Transactional
public class PatrolServiceImpl implements PatrolService {

    @Autowired
    private PCPatrolMapper pcPatrolMapper;
    @Autowired
    private PSPatrolMapper psPatrolMapper;
    @Autowired
    private PTPPatrolMapper ptpPatrolMapper;
    @Autowired
    private PTSPatrolMapper ptsPatrolMapper;
    /**
     * 新增周期巡查计划
     * @param patrolCycleModel
     * @return
     */
    @Override
    public int inerstPatrolCycle(PatrolCycleModel patrolCycleModel, HttpSession session) {
        patrolCycleModel.setCreateName(session.getAttribute("name").toString());
        pcPatrolMapper.insert(patrolCycleModel);
        for(PatrolStationModel patrolStationModel : patrolCycleModel.getListPSM()){
            patrolStationModel.setPatrolCycleId(patrolCycleModel.getPatrolCycleId());
            psPatrolMapper.insert(patrolStationModel);
        }
        return 1;
    }

    /**
     * 新增专项巡查计划
     * @param patrolTaskModel
     * @return
     */
    @Override
    public int inerstPatrolTask(PatrolTaskModel patrolTaskModel) {
        ptpPatrolMapper.insert(patrolTaskModel);
        for(PatrolTaskStationModel patrolTaskStationModel : patrolTaskModel.getListTSM()){
            patrolTaskStationModel.setPatrolTaskProvinceId(patrolTaskModel.getPatrolTaskProvinceId());
            ptsPatrolMapper.insert(patrolTaskStationModel);
        }
        return 1;
    }

    /**
     * 删除周期巡查计划
     * @param list
     * @return
     */
    @Override
    public int deletePatrolCycle(List<Long> list) {
        for(Long id:list){
            pcPatrolMapper.deleteById(id);
            psPatrolMapper.deleteByPatrolCycleId(id);
        }
        return 1;
    }

    /**
     * 删除专项巡查计划
     * @param list
     * @return
     */
    @Override
    public int deletePatrolTask(List<Long> list) {
        for(Long id:list){
            //查询是否开始或完成
            List<PatrolTaskStation> listPTS = ptsPatrolMapper.findStateByPatrolTaskProvinceId(id);
            if(listPTS.size()==0){
                ptpPatrolMapper.deleteById(id);
                ptsPatrolMapper.deleteByPatrolTaskProvinceId(id);
            }else{
                throw new MyException("有任务已开始执行或完成");
            }
        }
        return 1;
    }

    /**
     * 修改巡查人名字
     * @param patrolCycle
     * @return
     */
    @Override
    public int updatePatrolName(PatrolCycle patrolCycle) {
        return pcPatrolMapper.updateById(patrolCycle);
    }

    /**
     * 查询周期巡查计划
     * @param pager
     * @return
     */
    @Override
    public Pager findPatrolCycle(Pager pager) {
        //查询总条数
        //pager.setRecordTotal(patrolCycleMapper.findCount(pager));
        //查询数据
        pager.setRecords(pcPatrolMapper.findPage(pager));
        return pager;
    }

    /**
     * 查询专项巡查计划
     * @param pager
     * @return
     */
    @Override
    public Pager findPatrolTask(Pager pager) {
        //查询总条数
        //pager.setRecordTotal(patrolTaskProvinceMapper.findCount(pager));
        //查询数据
        List<PatrolTaskModel> list = ptpPatrolMapper.findPage(pager);
        //循环判断任务状态
        for(PatrolTaskModel patrolTaskModel:list){
            //查询所有子任务
            List<PatrolTaskStationModel> modelList = ptsPatrolMapper
                    .findByPatrolTaskProvinceId(patrolTaskModel.getPatrolTaskProvinceId());
            //遍历子任务状态
            if(modelList.stream().allMatch(model->model.getPatrolState().equals("0"))){
                patrolTaskModel.setPatrolState("未开始");
            }else{
                if(modelList.stream().anyMatch(model->model.getPatrolState().equals("0"))){
                    patrolTaskModel.setPatrolState("正在巡查");
                }else{
                    patrolTaskModel.setPatrolState("已完成");
                }
            }
        }
        pager.setRecords(list);
        return pager;
    }

    /**
     * 查询巡查记录
     * @param pager
     * @return
     */
    @Override
    public Pager findPatrolTaskStation(Pager pager) {
        //查询总条数
        //pager.setRecordTotal(patrolTaskStationMapper.findCount(pager));
        //查询数据
        pager.setRecords(ptsPatrolMapper.findPage(pager));
        return pager;
    }

    /**
     * 根据用户和类型查询巡查任务
     * @param pager
     * @param session
     * @return
     */
    @Override
    public Pager findCycle(Pager pager, HttpSession session) {
         String roles = ((List<Map>)session.getAttribute("roles"))
                 .get(0)
                 .get("roleName")
                 .toString();
         //员工查全部未指派 办事处员工查归属地未指派
         if(!roles.equals("员工")){
             if(!roles.equals("办事处员工")){
                 pager.setParameter(session.getAttribute("id").toString());
             }else{
                 Long pid = (Long) session.getAttribute("pid");
                 Long cid = (Long) session.getAttribute("cid");
                 Map<String,Long> map = new HashMap<>();
                 map.put("pid",pid);
                 map.put("cid",cid);
                 pager.setParameters(map);
             }
         }
        //查询数据
        pager.setRecords(ptpPatrolMapper.findCycle(pager));
        return pager;
    }

    /**
     * 根据用户和类型查询巡查任务历史
     * @param pager
     * @param session
     * @return
     */
    @Override
    public Pager findHistory(Pager pager, HttpSession session) {
        pager.setParameter(session.getAttribute("id").toString());
        //查询数据
        pager.setRecords(ptpPatrolMapper.findHistory(pager));
        return pager;
    }

    /**
     * 根据台站查询巡查任务
     * @param pager
     * @return
     */
    @Override
    public Pager findBySiteId(Pager pager,HttpSession session) {
        Map<String,String> map = new HashMap<>();
        map.put("id",session.getAttribute("id").toString());
        pager.setParameters(map);
        pager.setRecords(ptpPatrolMapper.findBySiteId(pager));
        return pager;
    }

    /**
     * 签到 1 到站 2离站
     * @param i
     * @param id
     * @return
     */
    @Override
    public int sign(int i,Long id) {
        PatrolTaskStation patrolTaskStation = new PatrolTaskStation();
        patrolTaskStation.setPatrolTaskStationId(id);
        if(i==1){
            patrolTaskStation.setReachTime(new Date());
        }else if(i==2){
            patrolTaskStation.setLeaveTime(new Date());
        }else{
            throw new MyException("签到类型错误");
        }
        return ptsPatrolMapper.updateById(patrolTaskStation);
    }
}
