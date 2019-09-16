package com.cj.hbasic.service.impl;

import com.cj.core.domain.Pager;
import com.cj.core.entity.Device;
import com.cj.core.entity.Resources;
import com.cj.core.entity.Site;
import com.cj.hbasic.domian.DeviceVo;
import com.cj.hbasic.domian.SiteVo;
import com.cj.hbasic.mapper.DeviceMapper;
import com.cj.hbasic.mapper.ResourcesMapper;
import com.cj.hbasic.service.DeviceService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 设备管理
 * Created by win9 on 2019/5/23.
 */
@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceMapper deviceMapper;

    @Autowired
    private ResourcesMapper resourcesMapper;


    /**
     * 分页查询归属地下的 设备列表
     * @param pager
     * @param request
     * @return
     */
    @Override
    public Pager findAll(Pager pager, HttpServletRequest request) {
        HttpSession session = request.getSession();
        //有归属地就查询归属地下的  没有归属地就查全部
        Long pid = (Long) session.getAttribute("pid");
        Long cid = (Long) session.getAttribute("cid");
        Map map1 = new HashMap();
        if (pid != 0){
            map1.put("pid",pid);
        }
        if (cid != 0){
            map1.put("cid",cid);
        }
        pager.setParameters(map1);

        // 分页查询归属地下的 设备列表
        List<DeviceVo> deviceVos = this.deviceMapper.findAll(pager);
        pager.setRecords(deviceVos);

        return pager;
    }


    /**
     * 根据设备id 查询设备详情
     * @param deviceId
     * @param request
     * @return
     */
    @Override
    public DeviceVo findDevicesById(Integer deviceId, HttpServletRequest request) {
        DeviceVo deviceVo = this.deviceMapper.findDevicesByDeviceId(deviceId);
        if(deviceVo!=null){
            //统计设备维护次数  按照华日的次数概念统计
            deviceVo.setNum(this.deviceMapper.findDevicesNum(deviceId));
        }
        return deviceVo;
    }

    /**
     * 新增设备
     * @param deviceVo
     * @param request
     * @return
     */
    @Override
    public int addSite(DeviceVo deviceVo, HttpServletRequest request) {
        //获取操作人id
        Long id = (Long) request.getSession().getAttribute("id");

        Date nowDate = new Date();
        deviceVo.setCreateTime(nowDate);

        //新增设备信息
        int i = deviceMapper.insert(deviceVo);

        List<Resources> imgList = deviceVo.getImgList();
        if (i > 0 && imgList != null && imgList.size() != 0) {
            for (Resources resources : imgList) {
                resources.setCreateTime(nowDate);//创建时间
                resources.setFounderId(id);//创建人
                resources.setResourceType("设备图片");//图片类型
                resources.setRelationId(deviceVo.getDeviceId());//设备id
                //新增图片信息
                resourcesMapper.insert(resources);
            }
        }


        return i;
    }

    /**
     * 删除设备图片
     * @param resourceId
     * @param request
     * @return
     */
    @Override
    public int deleteDeviceImgById(Long resourceId, HttpServletRequest request) {
        int i = resourcesMapper.deleteById(resourceId);
        return i;
    }

    /**
     * 编辑设备
     * @param deviceVo
     * @param request
     * @return
     */
    @Override
    public int updateSite(DeviceVo deviceVo, HttpServletRequest request) {
        //获取操作人id
        Long id = (Long) request.getSession().getAttribute("id");
        Date nowDate = new Date();

        int i = deviceMapper.updateById(deviceVo);

        List<Resources> imgList = deviceVo.getImgList();
        if (imgList != null && imgList.size()!=0){
            for (Resources resources:imgList){
                if (resources.getResourceId() != null){
                    //修改
                    resourcesMapper.updateById(resources);
                }else {
                    //新增
                    resources.setCreateTime(nowDate);//创建时间
                    resources.setFounderId(id);//创建人
                    resources.setResourceType("设备图片");//图片类型
                    resources.setRelationId(deviceVo.getDeviceId());//设备id
                    //新增图片信息
                    resourcesMapper.insert(resources);
                }

            }
        }


        return 1;
    }

    /**
     * 删除设备
     * @param deviceId
     * @param request
     */
    @Override
    public void deleteById(Long deviceId, HttpServletRequest request) {
        Device device = new Device();
        device.setDeviceId(deviceId);
        device.setIsDeleteState("0");//删除状态 0-已删除 1-正常
        deviceMapper.updateById(device);
    }
}
