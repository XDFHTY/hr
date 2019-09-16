package com.cj.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cj.core.domain.Pager;
import com.cj.core.domain.VoLog;
import com.cj.core.entity.OperateLog;

import java.util.List;

public interface LogMapper extends BaseMapper<OperateLog> {

    List<VoLog> findLog(Pager pager);
}
