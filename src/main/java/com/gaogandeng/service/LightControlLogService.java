package com.gaogandeng.service;

import com.gaogandeng.QueryCondition.LightControlQuery;
import com.gaogandeng.model.LightControlLog;
import com.gaogandeng.utils.CmdControlService;

import java.util.List;

/**
 * Created by lanxing on 16-3-16.
 * LightControlLog中存放的是粒度为单个灯的任务信息，其是由{@link com.gaogandeng.model.ControlLog}细分出来的
 */
public interface LightControlLogService {

    /**
     * 插入一条任务信息，不要用该函数进行插入操作，因为再插入之前需要对任务任务信息进行去重处理，可以利用{@link CmdControlService}
     * 中提供的静态函数进行操作
     * @param log
     */
    void insertLightControl(LightControlLog log);

    /**
     * 根据条件查询任务信息
     * @param query
     * @return
     */
    List<LightControlLog> findLightControlLog(LightControlQuery query);

    /**
     * 更新任务状态，其中状态信息由{@link com.gaogandeng.Enum.CmdStatus}定义
     * @param log
     */
    void updateStatus(LightControlLog log);
}
