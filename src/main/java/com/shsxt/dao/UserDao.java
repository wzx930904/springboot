package com.shsxt.dao;

import com.shsxt.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


/**
 * Created by Administrator on 2017/7/31.
 */
//@Mapper
public interface UserDao {

    @Select("select id,userName,password,gender from t_user")
    List<User> findlist();

    User findById(@Param(value = "id") Integer id);
}
