package com.gaogandeng.controller;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.gaogandeng.model.User;
import com.gaogandeng.model.UserForm;
import com.gaogandeng.utils.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by gch on 16-4-9.
 */
@Controller
public class UserController {
    private AuthenticationService authenticationService;

    @Autowired
    public void setUserValidatorService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    private static final Log logger = LogFactory.getLog(UserController.class);

    @RequestMapping(value="/login")
    public String saveUser(HttpServletRequest request, UserForm userForm, Model model){
        //logger.info("saveUser called");
        userForm.setUserName(request.getParameter("username"));
        userForm.setPassword(request.getParameter("password"));

        boolean right = authenticationService.validate(userForm);

        if(right){
            User user = new User();
            user.setUserName(userForm.getUserName());
            user.setAuthority(userForm.getAuthority());
            model.addAttribute("user",user);
            return "jiemian";
        }else{
            return "login";
        }

    }

    @RequestMapping(value="/user/all")
    public @ResponseBody
    List<User> getAllUsers(){
        return  authenticationService.queryAllUsers();
    }

    @RequestMapping(value="/user/delete")
    public @ResponseBody
    void deleteUser(HttpServletRequest request){
        String id = request.getParameter("userId");
        Integer userId = Integer.valueOf(id);
        authenticationService.deleteUserById(userId);
    }

    @RequestMapping(value="/jsp/adduser")
    public String addUser(HttpServletRequest request, Model model){
        User user = new User();
        user.setUserName(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setPhone(request.getParameter("phone"));
        user.setAddress(request.getParameter("address"));
        user.setAuthority(Integer.valueOf(request.getParameter("authority")));
        List<User> userList = authenticationService.queryAllUsers();
        Boolean have = false;
        if(userList!=null){
            for (User users:userList){
                if(users.getUserName().equals(user.getUserName())){
                    have=true;
                    break;
                }
            }
        }
        if(have==false){
            authenticationService.insertUser(user);
            return "manage";
        }else{
            model.addAttribute("error","用户名已被使用");
            return "adduser";
        }


    }

}
