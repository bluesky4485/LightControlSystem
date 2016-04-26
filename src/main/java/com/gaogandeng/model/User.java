package com.gaogandeng.model;

import java.io.Serializable;

/**
 * Created by lanxing on 16-3-15.
 */
public class User implements Serializable {

    private static final long serialVersionUID = 9103131991023746473L;

    private Integer userId;
    private String userName;
    private String password;
    private Integer Authority = 0;      //权限，0：一般用户，1：管理员用户。默认为0
    private String phone;
    private String address;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAuthority() {
        return Authority;
    }

    public void setAuthority(Integer authority) {
        this.Authority = authority;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", Authority=" + Authority +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
