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
import org.springframework.web.context.request.SessionScope;

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
    public String saveUser(HttpServletRequest request, UserForm userForm){
        logger.info("saveUser called");
        userForm.setUserName(request.getParameter("username"));
        userForm.setPassword(request.getParameter("password"));

        boolean right = authenticationService.validate(userForm);

        if(right){
            User user = new User();
            user.setUserName(userForm.getUserName());
            user.setAuthority(userForm.getAuthority());
            request.getSession().setAttribute("user",user);
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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String authority = request.getParameter("authority");

        if(!username.equals("")&&!password.equals("")&&!authority.equals("")){
            User user = new User();
            user.setUserName(username);
            user.setPassword(password);
            user.setPhone(phone);
            user.setAddress(address);
            user.setAuthority(Integer.valueOf(authority));

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
            if(!have){
                authenticationService.insertUser(user);
                return "manage";
            }else{
                model.addAttribute("error","用户名已存在");
                return "adduser";
            }
        }else{
            model.addAttribute("error2","请输入");
            return "adduser";
        }



    }

}
