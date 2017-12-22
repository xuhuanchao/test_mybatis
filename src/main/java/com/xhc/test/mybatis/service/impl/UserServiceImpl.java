package com.xhc.test.mybatis.service.impl;

import com.xhc.test.mybatis.dao.UserMapper;
import com.xhc.test.mybatis.entity.User;
import com.xhc.test.mybatis.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mymac on 2017/12/1.
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    public void addUser(User user) {
        userMapper.insert(user);
    }

    public User getUserById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
}
