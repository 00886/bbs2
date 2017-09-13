package com.fjl.service;

import com.fjl.domain.User;
import com.fjl.exception.UserExistException;

import javax.servlet.http.HttpServletRequest;


public interface UserService {

    void register(User user) throws UserExistException;
    User getUserByUserName(String user_name);
    void login(User user,HttpServletRequest request);
    User getUserById(int userId);
}
