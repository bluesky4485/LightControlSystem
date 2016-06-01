package com.gaogandeng.controller;

import com.gaogandeng.model.Area;
import com.gaogandeng.utils.AreaUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by biny on 16-5-19.
 */
@Controller
@RequestMapping(value="/area/")
public class AreaControl {
    private AreaUtilService areaUtilService;

    @Autowired
    public void setAreaUtilService(AreaUtilService areaUtilService) {
        this.areaUtilService = areaUtilService;
    }

    @RequestMapping(value="/queryareas")
    public @ResponseBody
    List<Area> getAllAreas(){
        List<Area> areas=areaUtilService.queryAllAreas();
        return areas;
    }

    @RequestMapping(value="/delete")
    public @ResponseBody
    void deleteArea(HttpServletRequest request){
        String areaId = request.getParameter("areaId");
        areaUtilService.deleteareaById(Integer.parseInt(areaId));
    }

    @RequestMapping(value="/deleteid")
    public @ResponseBody
    void deleteAreaLight(HttpServletRequest request){
        String areaId = request.getParameter("areaId");
        String id_only = request.getParameter("id_only");

        Area area = areaUtilService.findareaById(Integer.parseInt(areaId));
        String lightsId = area.getLightsId();
        String newLightsId = lightsId.replace(id_only+";","");
        area.setLightsId(newLightsId);
        areaUtilService.updateAreaLight(area);
    }

    @RequestMapping(value="/addarea")
    public String addArea(HttpServletRequest request, Model model){
        String areaId = request.getParameter("areaid");
        String areaName = request.getParameter("areaname");
        String lightsId = request.getParameter("lights");
        Integer areasIdInt;
        if(!areaId.equals("")&&!areaName.equals("")&&!lightsId.equals("")){
            areasIdInt = Integer.parseInt(areaId);
            Area newarea = new Area();
            newarea.setAreaId(areasIdInt);
            newarea.setAreaName(areaName);
            newarea.setLightsId(lightsId);
            List<Area> areas=areaUtilService.queryAllAreas();
            Boolean have = false;
            if(areas != null){
                for(Area area : areas){
                    if(area.getAreaId().equals(areasIdInt)){
                        have = true;
                        break;
                    }
                }
            }

            if(have==true){
                model.addAttribute("error","区域编号已存在");
                return "addarea";
            }else{
                areaUtilService.addarea(newarea);
                return "displayarea";
            }
        }else{
            model.addAttribute("error2","请全部输入");
            return "addarea";
        }

    }
}
