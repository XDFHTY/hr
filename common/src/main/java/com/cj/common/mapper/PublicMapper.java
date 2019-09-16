package com.cj.common.mapper;

import com.cj.common.domain.VoRegion;

import java.util.List;

public interface PublicMapper {

    public List<VoRegion> findAllRegion2();
    public List<VoRegion> findAllRegion3();

    public List<VoRegion> findAllRegionP();
    public List<VoRegion> findAllRegionC(long pid);
    public List<VoRegion> findAllRegionA(long cid);

}
