package com.gaogandeng.test;

import com.gaogandeng.QueryCondition.LightStatusQuery;
import com.gaogandeng.model.Light;
import com.gaogandeng.model.LightStatusLog;
import com.gaogandeng.service.LightService;
import com.gaogandeng.service.LightStatusLogService;
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
public class LightStatusTest {
    private LightStatusLogService lightStatusLogService;
    private LightService lightService;

    @Autowired
    public void setLightService(LightService lightService) {
        this.lightService = lightService;
    }

    @Autowired
    public void setLightStatusLogService(LightStatusLogService lightStatusLogService) {
        this.lightStatusLogService = lightStatusLogService;
    }

    @Test
    public void insertTest(){
        LightStatusLog log = new LightStatusLog();
        Light light = lightService.findLightById(1);
        log.setLight(light);
        log.setBright(33);
        log.setCur(22.33);
        log.setEnviBright(44);
        log.setPow(44.33);
        log.setTemperature(23.5);
        log.setVol(33.5);

        lightStatusLogService.insertLightStatus(log);
    }

    @Test
    public void findTest(){
        LightStatusQuery query = new LightStatusQuery();
        List<LightStatusLog> logs = lightStatusLogService.findLightStatus(query);
        for (LightStatusLog log : logs){
            System.out.println(log);
        }
    }

    @Test
    public void latestTest(){
        LightStatusLog light = lightStatusLogService.findLatestStatus(1);
        System.out.println(light);
    }
}
