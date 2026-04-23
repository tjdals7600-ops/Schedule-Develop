package com.example.scheduledevelop.dto;

import lombok.Getter;

@Getter
public class UserGetResponse {

    private final String username;
    private final String email;

    public UserGetResponse(String username, String email) {
        this.username = username;
        this.email = email;
    }
}

