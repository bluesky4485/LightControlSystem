package com.gaogandeng.service;

import com.gaogandeng.model.Light;

import java.util.List;

/**
 * Created by lanxing on 16-3-15.
 */
public interface LightService {

    /**
     * 查询所有灯具的信息
     * @return 包含所有灯具信息的链表
     */
    public List<Light> findAllLights();

    /**
     * 根据灯具在数据库中的id查询灯具信息
     * @param id
     * @return
     */
    public Light findLightById(int id);

    /**
     * 根据灯具信息查询灯具，对于不需要查询的字段可以不对其进行赋值
     * @param light
     * @return
     */
    public List<Light> findLight(Light light);

    /**
     * 插入灯具信息，不需要设置灯具的id，由于在MyBatis插入时设置了自动增长id，因此插入后可以直接调用原对象
     * @param light
     */
    public void insertLight(Light light);
}
