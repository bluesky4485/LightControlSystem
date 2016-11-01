package com.gaogandeng.model;

import java.util.List;

/**
 * Created by biny on 16-5-18.
 */
public class Area {
    private Integer areaId;
    private String areaName;
    private String lightsId;
    private List<Light> lights;

    public Area() {
    }

    public Area(Integer areaId, String areaName, String lightsId) {
        this.areaId = areaId;
        this.areaName = areaName;
        this.lightsId = lightsId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getLightsId() {
        return lightsId;
    }

    public void setLightsId(String lightsId) {
        this.lightsId = lightsId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public List<Light> getLights() {
        return lights;
    }

    public void setLights(List<Light> lights) {
        this.lights = lights;
    }
}
