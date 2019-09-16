package com.cj.hmould.service.impl;

import com.cj.core.domain.Pager;
import com.cj.core.entity.CheckItem;
import com.cj.core.entity.SiteCheckItem;
import com.cj.core.entity.SiteCheckItemMsg;
import com.cj.hbasic.domian.SiteVo;
import com.cj.hbasic.mapper.SitesMapper;
import com.cj.hmould.domain.UpdateSiteModuldVo;
import com.cj.hmould.domain.VoCheckItem;
import com.cj.hmould.domain.VoModuleAndSiteMoule;
import com.cj.hmould.domain.VoNames;
import com.cj.hmould.mapper.CheckItemMapper;
import com.cj.hmould.mapper.ModuldMapper;
import com.cj.hmould.service.ModuldService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ModuldServiceImpl implements ModuldService {

    @Resource
    private ModuldMapper moduldMapper;

    @Resource
    private CheckItemMapper checkItemMapper;

    @Resource
    private SitesMapper sitesMapper;

    @Override
    public Pager findSite(Pager pager) {
        pager.setRecords(sitesMapper.findAll(pager));
        return pager;
    }

    @Override
    public VoModuleAndSiteMoule findModuleAndSiteMoule(long siteId) {
        //查询系统所有节点
        List<VoCheckItem> voCheckItems = moduldMapper.findModule();
        //查询台站拥有的节点id
        List<SiteCheckItem> siteCheckItems = moduldMapper.findsiteCheckItemId(siteId);

        //筛选出台站节点层级信息
        voCheckItems.forEach(voCheckItem1 -> {
            voCheckItem1.setSelect(siteCheckItems.stream().anyMatch(siteCheckItem -> siteCheckItem.getCheckItemId() == voCheckItem1.getCheckItemId()));
            voCheckItem1.getChild().forEach(
                    voCheckItem2 -> {
                        voCheckItem2.setSelect(siteCheckItems.stream().anyMatch(siteCheckItem -> siteCheckItem.getCheckItemId() == voCheckItem2.getCheckItemId()));
                        voCheckItem2.getChild().forEach(
                                voCheckItem3 -> {
                                    voCheckItem3.setSelect(siteCheckItems.stream().anyMatch(siteCheckItem -> siteCheckItem.getCheckItemId() == voCheckItem3.getCheckItemId()));
                                    voCheckItem3.getChild().forEach(
                                            voCheckItem4 -> {
                                                voCheckItem4.setSelect(siteCheckItems.stream().anyMatch(siteCheckItem -> siteCheckItem.getCheckItemId() == voCheckItem4.getCheckItemId()));
                                            });
                                });
                    });
        });

        VoModuleAndSiteMoule voModuleAndSiteMoule = new VoModuleAndSiteMoule();
        voModuleAndSiteMoule.setVoCheckItems(voCheckItems);

        return voModuleAndSiteMoule;
    }

    @Override
    public int UpdateSiteModuld(UpdateSiteModuldVo updateSiteModuldVo) {
        int i = moduldMapper.UpdateSiteModuld(updateSiteModuldVo);

        return i == 0 ? 1 : i;
    }

    @Override
    public int addChild(CheckItem checkItem) {
        return checkItemMapper.insert(checkItem);
    }

    @Override
    public int delChild(long checkItemId) {
        return checkItemMapper.deleteById(checkItemId);
    }

    @Override
    public int upChild(CheckItem checkItem) {
        return checkItemMapper.updateById(checkItem);
    }

    @Override
    public List<VoCheckItem> findModuldBySiteId(long siteId, String roleName) {
        //查询系统所有节点
        List<VoCheckItem> voCheckItems = moduldMapper.findModule();
        //查询台站拥有的节点
        List<SiteCheckItem> siteCheckItems = moduldMapper.findsiteCheckItemId(siteId);


        List<VoCheckItem> voCheckItems1 =
                voCheckItems
                        .stream()
                        .filter(voCheckItem ->
                                siteCheckItems
                                        .stream()
                                        .anyMatch(
                                                siteCheckItem -> {
                                                    switch (roleName) {
                                                        case "代维1级":
                                                            if (siteCheckItem.getCheckItemId() == voCheckItem.getCheckItemId()
                                                                    && (voCheckItem.getCheckItemId() == 1 | voCheckItem.getCheckItemId() == 2)) {
                                                                return true;
                                                            }
                                                            return false;
                                                        case "代维2级":
                                                            if (siteCheckItem.getCheckItemId() == voCheckItem.getCheckItemId()
                                                                    && voCheckItem.getCheckItemId() == 1) {
                                                                return true;
                                                            }
                                                            return false;
                                                        default:
                                                            if (siteCheckItem.getCheckItemId() == voCheckItem.getCheckItemId()) {
                                                                return true;
                                                            }
                                                            return false;
                                                    }

                                                }
                                        )
                        )
                        .collect(Collectors.toList());

        return voCheckItems1;
    }

    @Override
    public int addSiteCheckItemMsg(List<SiteCheckItemMsg> siteCheckItemMsgs) {

        return moduldMapper.addSiteCheckItemMsg(siteCheckItemMsgs);
    }

    @Override
    public VoNames findSiteCheckItemMsgByPatrolTaskStationId(long patrolTaskStationId) {
        return moduldMapper.findVoNamesByPatrolTaskStationId(patrolTaskStationId);
    }
}
