package com.gaogandeng.controller;

import com.gaogandeng.model.Area;
import com.gaogandeng.model.ControlLog;
import com.gaogandeng.model.Light;
import com.gaogandeng.model.User;
import com.gaogandeng.service.LightService;
import com.gaogandeng.utils.AreaUtilService;
import com.gaogandeng.utils.AuthenticationService;
import com.gaogandeng.utils.CmdControlService;
import com.gaogandeng.utils.RedisService;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by biny on 16-5-19.
 */
@Controller
@RequestMapping(value="/area/")
public class AreaControl {
    private AreaUtilService areaUtilService;
    private AuthenticationService authenticationService;
    private CmdControlService cmdControlService;
    private RedisService redisService;
    private LightService lightService;

    @Autowired
    public void setLightService(LightService lightService) {
        this.lightService = lightService;
    }

    @Autowired
    public void setRedisService(RedisService redisService) {
        this.redisService = redisService;
    }

    @Autowired

    public void setCmdControlService(CmdControlService cmdControlService){
        this.cmdControlService=cmdControlService;
    }

    @Autowired
    public void setAuthenticationService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

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

    @RequestMapping(value="/timeControl")
    public @ResponseBody
    void areaTimeControl(HttpServletRequest request){
        final String openTime = request.getParameter("open_time");
        final String closeTime = request.getParameter("close_time");
        final String areaNo = request.getParameter("areaNo");
        final String bright = request.getParameter("bright");
        final String controlDays = request.getParameter("control_days");

        //设置执行时间
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);//每天
        //定制每天的00:00:00执行，
        calendar.set(year, month, day, 0, 0, 0);
        Date date = calendar.getTime();
        final Timer timer = new Timer();
        System.out.println("执行时间："+date);


        final ControlLog controlLog = new ControlLog();

        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm");

        String[] open ;
        String[] close ;
        String newOpenTime;
        String newCloseTime;
        try {
            if(!Strings.isNullOrEmpty(openTime)){
                open = openTime.split(" ");
                newOpenTime = Integer.valueOf(year)+"/"+Integer.valueOf(month+1)+"/"+Integer.valueOf(day)+" "+open[1];
                controlLog.setOpenTime(df.parse(newOpenTime));

            }
            if(!Strings.isNullOrEmpty(closeTime)){
                close = closeTime.split(" ");
                newCloseTime = Integer.valueOf(year)+"/"+Integer.valueOf(month+1)+"/"+Integer.valueOf(day)+" "+close[1];
                controlLog.setCloseTime(df.parse(newCloseTime));

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        String lightsIds = "";
        String[] areaNos = areaNo.split(";");
        for(String as : areaNos){
            Area area = areaUtilService.findareaById(Integer.parseInt(as));
            String lightsId = area.getLightsId();
            lightsIds += lightsId;
        }

        controlLog.setBright(Integer.parseInt(bright)*255/100);

        controlLog.setLightIds(lightsIds);
        //TODO 自己添加当前用户信息
        controlLog.setUser(authenticationService.queryUserById(1));

        //具体任务
        TimerTask task = new TimerTask(){
            private int count = 0;
            public void run() {

                Map<Date, String> tasks = cmdControlService.insertControlLog(controlLog);
                for(Date date : tasks.keySet()){
                    String dateAfterChange =  String.valueOf(date.getTime()/1000);
                    redisService.insertMap("gaogandeng:timertask:hash",dateAfterChange, tasks.get(date));
                    redisService.pushTimeCmd("gaogandeng:timertask:list", dateAfterChange);

                }
                ++count;
                System.out.println("时间：" + new Date() + " 执行了第" + count + "次"); // 1次
                if(!controlDays.equals("0")){
                    if (count == Integer.parseInt(controlDays)) {
                        System.out.println("定时器停止了");
                        timer.cancel();// 停止定时器
                    }
                }

            }
        };

        //定期执行
        timer.schedule(task, date);

    }

    /**
     * 对区域的灯进行操作。即时操作
     * @param request
     */
    @RequestMapping(value="/timelyControl")
    public @ResponseBody
    void areaTimelyControl(HttpServletRequest request) {
        String bright = request.getParameter("bright");
        String areaNo = request.getParameter("areaNo");
        String[] areaNos = areaNo.split(";");
        List<Light> lightList = new ArrayList<Light>();
        String lightIds = "";
        String br=Integer.toHexString(Integer.parseInt(bright)*255/100);
        switch(br.length()){
            case 1:br = "0" + br;
                break;
        }
        for(String as : areaNos){
            Area area = areaUtilService.findareaById(Integer.parseInt(as));
            String lightsId = area.getLightsId();
            lightIds += lightsId;
            String[] lights = lightsId.split(";");
            for(String ls : lights){
                Light light = lightService.findLightById(Integer.parseInt(ls));
                lightList.add(light);
            }
        }

        Map<String,List> map = new HashMap<String, List>();
        for(Light light : lightList){
            String deviceNo = light.getDeviceId();
            if(map.containsKey(deviceNo)){
                map.get(deviceNo).add(light);
            }else {
                List list = new ArrayList();
                list.add(light);
                map.put(deviceNo,list);
            }
        }

        for(Map.Entry<String,List> entry : map.entrySet()){
            String deviceno = entry.getKey();
            List<Light> list = entry.getValue();
            String codeNo = "04";
            String data = "";
            for(Light light : list){
                String groupNo = light.getGroupId();
                String inGroupNo = light.getInGroupId();
                String gsHex = Integer.toHexString(Integer.parseInt(groupNo));
                switch(gsHex.length()){
                    case 1:gsHex = "0" + gsHex;
                        break;
                }
                data += gsHex+inGroupNo+br;
            }
            String cmd = cmdControlService.getCmdInfo(deviceno, "0000", codeNo, data);
            cmd = "@" + cmd + "$";
            redisService.pushCmd("gaogandeng:timelytask:list", cmd);

//            ControlLog controlLog = new ControlLog();
//
//            //TODO 查询当前登录用户并设置到controlLog中.
//
//            controlLog.setBright(Integer.parseInt(bright)*255/100);
//            controlLog.setLightIds(lightIds);
//            if(Integer.parseInt(bright) > 0){
//                controlLog.setCmd(1);
//            }else {
//                controlLog.setCmd(0);
//            }
//
//            cmdControlService.insertControlLog(controlLog);
        }

    }
}
