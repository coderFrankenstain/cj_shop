package com.cj.demo.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
@RestController
@RequestMapping("/api")
public class DataController {

    @GetMapping("/data")
    public ResponseEntity<JsonNode> getHomeData() {
        try {
            // 获取资源文件
            Resource resource = new ClassPathResource("data.json");
            InputStream inputStream = resource.getInputStream();

            // 解析JSON文件
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(inputStream);

            // 返回JSON数据
            return ResponseEntity.ok(jsonNode);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/accessories")
    public ResponseEntity<JsonNode> getAccessories() {
        try {
            // 获取资源文件
            Resource resource = new ClassPathResource("data.json");
            InputStream inputStream = resource.getInputStream();

            // 解析JSON文件
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(inputStream);

            // 返回JSON数据
            return ResponseEntity.ok(jsonNode.get("accessories"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/phone")
    public ResponseEntity<JsonNode> getPhone() {
        try {
            // 获取资源文件
            Resource resource = new ClassPathResource("data.json");
            InputStream inputStream = resource.getInputStream();

            // 解析JSON文件
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(inputStream);

            // 返回JSON数据
            return ResponseEntity.ok(jsonNode.get("phone"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/news")
    public ResponseEntity<JsonNode> getNews() {
        try {
            // 获取资源文件
            Resource resource = new ClassPathResource("data.json");
            InputStream inputStream = resource.getInputStream();

            // 解析JSON文件
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(inputStream);

            // 返回JSON数据
            return ResponseEntity.ok(jsonNode.get("news"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }
}