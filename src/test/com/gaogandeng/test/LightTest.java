package com.gaogandeng.test;

import com.gaogandeng.model.Light;
import com.gaogandeng.service.LightService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by lanxing on 16-3-15.
 */

@RunWith(SpringJUnit4ClassRunner.class)   //相当于继承了SpringJUnit4ClassRunner
@ContextConfiguration(locations = {"classpath:spring.xml", "classpath:spring-mybatis.xml"})
public class LightTest {
    private LightService lightService;

    public LightService getLightService() {
        return lightService;
    }

    @Autowired
    public void setLightService(LightService lightService) {
        this.lightService = lightService;
    }

    @Test
    public void findAllTest(){
        List<Light> lights = lightService.findAllLights();
        for (Light light : lights){
            System.out.println(light);
        }
    }

    @Test
    public void insertTest(){
        Light light = new Light();
        light.setDeviceId("1000");
        light.setGroupId("2000");
        light.setInGroupId("2");
        lightService.insertLight(light);
        System.out.println(light);
    }

    @Test
    public void findLightTest(){
        Light light = new Light();
        light.setDeviceId("1000");

        List<Light> lights = lightService.findLight(light);
        for(Light lig : lights){
            System.out.println(lig);
        }
    }

    @Test
    public void findLightById(){
        Light light = lightService.findLightById(1);
        System.out.println(light);

    }

    @Test
    public void testSplit(){
        String str = "1;2;3;";
        String [] strs = str.split(";");
        for(String ss : strs){
            System.out.println(ss + " ");
        }
    }
}
