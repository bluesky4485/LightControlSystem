package com.gaogandeng.controller;

import com.gaogandeng.QueryCondition.WarningLogQuery;
import com.gaogandeng.model.WarningLog;
import com.gaogandeng.utils.WarningInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by lanxing on 16-3-17.
 */
@Controller
@RequestMapping(value = "/warning/")
public class WarningControl {
    //TODO 对报警信息进行控制
    private WarningInfoService warningInfoService;

    @Autowired
    public void setWarningInfoService(WarningInfoService warningInfoService) {
        this.warningInfoService = warningInfoService;
    }

    @RequestMapping(value = "/all")
    public @ResponseBody
    List<WarningLog> getAllWarningLogs(){
        WarningLogQuery query = new WarningLogQuery();
        return warningInfoService.queryWarningInfo(query);
    }

    @RequestMapping(value = "/confirm")
    public @ResponseBody
    void confirmWarningAction(HttpServletRequest request){
        String val = request.getParameter("id_only");
        warningInfoService.confirmWarningInfo(Integer.valueOf(val));
    }





}
