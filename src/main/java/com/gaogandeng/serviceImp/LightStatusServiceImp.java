package com.gaogandeng.serviceImp;

import com.gaogandeng.QueryCondition.LightStatusQuery;
import com.gaogandeng.dao.LightStatusLogMapper;
import com.gaogandeng.model.LightStatusLog;
import com.gaogandeng.service.LightStatusLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lanxing on 16-3-16.
 */
@Service("lightStatusLogService")
public class LightStatusServiceImp implements LightStatusLogService {

    private LightStatusLogMapper lightStatusLogMapper;

    @Autowired
    public void setLightStatusLogMapper(LightStatusLogMapper lightStatusLogMapper) {
        this.lightStatusLogMapper = lightStatusLogMapper;
    }

    public void insertLightStatus(LightStatusLog lightStatusLog) {
        lightStatusLogMapper.insertLightStatus(lightStatusLog);
    }

    public List<LightStatusLog> findLightStatus(LightStatusQuery query) {
        return lightStatusLogMapper.findLightStatus(query);
    }

    public LightStatusLog findLatestStatus(Integer lightId) {
        return lightStatusLogMapper.findLatestStatus(lightId);
    }
}
