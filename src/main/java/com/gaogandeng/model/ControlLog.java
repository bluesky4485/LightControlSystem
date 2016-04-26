package com.gaogandeng.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by lanxing on 16-3-15.
 */
public class ControlLog implements Serializable {
    private static final long serialVersionUID = 3513256236216809910L;

    private Integer id;             //控制编号
    private Date openTime;          //开灯时间，为null表示没有开灯动作
    private Date closeTime;         //关灯时间，为null表示无关灯动作，若开灯关灯都为null则表示即时消息
    private User user;              //执行人员
    private List<Light> lights;     //灯具列表
    private String lightIds;       //灯具ids，以“;”分开
    private Date infoTime;          //执行时间
    private Integer status = 1;     //执行状态（0：未执行，1：执行, 2:失败）
    private Integer bright;         //灯光亮度
    private Integer cmd;            //命令类型0：关灯操作，1：开灯操作

    public Integer getBright() {
        return bright;
    }

    public void setBright(Integer bright) {
        this.bright = bright;
    }

    public Integer getCmd() {
        return cmd;
    }

    public void setCmd(Integer cmd) {
        this.cmd = cmd;
    }

    public String getLightIds() {
        return lightIds;
    }

    public void setLightIds(String lightIds) {
        this.lightIds = lightIds;
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

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Light> getLights() {
        return lights;
    }

    public void setLights(List<Light> lights) {
        this.lights = lights;
    }

    public Date getInfoTime() {
        return infoTime;
    }

    public void setInfoTime(Date infoTime) {
        this.infoTime = infoTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ControlLog{" +
                "id=" + id +
                ", openTime=" + openTime +
                ", closeTime=" + closeTime +
                ", user=" + user +
                ", lights=" + lights +
                ", lightIds='" + lightIds + '\'' +
                ", infoTime=" + infoTime +
                ", status=" + status +
                ", bright=" + bright +
                ", cmd=" + cmd +
                '}';
    }
}
