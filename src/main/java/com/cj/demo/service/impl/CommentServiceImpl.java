package com.cj.demo.service.impl;

import com.cj.demo.dao.CommentEntity;
import com.cj.demo.dao.mapper.CommentMapper;
import com.cj.demo.service.CommentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceImpl implements CommentServiceInterface {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<CommentEntity> getCommentsByPostId(String postId) {
        return commentMapper.findCommentsByPostId(postId);
    }

    @Override
    public boolean saveComment(String postId, String userId, String content) {
        CommentEntity postEntity = new CommentEntity();
        postEntity.setUserId(userId);
        postEntity.setPostId(postId);
        postEntity.setContent(content);

        int rows = commentMapper.insert(postEntity);

        return rows > 0;
    }
}
