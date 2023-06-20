package com.cj.demo.service.impl;

import com.cj.demo.dao.PostEntity;
import com.cj.demo.dao.mapper.PostMapper;
import com.cj.demo.service.PostServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostServiceImpl implements PostServiceInterface {

    @Autowired
    private PostMapper postMapper;

    @Override
    public boolean savePost(String post, String userId, String data) {
        PostEntity postEntity = new PostEntity();
        postEntity.setUserId(userId);
        postEntity.setPost(post);
        postEntity.setData(data);

        int rows = postMapper.insert(postEntity);

        return rows > 0;
    }

    @Override
    public List<PostEntity> getAllPosts() {
        return postMapper.selectAll();
    }
}


