package com.cj.common.service.impl;

import com.cj.common.domain.VoRegion;
import com.cj.common.mapper.PublicMapper;
import com.cj.common.service.RegionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {


    @Resource
    private PublicMapper publicMapper;


    @Override
    public List<VoRegion> findAllRegion2() {
        return publicMapper.findAllRegion2();
    }
    @Override
    public List<VoRegion> findAllRegion3() {
        return publicMapper.findAllRegion3();
    }

    @Override
    public List<VoRegion> findAllRegionP() {
        return publicMapper.findAllRegionP();
    }

    @Override
    public List<VoRegion> findAllRegionC(long pid) {
        return publicMapper.findAllRegionC(pid);
    }

    @Override
    public List<VoRegion> findAllRegionA(long cid) {
        return publicMapper.findAllRegionA(cid);
    }
}
