package com.gaogandeng.dao;

import com.gaogandeng.QueryCondition.LightControlQuery;
import com.gaogandeng.model.LightControlLog;

import java.util.List;

/**
 * Created by lanxing on 16-3-16.
 */
public interface LightControlLogMapper {
    void insertLightControl(LightControlLog log);
    List<LightControlLog> findLightControlLog(LightControlQuery query);
    void updateStatus(LightControlLog log);
}
