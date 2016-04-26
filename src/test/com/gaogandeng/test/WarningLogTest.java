package com.gaogandeng.test;

import com.gaogandeng.QueryCondition.WarningLogQuery;
import com.gaogandeng.model.Light;
import com.gaogandeng.model.WarningLog;
import com.gaogandeng.service.LightService;
import com.gaogandeng.service.WarningLogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by lanxing on 16-3-16.
 */

@RunWith(SpringJUnit4ClassRunner.class)   //相当于继承了SpringJUnit4ClassRunner
@ContextConfiguration(locations = {"classpath:spring.xml", "classpath:spring-mybatis.xml"})
public class WarningLogTest {
    private WarningLogService warningLogService;
    private LightService lightService;

    @Autowired
    public void setLightService(LightService lightService) {
        this.lightService = lightService;
    }

    @Autowired
    public void setWarningLogService(WarningLogService warningLogService) {
        this.warningLogService = warningLogService;
    }

    @Test
    public void insertTest(){
        for (int i = 0; i != 20; ++i){
            WarningLog log = new WarningLog();
            log.setInfo("电流过大");
            Light light = lightService.findLightById(2);
            log.setLight(light);
            warningLogService.insertWarningLog(log);
        }
    }

    @Test
    public void findAllTest(){
        List<WarningLog> logs = warningLogService.findAllWarningLogs();
        for (WarningLog log : logs){
            System.out.println(log);
        }
    }

    @Test
    public void findWarning(){
        WarningLogQuery query = new WarningLogQuery();
        query.setStatus(1);
        List<WarningLog> logs = warningLogService.findWarningLogs(query);
        for (WarningLog log : logs){
            System.out.println(log);
        }
    }

    @Test
    public void confirmWarning(){
        for (int i = 0; i < 20; i += 2){
            warningLogService.confirmWarning(i);
        }
    }
}
