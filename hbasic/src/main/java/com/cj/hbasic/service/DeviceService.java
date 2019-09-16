package com.cj.hbasic.service;

import com.cj.core.domain.Pager;
import com.cj.hbasic.domian.DeviceVo;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by win9 on 2019/5/23.
 */
public interface DeviceService {

    //分页查询归属地下的 设备列表
    Pager findAll(Pager pager, HttpServletRequest request);

    //根据设备id 查询设备详情
    DeviceVo findDevicesById(Integer deviceId, HttpServletRequest request);

    //新增设备
    int addSite(DeviceVo deviceVo, HttpServletRequest request);

    //删除设备图片
    int deleteDeviceImgById(Long resourceId, HttpServletRequest request);

    //编辑设备
    int updateSite(DeviceVo deviceVo, HttpServletRequest request);

    //删除设备
    void deleteById(Long deviceId, HttpServletRequest request);
}
