package com.gaogandeng.dao;

import com.gaogandeng.model.Area;

import java.util.List;

/**
 * Created by biny on 16-5-18.
 */
public interface AreaMapper {
    void insertArea(Area area);
    List<Area> findAllAreas();

}
