package com.gaogandeng.controller;

import com.gaogandeng.QueryCondition.ControlLogQuery;
import com.gaogandeng.model.ControlLog;
import com.gaogandeng.model.Light;
import com.gaogandeng.model.User;
import com.gaogandeng.service.ControlLogService;
import com.gaogandeng.service.LightService;
import com.gaogandeng.utils.AuthenticationService;
import com.gaogandeng.utils.CmdControlService;
import com.gaogandeng.utils.RedisService;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by lanxing on 16-3-17.
 */
@Controller
@RequestMapping(value = "/control/")
public class LightControl {
    //TODO 对集中控制器进行的控制操作，只需要将相应的控制函数写到本类中并赋予url就行
    private CmdControlService cmdControlService;
    private LightService lightService;
    private AuthenticationService authenticationService;
    private RedisService redisService;

    @Autowired
    public void setRedisService(RedisService redisService) {
        this.redisService = redisService;
    }

    @Autowired
    public void setAuthenticationService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Autowired
    public void setLightServiceImp(LightService lightService) {
        this.lightService = lightService;
    }

    @Autowired

    public void setCmdControlService(CmdControlService cmdControlService){
        this.cmdControlService=cmdControlService;
    }

    @RequestMapping(value="/querylights")
    public @ResponseBody
    List<Light> getAllLights(){
        List<Light> lights=lightService.findAllLights();
        return lights;
    }

    @RequestMapping(value="/query")
    public @ResponseBody
    List<ControlLog> getControlLogByTime(HttpServletRequest request){
        ControlLogQuery query =new ControlLogQuery();
        String startTime=request.getParameter("start_time");
        String stopTime =request.getParameter("stop_time");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try{
            if(!Strings.isNullOrEmpty(stopTime)){
                Date endDate=sdf.parse(stopTime);
                query.setEndTime(endDate);
            }

            if(!Strings.isNullOrEmpty(startTime)){
                Date startDate = sdf.parse(startTime);
                query.setStartTime(startDate);
            }
        }catch(ParseException e){
            e.printStackTrace();
        }
        List<ControlLog> controlLog=cmdControlService.queryControlLog(query);
        for (ControlLog con: controlLog) {
            String[] lightIds=con.getLightIds().split(";");
            List<Light> lights=con.getLights();
            if(lights == null){
                lights = Lists.newArrayList();
            }
            for(int i=0;i<lightIds.length-1;i++){
                Light light=lightService.findLightById(Integer.valueOf(lightIds[i]));
                lights.add(light);
            }
            con.setLights(lights);
        }
        return controlLog ;
    }


    /**
     * 对所有的的灯进行操作。即时操作
     * @param request
     * @param response
     */
    @RequestMapping(value="/timelyall")
    public @ResponseBody
    void controlAllLights(HttpServletRequest request, HttpServletResponse response){
        String bright=request.getParameter("bright");
        ControlLog controlLog=new ControlLog();
        if(Integer.valueOf(bright).intValue() == 0){
            controlLog.setCmd(0);
        }else {
            controlLog.setCmd(1);
        }
        controlLog.setBright(Integer.parseInt(bright)*255/100);
        User user = authenticationService.queryUserById(1);
        controlLog.setUser(user);
        List<Light> lights = lightService.findAllLights();
        StringBuffer lightsBuffer = new StringBuffer();
        for(Light light : lights){
            lightsBuffer.append(light.getId().toString() + ";");
        }
        controlLog.setLightIds(lightsBuffer.toString());
        String data=Integer.toHexString(Integer.parseInt(bright)*255/100);


        switch(data.length()){
            case 1:data = "0" + data;
                break;
        }
        //charu mysql
//        cmdControlService.insertControlLog(controlLog);
        String cmd = cmdControlService.getCmdInfo("0000","0000","01",data);
        cmd = "@" + cmd + "$";

        redisService.pushCmd("gaogandeng:timelytask:list", cmd);
    }

