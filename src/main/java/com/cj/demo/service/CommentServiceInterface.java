package com.cj.demo.service;

import com.cj.demo.dao.CommentEntity;

import java.util.List;

public interface CommentServiceInterface {
    List<CommentEntity> getCommentsByPostId(String postId);

    public boolean saveComment(String postId, String userId, String content);
}
