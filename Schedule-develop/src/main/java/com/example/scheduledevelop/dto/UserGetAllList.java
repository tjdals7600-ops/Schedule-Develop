package com.example.scheduledevelop.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class UserGetAllList {

    //속성
    private List<UserGetAllResponse> userList;


    //생성자
    public UserGetAllList(List<UserGetAllResponse> userList) {
        this.userList = userList;
    }
}
