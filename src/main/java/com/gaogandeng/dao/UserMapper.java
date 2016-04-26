package com.gaogandeng.dao;

import com.gaogandeng.model.User;

import java.util.List;

/**
 * Created by lanxing on 16-3-16.
 */
public interface UserMapper {
    public List<User> findAllUsers();
    public User findUserByName(String userName);
    public void insertUser(User user);
    public User findUserById(Integer userId);
    public void deleteUserById(Integer userId);
}
