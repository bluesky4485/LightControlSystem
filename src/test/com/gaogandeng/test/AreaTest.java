package com.gaogandeng.test;

import com.gaogandeng.model.Area;
import com.gaogandeng.service.AreaService;
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

    @Autowired
    public void setAreaService(AreaService areaService) {
        this.areaService = areaService;
    }

    @Test
    public void insertArea(){
        Area area = new Area(2,"fff","23;34");
        areaService.insertArea(area);
    }

    @Test
    public void findAllAreas(){
        List<Area> areaList = areaService.findAllAreas();
        for(Area area : areaList){
            System.out.println(area.getAreaId()+" "+area.getAreaName()+" "+area.getLightsId());

        }
    }
}
