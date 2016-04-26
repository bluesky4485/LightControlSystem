package com.gaogandeng.dao;

import com.gaogandeng.QueryCondition.WarningLogQuery;
import com.gaogandeng.model.WarningLog;

import java.util.List;

/**
 * Created by lanxing on 16-3-16.
 */
public interface WarningLogMapper {
    void insertWarningLog(WarningLog log);
    List<WarningLog> findAllWarningLogs();
    List<WarningLog> findWarningLogs(WarningLogQuery query);
    void confirmWarning(Integer id);
}
