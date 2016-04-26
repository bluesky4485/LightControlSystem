package com.gaogandeng.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lanxing on 16-3-16.
 */
public class LightControlLog implements Serializable {
    private static final long serialVersionUID = -4277778027369956509L;

    private Integer id;
    private Light light;
    private Integer cmd;        //任务标识，0：关，1：开
    private Integer bright;     //强度
    private Integer status = 0;     //任务状态，0：未执行，1：已执行，2：覆盖，3：发送失败
    private Date cmdTime;       //任务执行时间

    @Override
    public String toString() {
        return "LightControlLog{" +
                "id=" + id +
                ", light=" + light +
                ", cmd=" + cmd +
                ", bright=" + bright +
                ", status=" + status +
                ", cmdTime=" + cmdTime +
                '}';
    }

    public Date getCmdTime() {
        return cmdTime;
    }

    public void setCmdTime(Date cmdTime) {
        this.cmdTime = cmdTime;
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

    public Integer getCmd() {
        return cmd;
    }

    public void setCmd(Integer cmd) {
        this.cmd = cmd;
    }

    public Integer getBright() {
        return bright;
    }

    public void setBright(Integer bright) {
        this.bright = bright;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
