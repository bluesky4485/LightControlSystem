package com.gaogandeng.Enum;

/**
 * Created by lanxing on 16-3-16.
 */
public enum CmdStatus {
    UNEXECUTED(0, "未执行"),
    EXECUTED(1, "已执行"),
    OVERWRITE(2, "任务被覆盖"),
    FAILED(3, "失败");

    private Integer status;
    private String desc;

    private CmdStatus(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public static CmdStatus getCmdStatus(Integer index){
        for (CmdStatus status : CmdStatus.values()){
            if(index.intValue() == status.getStatus().intValue()){
                return status;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "CmdStatus{" +
                "status=" + status +
                ", desc='" + desc + '\'' +
                '}';
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
