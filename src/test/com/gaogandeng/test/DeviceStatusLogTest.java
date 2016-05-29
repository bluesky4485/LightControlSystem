package com.gaogandeng.test;

import com.gaogandeng.model.DeviceStatusLog;
import com.gaogandeng.service.DeviceStatusLogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by gch on 16-5-29.
 */
@RunWith(SpringJUnit4ClassRunner.class)   //相当于继承了SpringJUnit4ClassRunner
@ContextConfiguration(locations = {"classpath:spring.xml", "classpath:spring-mybatis.xml"})
public class DeviceStatusLogTest {
    private DeviceStatusLogService deviceStatusLogService;

    @Autowired
    public void setDeviceStatusLogService(DeviceStatusLogService deviceStatusLogService) {
        this.deviceStatusLogService = deviceStatusLogService;
    }

    @Test
    public void findAllDeviceStatusLogs(){
        List<DeviceStatusLog> list = deviceStatusLogService.findAllDeviceStatusLogs();
        for(DeviceStatusLog deviceStatusLog:list){
            System.out.println(deviceStatusLog.getDeviceId()+" "+
            " 经度："+deviceStatusLog.getLongitude()+" "+deviceStatusLog.getEastOrWest()+
            " 纬度："+deviceStatusLog.getLatitude()+" "+deviceStatusLog.getNorthOrSouth());
        }
    }


}
