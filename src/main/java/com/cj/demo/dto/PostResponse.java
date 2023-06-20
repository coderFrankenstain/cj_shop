package com.cj.demo.dto;

import com.cj.demo.dao.PostEntity;
import com.cj.demo.dao.UserEntity;

public class PostResponse {
    private PostEntity post;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    private UserEntity user;

    public PostEntity getPost() {
        return post;
    }

    public void setPost(PostEntity post) {
        this.post = post;
    }
}