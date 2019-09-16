package com.cj.core.config.timing.impl;

import com.cj.core.config.timing.DBService;
import com.cj.core.config.timing.Datapram;
import com.cj.core.utils.SqlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBServiceImpl implements DBService {

    @Autowired
    private Datapram datapram;

    @Override
    public void backup() {
        String string = datapram.getTooldir()+" -h "+datapram.getIp()+" -u"+datapram.getUsername()+" -p"+datapram.getPassword()+" ";

        SqlUtil.backup(string,datapram.getDir(),datapram.getDbname());
    }
}
