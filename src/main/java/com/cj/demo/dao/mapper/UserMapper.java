package com.cj.demo.dao.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cj.demo.dao.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author aomei
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
    @Select("SELECT * FROM users WHERE username = #{username} AND password = #{password}")
    UserEntity findUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    @Select("SELECT * FROM users WHERE username = #{username}")
    UserEntity findUserByUsername(@Param("username") String username);

    @Select("SELECT * FROM users WHERE uuid = #{uuid}")
    UserEntity findUserByUuid(@Param("uuid") String uuid);

}

