package com.fjl.service;

import com.fjl.domain.User;
import com.fjl.exception.UserExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

@ContextConfiguration("classpath:applicationContext.xml")
public class TestUserService extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    UserService userService;


    @Test
    public void testUserService() throws UserExistException {
        User user = new User();
        user.setUser_name("hehe");
        user.setPassword("h123456");
        userService.register(user);
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
