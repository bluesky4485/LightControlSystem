package com.gaogandeng.service;

import com.gaogandeng.model.Area;

import java.util.List;

/**
 * Created by biny on 16-5-18.
 */
public interface AreaService {
    void insertArea(Area area);
    List<Area> findAllAreas();
}
