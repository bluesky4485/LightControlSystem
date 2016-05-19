package com.gaogandeng.controller;

import com.gaogandeng.model.Area;
import com.gaogandeng.utils.AreaUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by biny on 16-5-19.
 */
@Controller
public class AreaControl {
    private AreaUtilService areaUtilService;

    @Autowired
    public void setAreaUtilService(AreaUtilService areaUtilService) {
        this.areaUtilService = areaUtilService;
    }

    @RequestMapping(value="/area/queryareas")
    public @ResponseBody
    List<Area> getAllAreas(){
        List<Area> areas=areaUtilService.queryAllAreas();
        return areas;
    }

    @RequestMapping(value="/area/delete")
    public @ResponseBody
    void deletearea(HttpServletRequest request){
        String areaId = request.getParameter("areaId");
        areaUtilService.deleteareaById(Integer.parseInt(areaId));
    }

    @RequestMapping(value="/area/deleteid")
    public @ResponseBody
    void deletearealight(HttpServletRequest request){
        String areaId = request.getParameter("areaId");
        String id_only = request.getParameter("id_only");

        Area area = areaUtilService.findareaById(Integer.parseInt(areaId));
        String lightsId = area.getLightsId();
        String newLightsId = lightsId.replace(id_only+";","");
        area.setLightsId(newLightsId);
        areaUtilService.updateAreaLight(area);
    }

    @RequestMapping(value="/jsp/addarea")
    public String addarea(HttpServletRequest request){
        String areaId = request.getParameter("areaid");
        String areaName = request.getParameter("areaname");
        String lightsId = request.getParameter("lights");
        Area area = new Area();
        area.setAreaId(Integer.parseInt(areaId));
        area.setAreaName(areaName);
        area.setLightsId(lightsId);
        areaUtilService.addarea(area);
        return "displayarea";
    }
}
