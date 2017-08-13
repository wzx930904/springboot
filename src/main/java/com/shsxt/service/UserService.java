package com.shsxt.service;


import com.shsxt.dao.UserDao;
import com.shsxt.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/31.
 */
@Service
public class UserService {

    @Resource
    private UserDao userDao;

    public List<User> find() {
        List<User> users = new ArrayList<User>();
        users = userDao.findlist();
        return users;
    }

    public User findById(Integer id) {
        User user = userDao.findById(id);
        return user;
    }
}
