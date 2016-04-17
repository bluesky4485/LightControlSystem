package com.gaogandeng.test;

import com.gaogandeng.model.User;
import com.gaogandeng.model.UserForm;
import com.gaogandeng.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by lanxing on 16-3-16.
 */
@RunWith(SpringJUnit4ClassRunner.class)   //相当于继承了SpringJUnit4ClassRunner
@ContextConfiguration(locations = {"classpath:spring.xml", "classpath:spring-mybatis.xml"})
public class UserTest {
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Test
    public void findAllUsers(){
        List<User> users = userService.findAllUsers();
        for (User user : users){
            System.out.println(user);
        }
    }

    @Test
    public void insertUser(){
        User user = new User();
        user.setUserName("张三");
        user.setPassword("123456");
        userService.insertUser(user);
    }

    @Test
    public void findUserByName(){
        User user = userService.findUserByName("张三");
        System.out.println(user);
    }

//    @Test
//    public void validate(){
//        UserForm userForm = new UserForm();
//        userForm.setPassword(null);
//        userForm.setUserName(null);
//        //UserValidator userValidator = new UserValidator();
////        List<String> list = userValidator.validate(userForm);
////        for(String ss:list){
////            System.out.println(ss);
////        }
//    }
}
