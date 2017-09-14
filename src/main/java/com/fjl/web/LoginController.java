package com.fjl.web;

import com.fjl.domain.User;
import com.fjl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    private UserService userService;

    @RequestMapping("/login.html")
    public String login(@ModelAttribute("user")User user, HttpServletRequest request){
        System.out.println(request.getRemoteAddr());
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
