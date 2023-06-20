package com.cj.demo.service.impl;

import com.cj.demo.dao.UserEntity;
import com.cj.demo.dao.mapper.UserMapper;
import com.cj.demo.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author aomei
 */
@Service
public class UserServiceImpl implements UserServiceInterface {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserEntity getUserById(int id) {
        return  userMapper.selectById(id);
    }

    @Override
    public UserEntity getUserByUuid(String uuid) {
        return userMapper.findUserByUuid(uuid);
    }

    @Override
    public UserEntity loginByName(String name, String password) {
        UserEntity user = userMapper.findUserByUsernameAndPassword(name, password);
        if (user != null) {
            System.out.println("User found with name: " + name);
        } else {
            System.out.println("No user found with name: " + name);
        }
        return user;
    }

    @Override
    public UserEntity register(String username, String password) {
        // 检查用户名是否已经存在
        UserEntity existingUser = userMapper.findUserByUsername(username);
        if (existingUser != null) {
            throw new IllegalArgumentException("Username already exists");
        }

        // 创建新的用户
        UserEntity newUser = new UserEntity();
        newUser.setUuid(UUID.randomUUID().toString());
        newUser.setUsername(username);
        newUser.setPassword(password);

        // 将新用户保存到数据库
        userMapper.insert(newUser);

        return newUser;
    }

}


