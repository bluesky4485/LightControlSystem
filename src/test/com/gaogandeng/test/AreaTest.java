package com.gaogandeng.test;

import com.gaogandeng.model.Area;
import com.gaogandeng.model.Light;
import com.gaogandeng.service.AreaService;
import com.gaogandeng.utils.AreaUtilService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by biny on 16-5-18.
 */
@RunWith(SpringJUnit4ClassRunner.class)   //相当于继承了SpringJUnit4ClassRunner
@ContextConfiguration(locations = {"classpath:spring.xml", "classpath:spring-mybatis.xml"})
public class AreaTest {
    private AreaService areaService;
    private AreaUtilService areaUtilService;

    @Autowired
    public void setAreaUtilService(AreaUtilService areaUtilService) {
        this.areaUtilService = areaUtilService;
    }

    @Autowired
    public void setAreaService(AreaService areaService) {
        this.areaService = areaService;
    }

    @Test
    public void insertArea(){
        Area area = new Area(2,"ff","78;76");
        areaService.insertArea(area);
    }

    @Test
    public void findAllAreas(){
        List<Area> areaList = areaUtilService.queryAllAreas();
        for(Area area:areaList){
            System.out.print(area.getAreaId()+" ");
            System.out.print(area.getAreaName()+" ");
            System.out.println(area.getLightsId()+" ");
            List<Light> lightList = area.getLights();
            for(Light light : lightList){
                System.out.println(light.getDeviceId()+" "+light.getGroupId()+" "+light.getInGroupId());
            }
        }

    }

    @Test
    public void deleteAreaById(){
        areaService.deleteAreaById(1);
    }

}
