package com.gaogandeng.service;

import com.gaogandeng.model.DeviceStatusLog;

import java.util.List;

/**
 * Created by gch on 16-5-29.
 */
public interface DeviceStatusLogService {
    List<DeviceStatusLog> findAllDeviceStatusLogs();
}
