package com.cj.hpatrol.service.impl;

import com.cj.hpatrol.domain.PatrolCycleModel;
import com.cj.hpatrol.domain.PatrolStationModel;
import com.cj.hpatrol.domain.PatrolTaskModel;
import com.cj.hpatrol.domain.PatrolTaskStationModel;
import com.cj.hpatrol.mapper.PCPatrolMapper;
import com.cj.hpatrol.mapper.PTPPatrolMapper;
import com.cj.hpatrol.mapper.PTSPatrolMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

/**
 * @author： 刘磊
 * @Description: 根据周期计划生成任务
 * @date： 2019/5/22 11:49
 **/
@Slf4j
@Component
@EnableScheduling
public class CycleService {

    @Autowired
    private PCPatrolMapper pcPatrolMapper;
    @Autowired
    private PTPPatrolMapper ptpPatrolMapper;
    @Autowired
    private PTSPatrolMapper ptsPatrolMapper;
    /**
     * 每天上午3点执行一次
     */
    @Scheduled(cron = "0 0 3 * * *")
//    @Scheduled(cron = "0/10 * * * * *")
    @Async("getAsyncExecutor")
    public void cycleTask(){
        System.out.println("==================生成任务=========开始=========");
        //查出所有的周期计划
        List<PatrolCycleModel> allPC = pcPatrolMapper.findAll();
        //遍历判断是否到了发布任务时间
        for(PatrolCycleModel patrolCycleModel:allPC){
            //延后相应周期后的时间
            Date addMon = addMonth(patrolCycleModel.getStartTime(),
                    patrolCycleModel.getCycle(),
                    patrolCycleModel.getExecuteNum());
            //提前相应天数
            Date cutDay = cutDay(addMon, patrolCycleModel.getAdvance());
            //计算周期后如果小于等于当前时间
            if(!cutDay.after(new Date())&&cutDay.before(new Date())){
                PatrolTaskModel patrolTaskModel = CtoT(patrolCycleModel);
                ptpPatrolMapper.insert(patrolTaskModel);
                for(PatrolTaskStationModel patrolTaskStationModel:patrolTaskModel.getListTSM()){
                    patrolTaskStationModel.setPatrolTaskProvinceId(patrolTaskModel.getPatrolTaskProvinceId());
                    ptsPatrolMapper.insert(patrolTaskStationModel);
                }
                patrolCycleModel.setExecuteNum(patrolCycleModel.getExecuteNum()+1);
                pcPatrolMapper.updateById(patrolCycleModel);
            }
        }
        System.out.println("==================生成任务=========结束=========");
    }

    /**
     * 根据模板设置任务内容
     * @param patrolCycleModel
     * @return
     */
    public PatrolTaskModel CtoT(PatrolCycleModel patrolCycleModel){
        PatrolTaskModel patrolTaskModel = new PatrolTaskModel();
        //设置任务名字
        patrolTaskModel.setTaskName(patrolCycleModel.getTaskName());
        //设置执行人id
        patrolTaskModel.setPatrolId(patrolCycleModel.getPatrolId());
        //设置省id
        patrolTaskModel.setProvinceId(patrolCycleModel.getProvinceId());
        //设置任务类型
        patrolTaskModel.setTaskType("周期任务");
        //设置开始时间
        patrolTaskModel.setStartTime(addMonth(patrolCycleModel.getStartTime(),
                patrolCycleModel.getCycle(),
                patrolCycleModel.getExecuteNum()));
        //设置结束时间
        patrolTaskModel.setEndTime(addMonth(patrolCycleModel.getEndTime(),
                patrolCycleModel.getCycle(),
                patrolCycleModel.getExecuteNum()));
        //设置子任务
        List<PatrolTaskStationModel> listTSM = new ArrayList<>();
        for(PatrolStationModel patrolStationModel:patrolCycleModel.getListPSM()){
            PatrolTaskStationModel patrolTaskStationModel = new PatrolTaskStationModel();
            //设置台站id
            patrolTaskStationModel.setSiteId(patrolStationModel.getSiteId());
            //设置执行人id
            patrolTaskStationModel.setPatrolId(patrolCycleModel.getPatrolId());
            //设置开始时间
            patrolTaskStationModel.setStartTime(addMonth(patrolStationModel.getEndTime(),
                    patrolCycleModel.getCycle(),
                    patrolCycleModel.getExecuteNum()));
            //设置结束时间
            patrolTaskStationModel.setEndTime(addMonth(patrolStationModel.getEndTime(),
                    patrolCycleModel.getCycle(),
                    patrolCycleModel.getExecuteNum()));
            //设置任务状态
            patrolTaskStationModel.setPatrolState("0");
            listTSM.add(patrolTaskStationModel);
        }
        patrolTaskModel.setListTSM(listTSM);
        return patrolTaskModel;
    }
    /**
     * 将开始时间根据执行次数推后指定月份
     * @param nowDate 周期开始时间
     * @param cycle 周期
     * @param num 执行次数
     * @return
     */
    public Date addMonth(Date nowDate,int cycle,int num){
        //转换时间格式
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //Date转LocalDateTime
        Instant instant = nowDate.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localNowDate = LocalDateTime.ofInstant(instant, zone);
        //将时间赋值给Calendar
//        int year = localNowDate.getYear();
//        int month = localNowDate.getMonth().getValue();
//        int day = localNowDate.getDayOfMonth();
//        System.out.println("年-》"+year+"月-》"+month+"日-》"+day);
        Calendar nowTime = new GregorianCalendar(localNowDate.getYear(),
                localNowDate.getMonth().getValue()-1,
                localNowDate.getDayOfMonth(),0,0,0);
//        System.out.println("周期："+cycle);
//        System.out.println("执行次数："+num);
//        System.out.println("开始时间：" + sdf.format(nowTime.getTime()));
        nowTime.add(Calendar.MONTH, cycle*num);
//        System.out.println("延时"+cycle*num+"月后时间：" + sdf.format(nowTime.getTime()));
        return nowTime.getTime();
    }

    /**
     * 将开始时间提前相应天数
     * @param nowDate 任务开始时间
     * @param advance 提前天数
     * @return
     */
    public Date cutDay(Date nowDate,int advance){
        //转换时间格式
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //Date转LocalDateTime
        Instant instant = nowDate.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localNowDate = LocalDateTime.ofInstant(instant, zone);
        //将时间赋值给Calendar
//        int year = localNowDate.getYear();
//        int month = localNowDate.getMonth().getValue();
//        int day = localNowDate.getDayOfMonth();
//        System.out.println("年-》"+year+"月-》"+month+"日-》"+day);
        Calendar nowTime = new GregorianCalendar(localNowDate.getYear(),
                localNowDate.getMonth().getValue()-1,
                localNowDate.getDayOfMonth(),0,0,0);
//        System.out.println("开始时间：" + sdf.format(nowTime.getTime()));
        nowTime.add(Calendar.DATE, -advance);
//        System.out.println("提前"+advance+"天后时间：" + sdf.format(nowTime.getTime()));
        return nowTime.getTime();
    }
}
