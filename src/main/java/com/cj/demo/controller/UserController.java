package com.cj.demo.controller;

import com.cj.demo.dao.UserEntity;
import com.cj.demo.dto.LoginRequest;
import com.cj.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author aomei
 */
@RestController
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping(value = "getUser")
    public UserEntity getUser(Integer id) {
        return userService.getUserById(id);
    }


    @PostMapping(value="login")
    public ResponseEntity<UserEntity> login(@RequestBody LoginRequest loginRequest) {
        UserEntity result = userService.loginByName(loginRequest.getUsername(), loginRequest.getPassword());
        if (result == null) {
            return ResponseEntity.status(500).build();
        } else {
            return ResponseEntity.ok(result);
        }
    }

    @PostMapping(value="register")
    public UserEntity register(@RequestBody LoginRequest loginRequest) {
        return userService.register(loginRequest.getUsername(), loginRequest.getPassword());
    }
}


