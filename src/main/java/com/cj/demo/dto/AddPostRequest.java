package com.cj.demo.dto;

import com.fasterxml.jackson.databind.JsonNode;

public class AddPostRequest  {

    private String post;
    private String userId;
    private JsonNode data;

    // getters and setters

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public JsonNode getData() {
        return data;
    }

    public void setData(JsonNode data) {
        this.data = data;
    }
}
