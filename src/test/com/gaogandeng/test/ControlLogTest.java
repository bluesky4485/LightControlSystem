package com.gaogandeng.test;

import com.gaogandeng.QueryCondition.ControlLogQuery;
import com.gaogandeng.model.ControlLog;
import com.gaogandeng.model.User;
import com.gaogandeng.service.ControlLogService;
import com.gaogandeng.service.UserService;
import com.gaogandeng.utils.CmdControlService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by lanxing on 16-3-16.
 */

@RunWith(SpringJUnit4ClassRunner.class)   //相当于继承了SpringJUnit4ClassRunner
@ContextConfiguration(locations = {"classpath:spring.xml", "classpath:spring-mybatis.xml"})
public class ControlLogTest {
    //TODO增加所需要的依赖，测试各个函数
    private ControlLogService controlLogService;
    private UserService userService;
    private CmdControlService cmdControlService;

    @Autowired
    public void setCmdControlService(CmdControlService cmdControlService) {
        this.cmdControlService = cmdControlService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setControlLogService(ControlLogService controlLogService) {
        this.controlLogService = controlLogService;
    }

    @Test
    public void insertTest(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date startTime = null;
        Date endTime = null;
        try {
            startTime = df.parse("2016-3-16 13:23:23");
            endTime = df.parse("2016-3-16 15:23:23");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        User user = userService.findUserByName("张三");
        ControlLog controlLog = new ControlLog();
        controlLog.setOpenTime(startTime);
        controlLog.setCloseTime(endTime);
        controlLog.setUser(user);
        controlLog.setLightIds(new String("1;2"));
        controlLog.setCmd(1);
        controlLogService.insertControlLog(controlLog);

        System.out.print(controlLog);
    }

    @Test
    public void findLog(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date startTime = null;
        Date endTime = null;
        try {
            startTime = df.parse("2016-3-16 12:23:23");
            endTime = df.parse("2016-3-16 15:23:23");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        ControlLogQuery query = new ControlLogQuery();
        query.setStartTime(startTime);
        List<ControlLog> logs = controlLogService.findControlLogByTime(query);
        for (ControlLog log : logs){
            System.out.println(log);
        }
    }

    @Test
    public void testCheckSum(){
        System.out.println(cmdControlService.checkSum("11"));
    }
}
