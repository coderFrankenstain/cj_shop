package com.cj.demo.dto;

import com.cj.demo.dao.CommentEntity;
import com.cj.demo.dao.UserEntity;

public class CommentsResponse {
    private UserEntity user;

    private CommentEntity comment;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public CommentEntity getComment() {
        return comment;
    }

    public void setComment(CommentEntity comment) {
        this.comment = comment;
    }



}
