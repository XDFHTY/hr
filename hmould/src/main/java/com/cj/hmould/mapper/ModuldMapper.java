package com.cj.hmould.mapper;

import com.cj.core.entity.SiteCheckItem;
import com.cj.core.entity.SiteCheckItemMsg;
import com.cj.hmould.domain.UpdateSiteModuldVo;
import com.cj.hmould.domain.VoCheckItem;
import com.cj.hmould.domain.VoNames;

import java.util.List;

public interface ModuldMapper {


    List<VoCheckItem> findModule();


    List<SiteCheckItem> findsiteCheckItemId(long siteId);

    int UpdateSiteModuld(UpdateSiteModuldVo updateSiteModuldVo);


    int addSiteCheckItemMsg(List<SiteCheckItemMsg> siteCheckItemMsgs);

    List<SiteCheckItemMsg> findSiteCheckItemMsgByPatrolTaskStationId(long patrolTaskStationId);

    VoNames findVoNamesByPatrolTaskStationId(long patrolTaskStationId);
}
