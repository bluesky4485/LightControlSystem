package com.gaogandeng.utils;

import com.gaogandeng.QueryCondition.LightStatusQuery;
import com.gaogandeng.model.Light;
import com.gaogandeng.model.LightStatusLog;
import com.gaogandeng.service.LightService;
import com.gaogandeng.service.LightStatusLogService;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by lanxing on 16-3-16.
 * 用于服务灯具状态的业务类，业务代码可以写在此类中,可参考{@link com.gaogandeng.service.LightStatusLogService}
 */

@Service("lightStatusService")
public class LightStatusService {
    private LightStatusLogService lightStatusLogService;
    private LightService lightService;

    @Autowired
    public void setLightService(LightService lightService) {
        this.lightService = lightService;
    }

    @Autowired
    public void setLightStatusLogService(LightStatusLogService lightStatusLogService) {
        this.lightStatusLogService = lightStatusLogService;
    }

    /**
     * 根据查询条件查询灯具的状态
     * @param query
     * @return
     */
    public List<LightStatusLog> queryLightStatus(LightStatusQuery query){
        return lightStatusLogService.findLightStatus(query);
    }

    /**
     * 查询最近的状态信息
     * @param id
     * @return
     */
    public LightStatusLog queryLatestStatus(Integer id){
        return lightStatusLogService.findLatestStatus(id);
    }

    public List<Light> queryLights(Light light){
        return lightService.findLight(light);
    }

    /**
     * 查找light表里的所有灯具信息，同时对其进行分类，第一个Map的key值为deviceId，第二个Map的key值为groupId
     * @return
     */
    public Map<String, Map<String, List<Light> > > queryAllLights(){
        List<Light> lights = lightService.findAllLights();
        Map<String, Map<String, List<Light> > > devices = Maps.newHashMap();

        String deviceId;
        String groupId;
        for (Light light : lights){
            deviceId = light.getDeviceId();
            if(!devices.containsKey(deviceId)){
                devices.put(deviceId, Maps.<String, List<Light>>newHashMap());
            }
            Map tmpMap = devices.get(deviceId);
            groupId = light.getGroupId();
            if(!tmpMap.containsKey(groupId)){
                tmpMap.put(groupId, Lists.newArrayList());
            }

            List tmpList = (List) tmpMap.get(groupId);
            tmpList.add(light);
        }

        return devices;
    }

    /**
     * 查询所有灯具最近的状态信息
     * @return
     */
    public List<LightStatusLog> queryLatestStatus(){
        List<LightStatusLog> lists = Lists.newArrayList();
        List<Light> lights = lightService.findAllLights();
        LightStatusLog status = null;
        if(lights != null && !lights.isEmpty()){
            for(Light light : lights){
                status = lightStatusLogService.findLatestStatus(light.getId());
                if(status != null){
                    lists.add(status);
                }
            }
        }

        return lists;
    }
}
