package com.gaogandeng.service;

import com.gaogandeng.QueryCondition.ControlLogQuery;
import com.gaogandeng.model.ControlLog;

import java.util.List;

/**
 * Created by lanxing on 16-3-16.
 */
public interface ControlLogService {
    /**
     * 插入控制任务信息
     * @param controlLog
     */
    void insertControlLog(ControlLog controlLog);

    /**
     * 根据查询条件查询任务信息
     * @param query
     * @return
     */
    List<ControlLog> findControlLogByTime(ControlLogQuery query);
}
