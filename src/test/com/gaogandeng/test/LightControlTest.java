package com.gaogandeng.test;

import com.gaogandeng.QueryCondition.LightControlQuery;
import com.gaogandeng.model.Light;
import com.gaogandeng.model.LightControlLog;
import com.gaogandeng.service.LightControlLogService;
import com.gaogandeng.service.LightService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by lanxing on 16-3-16.
 */

@RunWith(SpringJUnit4ClassRunner.class)   //相当于继承了SpringJUnit4ClassRunner
@ContextConfiguration(locations = {"classpath:spring.xml", "classpath:spring-mybatis.xml"})
public class LightControlTest {
    private LightControlLogService lightControlLogService;
    private LightService lightService;

    @Autowired
    public void setLightService(LightService lightService) {
        this.lightService = lightService;
    }

    @Autowired
    public void setLightControlLogService(LightControlLogService lightControlLogService) {
        this.lightControlLogService = lightControlLogService;
    }

    @Test
    public void insertTest(){
        LightControlLog log = new LightControlLog();
        SimpleDateFormat df = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
        Date cmdTime = null;
        try {
            cmdTime = df.parse("2016-3-19 22:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Light light = lightService.findLightById(2);
        log.setLight(light);
        log.setBright(40);
        log.setCmd(1);
        log.setCmdTime(cmdTime);
        lightControlLogService.insertLightControl(log);
    }

    @Test
    public void findTest(){
        LightControlQuery query = new LightControlQuery();
        List<LightControlLog> logs = lightControlLogService.findLightControlLog(query);
        for (LightControlLog log : logs){
            System.out.println(log);
        }
    }

    @Test
    public void updateStatus(){
        LightControlQuery query = new LightControlQuery();
        List<LightControlLog> logs = lightControlLogService.findLightControlLog(query);
        for (LightControlLog log : logs){
            log.setStatus(2);
            lightControlLogService.updateStatus(log);
        }
    }
}
