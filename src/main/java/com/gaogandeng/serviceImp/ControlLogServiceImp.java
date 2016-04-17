package com.gaogandeng.serviceImp;

import com.gaogandeng.QueryCondition.ControlLogQuery;
import com.gaogandeng.dao.ControlLogMapper;
import com.gaogandeng.dao.LightMapper;
import com.gaogandeng.model.ControlLog;
import com.gaogandeng.model.Light;
import com.gaogandeng.service.ControlLogService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lanxing on 16-3-16.
 */

@Service("controlLogService")
public class ControlLogServiceImp implements ControlLogService {

    private ControlLogMapper controlLogMapper;

    @Autowired
    public void setControlLogMapper(ControlLogMapper controlLogMapper) {
        this.controlLogMapper = controlLogMapper;
    }

    public void insertControlLog(ControlLog controlLog) {

        controlLogMapper.insertControlLog(controlLog);
    }

    public List<ControlLog> findControlLogByTime(ControlLogQuery query) {
        return controlLogMapper.findControlLogByTime(query);
    }
}
