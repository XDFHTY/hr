package com.cj.core.service;

import com.cj.core.domain.Pager;
import com.cj.core.domain.VoLog;
import com.cj.core.entity.OperateLog;

public interface LogService {

    int addLog(OperateLog operateLog);

    Pager findLog(Pager<VoLog> pager);
}
