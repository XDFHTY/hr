package com.cj.hbasic.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cj.core.domain.Pager;
import com.cj.core.entity.Device;
import com.cj.core.entity.Resources;
import com.cj.hbasic.domian.DeviceVo;

import java.util.List;

/**
 * Created by win9 on 2019/5/22.
 */
public interface DeviceMapper extends BaseMapper<Device> {
    //根据台站id查询设备列表
    List<DeviceVo> findDevicesBySiteId(Pager pager);

    List<Resources> findDeviceImgById(Long deviceId);

    // 分页查询归属地下的 设备列表
    List<DeviceVo> findAll(Pager pager);

    //根据设备id 查询设备详情
    DeviceVo findDevicesByDeviceId(Integer deviceId);

    //统计设备维护次数
    Integer findDevicesNum(Integer deviceId);
}
