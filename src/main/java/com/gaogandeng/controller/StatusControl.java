package com.gaogandeng.controller;

import com.gaogandeng.model.LightStatusLog;
import com.gaogandeng.utils.LightStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by lanxing on 16-3-17.  (by gch 16-3-27)
 */
@Controller
@RequestMapping(value = "/lightstatus/")
public class StatusControl {
    //TODO 对状态信息进行差uxn控制
    private LightStatusService lightStatusService;

    @Autowired
    public void setLightStatusService(LightStatusService lightStatusService){
        this.lightStatusService=lightStatusService;
    }

    @RequestMapping(value = "/all")
    public @ResponseBody
    List<LightStatusLog> getAllLightStatusLogs(HttpServletRequest request, HttpServletResponse response){

        return lightStatusService.queryLatestStatus();
    }

}
