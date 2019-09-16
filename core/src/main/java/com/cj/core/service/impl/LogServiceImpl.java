package com.cj.core.service.impl;

import com.cj.core.domain.Pager;
import com.cj.core.domain.VoLog;
import com.cj.core.entity.OperateLog;
import com.cj.core.mapper.LogMapper;
import com.cj.core.service.LogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Resource
    private LogMapper logmapper;


    @Override
    public int addLog(OperateLog operateLog) {
        operateLog.setLogState("1");
        return logmapper.insert(operateLog);
    }

    @Override
    public Pager findLog(Pager<VoLog> pager) {
        pager.setRecords(logmapper.findLog(pager));
        return pager;
    }
}
