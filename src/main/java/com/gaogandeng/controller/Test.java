package com.gaogandeng.controller;

import com.gaogandeng.model.Light;
import com.gaogandeng.service.LightService;
import com.gaogandeng.utils.LightStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by lanxing on 16-3-17.
 */

@Controller
@RequestMapping(value = "/test/")
public class Test {
    private LightService lightService;
    private LightStatusService lightStatusService;

    @Autowired
    public void setLightStatusService(LightStatusService lightStatusService) {
        this.lightStatusService = lightStatusService;
    }

    @Autowired
    public void setLightService(LightService lightService) {
        this.lightService = lightService;
    }

    @RequestMapping(value = "/test")
    public @ResponseBody
    Light getLight(HttpServletRequest request){
        Light light = lightService.findLightById(1);
        return light;
    }

    @RequestMapping(value = "/getAllLights")
    public @ResponseBody
    Map<String, Map<String, List<Light> >> getLights(){
        return lightStatusService.queryAllLights();
    }
}
