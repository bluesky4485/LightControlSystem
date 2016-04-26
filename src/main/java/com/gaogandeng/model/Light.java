package com.gaogandeng.model;

import java.io.Serializable;

/**
 * Created by lanxing on 16-3-15.
 */
public class Light implements Serializable {
    private static final long serialVersionUID = 2490459323993635193L;

    private Integer id;
    private String deviceId;
    private String groupId;
    private String inGroupId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getInGroupId() {
        return inGroupId;
    }

    public void setInGroupId(String inGroupId) {
        this.inGroupId = inGroupId;
    }

    @Override
    public String toString() {
        return "Light{" +
                "id=" + id +
                ", deviceId='" + deviceId + '\'' +
                ", groupId='" + groupId + '\'' +
                ", inGroupId='" + inGroupId + '\'' +
                '}';
    }
}
