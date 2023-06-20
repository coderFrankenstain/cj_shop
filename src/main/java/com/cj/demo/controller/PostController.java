package com.cj.demo.controller;

import com.cj.demo.dao.PostEntity;
import com.cj.demo.dao.UserEntity;
import com.cj.demo.dto.AddPostRequest;
import com.cj.demo.dto.ApiResponse;
import com.cj.demo.dto.PostResponse;
import com.cj.demo.service.impl.PostServiceImpl;
import com.cj.demo.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aomei
 */
@RestController
@RequestMapping(value = "/api")
public class PostController {

    @Autowired
    private PostServiceImpl postService;

    @Autowired
    private UserServiceImpl userService;

    @PostMapping(value="addPost")
    public ResponseEntity addPost(@RequestBody AddPostRequest request) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(request.getData());
            Boolean ok =  postService.savePost(request.getPost(),request.getUserId(),jsonString);
           if (ok) {
               return ResponseEntity.ok(new ApiResponse<String>(200,"成功"));
           } else {
               return ResponseEntity.status(500).build();
           }

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping(value="getPost")
    public  ResponseEntity<List<PostResponse>> getPost(){
        try {
            List<PostEntity> result = postService.getAllPosts();

            List<PostResponse> response =  new ArrayList<PostResponse>();

            for(int i = 0; i < result.size(); i++) {
                PostEntity entity = result.get(i);
                UserEntity user = userService.getUserByUuid(entity.getUserId());
                PostResponse pr = new PostResponse();
                pr.setUser(user);
                pr.setPost(entity);
                response.add(pr);
            }

            return ResponseEntity.ok(response);
        }catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }




}
