package com.gaogandeng.utils;

import com.gaogandeng.model.Area;
import com.gaogandeng.model.Light;
import com.gaogandeng.service.AreaService;
import com.gaogandeng.service.LightService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by biny on 16-5-18.
 */
@Service("areaUtilService")
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
            List<Light> lightList = Lists.newArrayList();
            String[] list=null;
            if(lightsId.length()>0){
                list = lightsId.split(";");
            }
            if(list!=null){
                for(int i=0;i<list.length;i++){
                    Light light = lightService.findLightById(Integer.parseInt(list[i]));
                    if(light!= null){
                        lightList.add(light);
                    }
                    area.setLights(lightList);
                }
            }
        }

        return areaList;
    }

    public void addarea(Area area){
        areaService.insertArea(area);
    }

    public void deleteareaById(Integer id){
        areaService.deleteAreaById(id);
    }

    public Area findareaById(Integer id){
        return areaService.findAreaById(id);
    }

    public void updateAreaLight(Area area){
        areaService.updateAreaLight(area);
    }
}
