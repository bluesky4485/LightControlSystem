package com.gaogandeng.test;

import com.gaogandeng.QueryCondition.ControlLogQuery;
import com.gaogandeng.model.ControlLog;
import com.gaogandeng.model.User;
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
import java.util.Map;

/**
 * Created by lanxing on 16-3-16.
 */
@RunWith(SpringJUnit4ClassRunner.class)   //相当于继承了SpringJUnit4ClassRunner
@ContextConfiguration(locations = {"classpath:spring.xml", "classpath:spring-mybatis.xml"})
public class CmdControlServiceTest {
    private CmdControlService cmdControlService;
    private UserService userService;

    @Autowired
    public void setCmdControlService(CmdControlService cmdControlService) {
        this.cmdControlService = cmdControlService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Test
    public void queryControlLog(){
        ControlLogQuery query = new ControlLogQuery();
        List<ControlLog> logs = cmdControlService.queryControlLog(query);
        for (ControlLog log : logs){
            System.out.println(log);
        }
    }

    @Test
    public void insertControlLogTest(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date startTime = null;
        Date endTime = null;
        try {
            startTime = df.parse("2016-3-20 10:23:23");
            endTime = df.parse("2016-3-20 20:23:23");
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

//        List<Map<Date, String> > lists = cmdControlService.insertControlLog(controlLog);
//        for (Map<Date, String> list : lists){
//            System.out.println(list);
//        }
    }
}
