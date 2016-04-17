package com.gaogandeng.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lanxing on 16-3-15.
 */
public class WarningLog implements Serializable {
    private static final long serialVersionUID = 7620583132452315105L;

    private Integer id;         //报警id
    private Light light;        //报警灯具
    private String info;        //报警信息
    private Integer status = 0;     //报警状态（0：未处理，1：已处理）
    private Date infoTime;      //报警日期

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Light getLight() {
        return light;
    }

    public void setLight(Light light) {
        this.light = light;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getInfoTime() {
        return infoTime;
    }

    public void setInfoTime(Date infoTime) {
        this.infoTime = infoTime;
    }

    @Override
    public String toString() {
        return "WarningLog{" +
                "id=" + id +
                ", light=" + light +
                ", info='" + info + '\'' +
                ", status=" + status +
                ", infoTime=" + infoTime +
                '}';
    }
}
