package com.example.scheduledevelop.controller;

import com.example.scheduledevelop.dto.*;
import com.example.scheduledevelop.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    //속성
    private final UserService userService;


    //생성자
    public UserController(UserService userservice) {
        this.userService = userservice;
    }


    //기능

    // 회원 생성
    @PostMapping
    public UserSaveResponse saveuser(@RequestBody UserSaveRequest request) {
        UserSaveResponse response = userService.save(request);
        return response;
    }

    //회원 전체 조회
    @GetMapping
    public UserGetAllList findAll() {
        return userService.UserGetAllResponse();
    }

    //회원 단건 조회
    @GetMapping("/{id}")
    public UserGetResponse findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    //회원 수정
    @PutMapping("/{id}")
    public UserUpdateResponse update(@PathVariable Long id, @RequestBody UserSaveRequest request) {
        return userService.update(id, request);
    }

    //회원 삭제
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

}

