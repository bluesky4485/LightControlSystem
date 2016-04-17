package com.gaogandeng.service;

import com.gaogandeng.QueryCondition.LightStatusQuery;
import com.gaogandeng.model.LightStatusLog;

import java.util.List;

/**
 * Created by lanxing on 16-3-16.
 * 查询灯具状态信息
 */
public interface LightStatusLogService {

    /**
     * 插入灯具状态i信息，仅用于测试
     * @param lightStatusLog
     */
    void insertLightStatus(LightStatusLog lightStatusLog);

    /**
     * 根据查询条件查询灯具状态信息
     * @param query
     * @return
     */
    List<LightStatusLog> findLightStatus(LightStatusQuery query);

    /**
     * 查找最新的状态信息
     * @param lightId
     * @return
     */
    LightStatusLog findLatestStatus(Integer lightId);
}
