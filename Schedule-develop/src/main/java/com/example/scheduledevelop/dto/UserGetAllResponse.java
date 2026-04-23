package com.example.scheduledevelop.dto;

import lombok.Getter;

@Getter
public class UserGetAllResponse {

    private final String username;
    private final String email;

    public UserGetAllResponse(String username, String email) {
        this.username = username;
        this.email = email;
    }
}

