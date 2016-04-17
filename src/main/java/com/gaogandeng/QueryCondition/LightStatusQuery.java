package com.gaogandeng.QueryCondition;

import java.util.Date;

/**
 * Created by lanxing on 16-3-16.
 */
public class LightStatusQuery {
    private Integer lightId;
    private Date startTime;
    private Date endTime;

    public Integer getLightId() {
        return lightId;
    }

    public void setLightId(Integer lightId) {
        this.lightId = lightId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "LightStatusQuery{" +
                "lightId=" + lightId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
