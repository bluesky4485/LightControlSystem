package com.gaogandeng.Enum;

/**
 * Created by lanxing on 16-3-17.
 */
public enum FunctionCode {
    CONCENTRATE_CONTROL("01", "对所有集中控制器进行控制"),
    SINGLE_CONCENTRATE("03", "对单个集中控制器中的多组进行控制"),
    SINGLE_LIGHT("04", "对单个集中控制器多个灯进行操作");

    private String code;
    private String desc;

    FunctionCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
