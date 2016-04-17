package com.gaogandeng.Enum;

/**
 * Created by lanxing on 16-3-16.
 */
public enum ErrorCode {
    USER_NOT_EXIT(10, "用户名不存在"),
    USER_PASSWORD_ERROR(11, "密码错误");

    private Integer errorCode;
    private String message;

    ErrorCode(Integer errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
