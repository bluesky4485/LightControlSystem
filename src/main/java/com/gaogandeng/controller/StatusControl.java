package com.gaogandeng.controller;

import com.gaogandeng.QueryCondition.LightStatusQuery;
import com.gaogandeng.model.LightStatusLog;
import com.gaogandeng.utils.LightStatusService;
import com.gaogandeng.utils.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by lanxing on 16-3-17.  (by gch 16-3-27)
 */
@Controller
@RequestMapping(value = "/lightstatus/")
public class StatusControl {
    //TODO 对状态信息进行差uxn控制
    private LightStatusService lightStatusService;
    private TimeService timeService;

    @Autowired
    public void setTimeService(TimeService timeService) {
        this.timeService = timeService;
    }

    @Autowired
    public void setLightStatusService(LightStatusService lightStatusService){
        this.lightStatusService=lightStatusService;
    }

    @RequestMapping(value = "/pow")
    public @ResponseBody
    ArrayList<Double> getAllLightPowSum(){
        LightStatusQuery lightStatusQuery = new LightStatusQuery();

        ArrayList<Double> doubleList = new ArrayList<Double>();

        lightStatusQuery.setStartTime(timeService.getTimesLastMonthmorning());
        lightStatusQuery.setEndTime(timeService.getTimesMonthmorning());
        Double lastMonthPowSum = lightStatusService.findLightStatusPowSum(lightStatusQuery);
        doubleList.add(lastMonthPowSum);

        lightStatusQuery.setStartTime(timeService.getTimesMonthmorning());
        lightStatusQuery.setEndTime(timeService.getTimesMonthnight());
        Double monthPowSum = lightStatusService.findLightStatusPowSum(lightStatusQuery);
        doubleList.add(monthPowSum);

        lightStatusQuery.setStartTime(timeService.getTimesLastYearMonthmorning());
        lightStatusQuery.setEndTime(timeService.getTimesLastYearMonthnight());
        Double lastYearMonthPowSum = lightStatusService.findLightStatusPowSum(lightStatusQuery);
        doubleList.add(lastYearMonthPowSum);

        return doubleList;
    }

    @RequestMapping(value = "/all")
    public @ResponseBody
    List<LightStatusLog> getAllLatestStatus(){
        return lightStatusService.queryLatestStatus();
    }
}
