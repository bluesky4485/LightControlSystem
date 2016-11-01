package com.gaogandeng.QueryCondition;

import java.util.Date;

/**
 * Created by lanxing on 16-3-16.
 */
public class WarningLogQuery {
    private Integer id;
    private Date startTime;
    private Date endTime;
    private Integer status=0;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
