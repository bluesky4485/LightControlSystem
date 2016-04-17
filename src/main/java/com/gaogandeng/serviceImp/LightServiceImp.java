package com.gaogandeng.serviceImp;

import com.gaogandeng.dao.LightMapper;
import com.gaogandeng.model.Light;
import com.gaogandeng.service.LightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lanxing on 16-3-15.
 */

@Service("lightService")
public class LightServiceImp implements LightService {

    private LightMapper lightMapper;

    public LightMapper getLightMapper() {
        return lightMapper;
    }

    @Autowired
    public void setLightMapper(LightMapper lightMapper) {
        this.lightMapper = lightMapper;
    }

    public List<Light> findAllLights() {
        return lightMapper.findAllLights();
    }

    public Light findLightById(int id) {
        return lightMapper.findLightById(id);
    }

    public List<Light> findLight(Light light) {
        return lightMapper.findLight(light);
    }

    public void insertLight(Light light) {
        lightMapper.insertLight(light);
    }
}
