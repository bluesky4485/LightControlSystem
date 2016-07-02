package com.gaogandeng.dao;

import com.gaogandeng.model.Light;

import java.util.List;

/**
 * Created by lanxing on 16-3-15.
 */
public interface LightMapper {
    List<Light> findAllLights();
    Light findLightById(Integer lightId);
    List<Light> findLight(Light light);
    void insertLight(Light light);
}
