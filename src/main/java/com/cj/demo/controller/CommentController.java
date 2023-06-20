package com.cj.demo.controller;

import com.cj.demo.dao.CommentEntity;
import com.cj.demo.dao.UserEntity;
import com.cj.demo.dto.AddCommentRequest;
import com.cj.demo.dto.ApiResponse;
import com.cj.demo.dto.CommentsResponse;
import com.cj.demo.service.impl.CommentServiceImpl;
import com.cj.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class CommentController {

    @Autowired
    private CommentServiceImpl commentService;

    @Autowired
    private UserServiceImpl userService;
    @PostMapping(value="addComment")
    public ResponseEntity addPost(@RequestBody AddCommentRequest request) {
        try {
            Boolean ok =  commentService.saveComment(request.getPostId(),request.getUserId(), request.getContent());
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
    @GetMapping(value="getComments")
    public ResponseEntity<List<CommentsResponse>> addPost(String postId) {
        try {
            List<CommentEntity> comments =  commentService.getCommentsByPostId(postId);

            List<CommentsResponse> response =  new ArrayList<CommentsResponse>();

            for(CommentEntity comment : comments) {
                CommentsResponse pr = new CommentsResponse();
                UserEntity user =  userService.getUserByUuid(comment.getUserId());
                pr.setUser(user);
                pr.setComment(comment);
                response.add(pr);
            }

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }

}
