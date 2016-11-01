package com.gaogandeng.serviceImp;

import com.gaogandeng.dao.DeviceStatusLogMapper;
import com.gaogandeng.model.DeviceStatusLog;
import com.gaogandeng.service.DeviceStatusLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gch on 16-5-29.
 */
@Service("deviceStatusLogService")
public class DeviceStatusLogServiceImp implements DeviceStatusLogService {
    DeviceStatusLogMapper deviceStatusLogMapper;

    @Autowired
    public void setDeviceStatusLogMapper(DeviceStatusLogMapper deviceStatusLogMapper) {
        this.deviceStatusLogMapper = deviceStatusLogMapper;
    }

    public List<DeviceStatusLog> findAllDeviceStatusLogs() {
        return deviceStatusLogMapper.findAllDeviceStatusLogs();
    }
}
