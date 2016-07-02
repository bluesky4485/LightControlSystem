package com.gaogandeng.service;

import com.gaogandeng.model.User;

import java.util.List;

/**
 * Created by lanxing on 16-3-16.
 * 用户信息
 */

public interface UserService {
     List<User> findAllUsers();
     User findUserByName(String userName);
     void insertUser(User user);
     User findUserById(Integer userId);
     void deleteUserById(Integer userId);
}
