package com.gaogandeng.Enum;

/**
 * Created by lanxing on 16-3-16.
 */
public enum CmdType {
    CLOSE(0, "关闭"),
    OPEN(1, "打开");

    private Integer type;
    private String desc;

    CmdType(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
