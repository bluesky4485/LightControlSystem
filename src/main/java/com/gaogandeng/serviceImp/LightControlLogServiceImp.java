package com.gaogandeng.serviceImp;

import com.gaogandeng.QueryCondition.LightControlQuery;
import com.gaogandeng.dao.LightControlLogMapper;
import com.gaogandeng.model.LightControlLog;
import com.gaogandeng.service.LightControlLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lanxing on 16-3-16.
 */

@Service("lightControlLogService")
public class LightControlLogServiceImp implements LightControlLogService {

    private LightControlLogMapper lightControlLogMapper;

    @Autowired
    public void setLightControlLogMapper(LightControlLogMapper lightControlLogMapper) {
        this.lightControlLogMapper = lightControlLogMapper;
    }

    public void insertLightControl(LightControlLog log) {
        lightControlLogMapper.insertLightControl(log);
    }

    public List<LightControlLog> findLightControlLog(LightControlQuery query) {
        return lightControlLogMapper.findLightControlLog(query);
    }

    public void updateStatus(LightControlLog log) {
        lightControlLogMapper.updateStatus(log);
    }
}
