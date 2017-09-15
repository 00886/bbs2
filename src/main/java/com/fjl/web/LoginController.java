package com.fjl.web;

import com.fjl.domain.User;
import com.fjl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller

public class LoginController {

    private UserService userService;

    @RequestMapping(value = "/register.html",method = RequestMethod.GET)
    public String initForm(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        // 直接跳转到登录页面
        return "register";
    }

    @RequestMapping("/login.html")
    public String login(@ModelAttribute("user")User user, HttpServletRequest request){

        userService.login(user,request);
        if(user!=null){
            return "main";
        }
        return "error";
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
