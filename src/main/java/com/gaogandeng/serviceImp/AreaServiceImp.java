package com.gaogandeng.serviceImp;

import com.gaogandeng.dao.AreaMapper;
import com.gaogandeng.model.Area;
import com.gaogandeng.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by biny on 16-5-18.
 */
@Service("areaService")
public class AreaServiceImp implements AreaService{

    private AreaMapper areaMapper;

    public AreaMapper getAreaMapper() {
        return areaMapper;
    }

    @Autowired
    public void setAreaMapper(AreaMapper areaMapper) {
        this.areaMapper = areaMapper;
    }

    public void insertArea(Area area) {
        areaMapper.insertArea(area);
    }

    public List<Area> findAllAreas() {
       return  areaMapper.findAllAreas();
    }

    public void deleteAreaById(Integer id) {
        areaMapper.deleteAreaById(id);
    }
}
