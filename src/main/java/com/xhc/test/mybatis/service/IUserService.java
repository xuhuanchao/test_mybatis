package com.xhc.test.mybatis.service;

import com.xhc.test.mybatis.entity.User;

/**
 * Created by mymac on 2017/12/1.
 */
public interface IUserService {

     void addUser(User user);

     User getUserById(Integer userId);
}