    /**
     * 对非所有灯操作
     * @param request
     * @param response
     */
    @RequestMapping(value = "/timelygroup")
    public @ResponseBody
    void controlGroupLights(HttpServletRequest request, HttpServletResponse response){
        String deviceNo = request.getParameter("device_no");
        String groupNo = request.getParameter("group_no");
        String dengNo = request.getParameter("deng_no");
        String bright = request.getParameter("bright");
        String codeNo;
        String data = "";
        StringBuffer lightIds = new StringBuffer();

        Light queryLight = new Light();
        //对单灯控制器的所有组操作
        if(Strings.isNullOrEmpty(groupNo) && Strings.isNullOrEmpty(dengNo)){
            codeNo = "01";
            data =Integer.toHexString(Integer.parseInt(bright)*255/100);
            switch(data.length()){
                case 1:data = "0" + data;
                    break;
            }
            queryLight.setDeviceId(deviceNo);
            System.out.print(deviceNo);
            List<Light> lights = lightService.findLight(queryLight);
            if(lights != null){
                for(Light light : lights){
                    lightIds.append(light.getId() + ";");
                }
            }
        }else if(Strings.isNullOrEmpty(dengNo)){      //对单个单灯控制器多组操作
            codeNo = "03";
            queryLight.setDeviceId(deviceNo);
            String []groupNos = groupNo.split(";");
            for(String gs : groupNos){
                String brightHex = Integer.toHexString(Integer.parseInt(bright)*255/100);
                switch(brightHex.length()){
                    case 1:brightHex = "0" + brightHex;
                        break;
                }
                String gsHex = Integer.toHexString(Integer.parseInt(gs));
                switch(gsHex.length()){
                    case 1:gsHex = "0" + gsHex;
                        break;
                }
                data = data + gsHex + brightHex;

//                System.out.println(data);
                if(gs!=""){
                    queryLight.setGroupId(gs);
                }
                List<Light> lights = lightService.findLight(queryLight);
                if(lights != null){
                    for(Light light : lights){
                        lightIds.append(light.getId() + ";");
                    }
                }

            }
        }else {                         //对单个单灯控制器多组中的多台灯操作
            codeNo = "04";
            queryLight.setDeviceId(deviceNo);
            String []groupNos = groupNo.split(";");
            String []dengNos = dengNo.split(";");
            for(String gs : groupNos){
                String tmp = "";
                queryLight.setGroupId(gs);
                for(String ds : dengNos){
                    String br=Integer.toHexString(Integer.parseInt(bright)*255/100);
                    switch(br.length()){
                        case 1:br = "0" + br;
                            break;
                    }
                    String gsHex = Integer.toHexString(Integer.parseInt(gs));
                    switch(gsHex.length()){
                        case 1:gsHex = "0" + gsHex;
                            break;
                    }
                    tmp += gsHex+ds+br;
                    queryLight.setInGroupId(ds);
                    List<Light> lights = lightService.findLight(queryLight);
                    if(lights != null){
                        for(Light light : lights){
                            lightIds.append(light.getId() + ";");
                        }
                    }

                }
                data = data + tmp ;
//              System.out.println(data);
            }
        }

        String cmd = cmdControlService.getCmdInfo(deviceNo, "0000", codeNo, data);
        cmd = "@" + cmd + "$";
//        System.out.println(cmd);
        redisService.pushCmd("gaogandeng:timelytask:list", cmd);

        ControlLog controlLog = new ControlLog();

        //TODO 查询当前登录用户并设置到controlLog中.
//        controlLog.setUser(request.getSession());

        controlLog.setBright(Integer.parseInt(bright)*255/100);
        controlLog.setLightIds(lightIds.toString());
        if(Integer.parseInt(bright) > 0){
            controlLog.setCmd(1);
        }else {
            controlLog.setCmd(0);
        }

        cmdControlService.insertControlLog(controlLog);
    }

