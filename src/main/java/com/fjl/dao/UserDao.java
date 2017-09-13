package com.fjl.dao;

import com.fjl.dao.impl.BaseDaoImpl;
import com.fjl.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserDao extends BaseDao<User>{

    public User getUserByUserName(String user_name);
}
