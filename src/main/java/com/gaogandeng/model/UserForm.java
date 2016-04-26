package com.gaogandeng.model;

/**
 * Created by gch on 16-4-9.
 */
public class UserForm {
    private Integer userId;
    private String userName;
    private String password;
    private Integer Authority = 0;      //权限，0：一般用户，1：管理员用户。默认为0
    private String phone;
    private String address;

    public Integer getUserId() {
        return userId;
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
        Authority = authority;
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

    public void setUserId(Integer userId) {
        this.userId = userId;

    }
}
