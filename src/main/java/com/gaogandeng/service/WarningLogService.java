package com.gaogandeng.service;

import com.gaogandeng.QueryCondition.WarningLogQuery;
import com.gaogandeng.model.WarningLog;

import java.util.List;

/**
 * Created by lanxing on 16-3-16.
 * 报警信息服务
 */
public interface WarningLogService {
    /**
     * 插入报警信息，仅用于测试
     * @param log
     */
    void insertWarningLog(WarningLog log);

    /**
     * 查询所有的报警信息
     * @return
     */
    List<WarningLog> findAllWarningLogs();

    /**
     * 根据条件查询报警信息
     * @param query
     * @return
     */
    List<WarningLog> findWarningLogs(WarningLogQuery query);

    /**
     * 确认报警信息，将报警信息状态置为1
     * @param id
     */
    void confirmWarning(Integer id);
}
