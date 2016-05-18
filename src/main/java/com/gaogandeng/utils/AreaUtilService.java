package com.gaogandeng.utils;

import com.gaogandeng.model.Area;
import com.gaogandeng.service.AreaService;
import com.gaogandeng.service.LightService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * Created by biny on 16-5-18.
 */
public class AreaUtilService {
    private AreaService areaService;
    private LightService lightService;

    @Autowired
    public void setAreaService(AreaService areaService) {
        this.areaService = areaService;
    }

    @Autowired
    public void setLightService(LightService lightService) {
        this.lightService = lightService;
    }

    public List<Area> queryAllAreas(){
        List<Area> areaList = areaService.findAllAreas();
        for(Area area : areaList){
            String lightsId = area.getLightsId();
            String[] list = lightsId.split(";");
            for(int i=0;i<list.length;i++){
              lightService.findLightById(Integer.);
            }

        }

        return areaList;
    }
}
