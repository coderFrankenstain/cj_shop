package com.cj.demo.service;


import com.cj.demo.dao.UserEntity;

/**
 * @author aomei
 */
public interface UserServiceInterface {
    /**
     * 根据id获取用户信息
     *
     * @param id 用户id
     * @return UserEntity
     */
    UserEntity getUserById(int id);


    UserEntity loginByName(String name,String password);

    UserEntity register(String username, String password);

}
