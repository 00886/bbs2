package com.fjl.service.impl;

import com.fjl.dao.LoginLogDao;
import com.fjl.dao.UserDao;
import com.fjl.domain.LoginLog;
import com.fjl.domain.User;
import com.fjl.exception.UserExistException;
import com.fjl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Service("userService")
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private LoginLogDao loginLogDao;
    //注册
    public void register(User user) throws UserExistException {
        if(userDao.getUserByUserName(user.getUser_name())!=null){
            throw new UserExistException("用户已经存在");
        }else{
            //新用户注册送20积分
            user.setCredit(20);
            //设置为普通用户
            user.setUser_type(User.NORMAL_USER);
            userDao.save(user);
        }
    }

    public User getUserByUserName(String user_name){
        return userDao.getUserByUserName(user_name);
    }
    //登陆
    public void login(User user,HttpServletRequest request){
        User dbUser = userDao.getUserByUserName(user.getUser_name());
        if(dbUser==null){           //数据库查询不到用户
            System.out.println("1用户名或密码错误");
        }else if(!dbUser.getPassword().equals(user.getPassword())){          //密码和数据库的不匹配
            System.out.println("2用户名密码错误");
        }else if(dbUser.getLocked()==1){           //是否锁定用户
            System.out.println("3该用户已锁定，暂时无法登陆");
        }else{
            dbUser.setUser_id(dbUser.getUser_id());
            dbUser.setLast_ip(request.getRemoteAddr());
            dbUser.setLast_visit(new Date());
            loginSuccess(dbUser);
        }
    }
    //登陆成功
    public void loginSuccess(User user){
        user.setCredit( 5 + user.getCredit());
        LoginLog loginLog = new LoginLog();
        loginLog.setUser(user);
        loginLog.setIp(user.getLast_ip());
        loginLog.setLogin_datetime(new Date());
        userDao.update(user);
        loginLogDao.save(loginLog);
    }
    //根据id获取用户
    public User getUserById(int userId){
        return userDao.get(userId);
    }
    //锁定用户
    public void lockUser(String user_name){
        User user = userDao.getUserByUserName(user_name);
        user.setLocked(User.USER_LOCK);
        userDao.update(user);
    }
    //解锁用户
    public void unlockUser(String user_name){
        User user = userDao.getUserByUserName(user_name);
        user.setLocked(User.USER_UNLOCK);
        userDao.update(user);
    }
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    @Autowired
    public void setLoginLogDao(LoginLogDao loginLogDao) {
        this.loginLogDao = loginLogDao;
    }
}
