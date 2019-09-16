package com.cj.hmould.service;

import com.cj.core.domain.Pager;
import com.cj.core.entity.CheckItem;
import com.cj.core.entity.SiteCheckItem;
import com.cj.core.entity.SiteCheckItemMsg;
import com.cj.hbasic.domian.SiteVo;
import com.cj.hmould.domain.UpdateSiteModuldVo;
import com.cj.hmould.domain.VoCheckItem;
import com.cj.hmould.domain.VoModuleAndSiteMoule;
import com.cj.hmould.domain.VoNames;

import java.util.List;

public interface ModuldService {


    Pager findSite(Pager pager);

    VoModuleAndSiteMoule findModuleAndSiteMoule(long siteId);


    int UpdateSiteModuld(UpdateSiteModuldVo updateSiteModuldVo);

    int addChild(CheckItem checkItem);

    int delChild(long checkItemId);

    int upChild(CheckItem checkItem);

    //查询台站模板信息
    List<VoCheckItem> findModuldBySiteId(long siteId,String roleName);

    //填写台站模板信息
    int addSiteCheckItemMsg(List<SiteCheckItemMsg> siteCheckItemMsgs);

    //查询台站已填写的任务信息
    VoNames findSiteCheckItemMsgByPatrolTaskStationId(long patrolTaskStationId);
}
