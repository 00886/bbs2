package com.fjl.dao.impl;

import com.fjl.dao.UserDao;
import com.fjl.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
    private static final String GET_USER_BY_USERNAME="FROM User u WHERE u.user_name=?";
    public User getUserByUserName(String user_name){
        List<User> list = (List<User>) getHibernateTemplate().find(GET_USER_BY_USERNAME,user_name);
        if(list.size()==0){
            return null;
        }else {
            return list.get(0);
        }
    }


}
