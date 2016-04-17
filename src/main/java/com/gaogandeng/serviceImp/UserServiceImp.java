package com.gaogandeng.serviceImp;

import com.gaogandeng.dao.UserMapper;
import com.gaogandeng.model.User;
import com.gaogandeng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lanxing on 16-3-16.
 */
@Service("userService")
public class UserServiceImp implements UserService {


    private UserMapper userMapper;

    public List<User> findAllUsers() {
        return userMapper.findAllUsers();
    }

    public User findUserByName(String userName) {
        return userMapper.findUserByName(userName);
    }

    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    public User findUserById(Integer userId) {
        return userMapper.findUserById(userId);
    }

    public void deleteUserById(Integer userId) {
        userMapper.deleteUserById(userId);
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