    @RequestMapping(value = "/timergroup")
    public @ResponseBody
    void controlTimeCmd(HttpServletRequest request, HttpServletResponse response){
        String openTime = request.getParameter("open_time");
        String closeTime = request.getParameter("close_time");
        String deviceNo = request.getParameter("device_no");
        String groupNo = request.getParameter("group_no");
        String dengNo = request.getParameter("deng_no");
        String bright = request.getParameter("bright");
        StringBuffer lightIds = new StringBuffer();
        ControlLog controlLog = new ControlLog();
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm");

        try {
            if(!Strings.isNullOrEmpty(openTime)){
                controlLog.setOpenTime(df.parse(openTime));
            }
            if(!Strings.isNullOrEmpty(closeTime)){
                controlLog.setCloseTime(df.parse(closeTime));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        Light queryLight = new Light();
        if(Strings.isNullOrEmpty(deviceNo)){
            List<Light> lights = lightService.findAllLights();
            for(Light light : lights){
                lightIds.append(light.getId() + ";");
            }
        }else if(Strings.isNullOrEmpty(groupNo)){
            queryLight.setDeviceId(deviceNo);
            List<Light> lights = lightService.findLight(queryLight);
            for(Light light : lights){
                lightIds.append(light.getId() + ";");
            }
        }else if(Strings.isNullOrEmpty(dengNo)){
            queryLight.setDeviceId(deviceNo);
            String[] groups = groupNo.split(";");
            for(String gs : groups){
                queryLight.setGroupId(gs);
                List<Light> lights = lightService.findLight(queryLight);
                if(lights != null){
                    for(Light light : lights){
                        lightIds.append(light.getId() + ";");
                    }
                }
            }
        }else{              //都不为空
            queryLight.setDeviceId(deviceNo);
            String []groupNos = groupNo.split(";");
            String []dengNos = dengNo.split(";");
            for(String gs : groupNos){
                queryLight.setGroupId(gs);
                for(String ds : dengNos){
                    queryLight.setInGroupId(ds);
                    List<Light> lights = lightService.findLight(queryLight);
                    if(lights != null){
                        for(Light light : lights){
                            lightIds.append(light.getId() + ";");
                        }
                    }
                }
            }
        }


        controlLog.setBright(Integer.parseInt(bright)*255/100);

        controlLog.setLightIds(lightIds.toString());
//        System.out.println(lightIds.toString());

        //TODO 自己添加当前用户信息
        controlLog.setUser(authenticationService.queryUserById(1));
        /**
         * 获得所有细分任务后的时间任务
         */
        Map<Date, String> tasks = cmdControlService.insertControlLog(controlLog);
//        System.out.print("DD");
        for(Date date : tasks.keySet()){
//            String dt = df.format(date);
////            System.out.println(dt);
//
//            Date date1 = null;
//            try {
//                date1 = df.parse(dt);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
            String dateAfterChange =  String.valueOf(date.getTime()/1000);
//            System.out.println(dateAfterChange);
            redisService.insertMap("gaogandeng:timertask:hash",dateAfterChange, tasks.get(date));
            redisService.pushTimeCmd("gaogandeng:timertask:list", dateAfterChange);

        }

    }


    @RequestMapping(value = "/sitecontrol")
    public @ResponseBody
    void sitelightcontrol(HttpServletRequest request){
        String longitude = request.getParameter("longitude");
        String latitude = request.getParameter("latitude");
        String controldays = request.getParameter("controldays");


        if(controldays==""){
            controldays="0";
        }
        String cdHex = Integer.toHexString(Integer.parseInt(controldays));
        switch(cdHex.length()){
            case 1: cdHex = "0" + cdHex;
                break;
        }

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
//        System.out.println(year+" "+month+" "+day);
        Integer daylist=null;
        Integer frdays=null;
        if( ((year%4==0)&&(year%100!=0)) || ((year%100==0)&&(year%400==0)) ){
            frdays = 29;
        }else{
            frdays = 28;
        }
        switch (month){
            case 1:daylist=day;
                break;
            case 2:daylist=31+day;
                break;
            case 3:daylist=31+frdays+day;
                break;
            case 4:daylist=31*2+frdays+day;
                break;
            case 5:daylist=31*2+30+frdays+day;
                break;
            case 6:daylist=31*3+30+frdays+day;
                break;
            case 7:daylist=31*3+30*2+frdays+day;
                break;
            case 8:daylist=31*4+30*2+frdays+day;
                break;
            case 9:daylist=31*5+30*2+frdays+day;
                break;
            case 10:daylist=31*5+30*3+frdays+day;
                break;
            case 11:daylist=31*6+30*3+frdays+day;
                break;
            case 12:daylist=31*6+30*4+frdays+day;
                break;
        }

//        System.out.println(frdays+" "+daylist);

        Double pi = Math.PI;
        Double longitudeDou = Double.parseDouble(longitude);
        Double latitudeDou = Double.parseDouble(latitude);
        Double sunrise = 24*(180+8*15-longitudeDou-Math.acos(-Math.tan(-23.4*Math.cos(2*pi*(daylist+9)/365)*pi/180)*Math.tan(latitudeDou*pi/180))*180/pi)/360;
        Double sunset = 24*(1+(8*15-longitudeDou)/180)-sunrise;

        //日出时间
        int sunriseHour = (int)(sunrise*10)/10;
        int sunriseMin =(int)((sunrise-sunriseHour)*60*10)/10;
        String sunriseHourHex = Integer.toHexString(sunriseHour);
        switch(sunriseHourHex.length()){
            case 1: sunriseHourHex = "0" + sunriseHourHex;
                break;
        }
        String sunriseMinHex =Integer.toHexString(sunriseMin);
        switch(sunriseMinHex.length()){
            case 1: sunriseMinHex = "0" + sunriseMinHex;
                break;
        }

        //日落时间
        int sunsetHour = (int)(sunset*10)/10;
        int sunsetMin =(int)((sunset-sunsetHour)*60*10)/10;
        String sunsetHourHex = Integer.toHexString(sunsetHour);
        switch(sunsetHourHex.length()){
            case 1: sunsetHourHex = "0" + sunsetHourHex;
                break;
        }
        String sunsetMinHex =Integer.toHexString(sunsetMin);
        switch(sunsetMinHex.length()){
            case 1: sunsetMinHex = "0" + sunsetMinHex;
                break;
        }


        String data = "2"+cdHex+"02"+sunriseHourHex+sunriseMinHex+"00"+sunsetHourHex+sunsetMinHex+"ff";
        String cmd = cmdControlService.getCmdInfo("0000","0000","08",data);
        cmd = "@" + cmd + "$";
//        System.out.print(cmd);

        redisService.pushCmd("gaogandeng:timelytask:list", cmd);
    }


    @RequestMapping(value = "/suncontrol")
    public @ResponseBody
    void sunlightcontrol(HttpServletRequest request){
        String openlimit = request.getParameter("openlimit");
        String closelimit = request.getParameter("closelimit");
        String controldays = request.getParameter("controldays");
        if(controldays==""){
            controldays="0";
        }
        String cdHex = Integer.toHexString(Integer.parseInt(controldays));
        switch(cdHex.length()){
            case 1: cdHex = "0" + cdHex;
                break;
        }
        String data = "3"+cdHex+openlimit+closelimit;

        String cmd = cmdControlService.getCmdInfo("0000","0000","09",data);
        cmd = "@" + cmd + "$";
        System.out.print(cmd);

        redisService.pushCmd("gaogandeng:timelytask:list", cmd);
    }


}
