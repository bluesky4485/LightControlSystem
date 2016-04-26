package com.gaogandeng.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lanxing on 16-3-15.
 */
public class LightStatusLog implements Serializable {
    private static final long serialVersionUID = -8652145620540384465L;

    private Integer id;
    private Light light;                //灯具信息
    private Double vol;                 //灯具电压
    private Double cur;                 //灯具电流
    private Double pow;                 //灯具功率
    private Integer bright;             //灯具亮度
    private Integer enviBright;         //环境亮度
    private Double temperature;         //温度
    private Double temperature1;         //温度

    private Double temperature2;         //温度

    private Date infoTime;              //状态时间

    public Double getTemperature1() {
        return temperature1;
    }

    public void setTemperature1(Double temperature1) {
        this.temperature1 = temperature1;
    }

    public Double getTemperature2() {
        return temperature2;
    }

    public void setTemperature2(Double temperature2) {
        this.temperature2 = temperature2;
    }

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

    public Double getVol() {
        return vol;
    }

    public void setVol(Double vol) {
        this.vol = vol;
    }

    public Double getCur() {
        return cur;
    }

    public void setCur(Double cur) {
        this.cur = cur;
    }

    public Double getPow() {
        return pow;
    }

    public void setPow(Double pow) {
        this.pow = pow;
    }

    public Integer getBright() {
        return bright;
    }

    public void setBright(Integer bright) {
        this.bright = bright;
    }

    public Integer getEnviBright() {
        return enviBright;
    }

    public void setEnviBright(Integer enviBright) {
        this.enviBright = enviBright;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Date getInfoTime() {
        return infoTime;
    }

    public void setInfoTime(Date infoTime) {
        this.infoTime = infoTime;
    }

    @Override
    public String toString() {
        return "LightStatusLog{" +
                "id=" + id +
                ", light=" + light +
                ", vol=" + vol +
                ", cur=" + cur +
                ", pow=" + pow +
                ", bright=" + bright +
                ", enviBright=" + enviBright +
                ", temperature=" + temperature +
                ", temperature1=" + temperature1 +
                ", temperature2=" + temperature2 +
                ", infoTime=" + infoTime +
                '}';
    }
}
