package com.gaogandeng.dao;

import com.gaogandeng.model.Light;

import java.util.List;

/**
 * Created by lanxing on 16-3-15.
 */
public interface LightMapper {
    public List<Light> findAllLights();
    public Light findLightById(Integer lightId);
    public List<Light> findLight(Light light);
    public void insertLight(Light light);
}
