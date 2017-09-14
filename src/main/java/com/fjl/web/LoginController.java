package com.fjl.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    //@RequestMapping("/login.html")
    public void login(){
        System.out.println("login()");
    }
}
