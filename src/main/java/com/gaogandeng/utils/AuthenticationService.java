package com.gaogandeng.utils;

import com.gaogandeng.model.User;
import com.gaogandeng.model.UserForm;
import com.gaogandeng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jca.cci.core.InteractionCallback;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lanxing on 16-3-16.
 */
@Service("authenticationService")
public class AuthenticationService {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public List<User> queryAllUsers(){
        return userService.findAllUsers();
    }

    public User queryUserByName(String name){
        return userService.findUserByName(name);
    }

    public void insertUser(User user){
        userService.insertUser(user);
    }

    public User queryUserById(Integer id){
        return userService.findUserById(id);
    }

    public boolean validate(UserForm userForm){
        List<User> userList = userService.findAllUsers();
        String name= userForm.getUserName();
        String password = userForm.getPassword();
        for(User user:userList){
            if(user.getUserName().equals(name) && user.getPassword().equals(password)){
                userForm.setAuthority(user.getAuthority());
                return true;
            }

        }
        return false;


    }

    public void deleteUserById(Integer userId){
        userService.deleteUserById(userId);
    }
}
