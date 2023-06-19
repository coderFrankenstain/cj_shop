package com.cj.demo.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import lombok.Data;

@Data
@TableName("users")
public class UserEntity {
    /**
     * 用户id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户uuid
     */
    private String uuid;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;


}
