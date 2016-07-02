package com.gaogandeng.dao;

import com.gaogandeng.model.User;

import java.util.List;

/**
 * Created by lanxing on 16-3-16.
 */
public interface UserMapper {
    List<User> findAllUsers();
    User findUserByName(String userName);
    void insertUser(User user);
    User findUserById(Integer userId);
    void deleteUserById(Integer userId);
}
