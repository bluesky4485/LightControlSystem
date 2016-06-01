package com.gaogandeng.dao;

import com.gaogandeng.model.Area;

import java.util.List;

/**
 * Created by biny on 16-5-18.
 */
public interface AreaMapper {
    public void insertArea(Area area);
    public List<Area> findAllAreas();
    public void deleteAreaById(Integer id);
    public Area findAreaById(Integer id);
    public void updateAreaLight(Area area);
}
