package com.zhangxx.dao;

import com.zhangxx.domain.User;

import java.util.List;

public interface IUserDao {

    List<User> findAll();
}
