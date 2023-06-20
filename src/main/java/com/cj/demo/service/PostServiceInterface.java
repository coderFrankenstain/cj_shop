package com.cj.demo.service;


import com.cj.demo.dao.PostEntity;

import java.util.List;

/**
 * @author aomei
 */
public interface PostServiceInterface {
    /**
     * 向posts表提交数据
     *
     * @param post 推文
     * @param userId 用户id
     * @param data 商品数据
     * @return boolean 操作成功返回true，失败返回false
     */
    boolean savePost(String post,String userId, String data);

    /**
     * 获取所有的帖子
     *
     * @return List<PostEntity> 包含所有帖子的列表
     */
    List<PostEntity> getAllPosts();
}
