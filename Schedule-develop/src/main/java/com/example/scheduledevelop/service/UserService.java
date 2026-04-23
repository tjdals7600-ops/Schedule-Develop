package com.example.scheduledevelop.service;

import com.example.scheduledevelop.dto.*;
import com.example.scheduledevelop.entity.User;
import com.example.scheduledevelop.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    //속성
    private final UserRepository userRepository;


    //생성자
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    //기능

    // 회원 생성
    // 1. 컨트롤러에서 데이터 받아오기
    @Transactional
    public UserSaveResponse save(UserSaveRequest request) {

        // 2. 데이터 준비하기
        String newUsername = request.getUsername();
        String newEmail = request.getEmail();


        //3. 저장할 회원 만들기
        User user = new User(newUsername, newEmail);


        // 4. 회원 저장하고 저장된 회원정보 받기
        User saveUser = userRepository.save(user);

        // 5. 저장한 데이터 준비
        String saveUsername = saveUser.getUsername();
        String saveEmail = saveUser.getEmail();

        // 6. 응답 dto 만들기
        UserSaveResponse userSaveResponse = new UserSaveResponse(
                saveUsername,
                saveEmail
        );

        //7. 반환 하기
        return userSaveResponse;

    }
    // 유저 전체 조회
    //1. 회원 목록 조회
    @Transactional(readOnly = true)
    public UserGetAllList UserGetAllResponse() {
        List<User> userList = userRepository.findAll();


        // 2. 엔티티를 dto로 변환 (stream)
        List<UserGetAllResponse> userGetAllResponseList =
                userList.stream()
                        .map(user -> new UserGetAllResponse(
                                user.getUsername(),
                                user.getEmail()
                        ))
                        .toList();

        // 3. 외부 dto 만들기
        UserGetAllList getAllList = new UserGetAllList(userGetAllResponseList);

        //4 . 반환하기
        return getAllList;
    }

    // 회원 단건 조회
    // 1. 컨트롤러에서 데이터 받기
    @Transactional(readOnly = true)
    public UserGetResponse findById(Long id) {

        //2. db에서 아이디로 회원 조회
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("없는 회원 입니다"));

        // 3. 데이터 준비하기
        String username = user.getUsername();
        String email = user.getEmail();


        // 4. 응답 dto 만들기
        UserGetResponse userGetResponse = new UserGetResponse(
                username,
                email
        );
        // 5. 반환 하기
        return userGetResponse;
    }

    // 회원 수정
    @Transactional
    // 1. 컨트롤러에서 데이터 받아오기
    public UserUpdateResponse update(Long id, UserSaveRequest request) {

        //2. db에서 아이디로 회원 조회
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("없는 회원 입니다"));

        //3. 데이터 수정
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());


        //4. 수정한 데이터 저장하기
        User updateUser = userRepository.save(user);


        //5. 응답 dto
        UserUpdateResponse userUpdateResponse = new UserUpdateResponse(
                updateUser.getUsername(),
                updateUser.getEmail()
        );

        return userUpdateResponse;

    }

    //회원 삭제
    @Transactional
    // 1. db에서 회원 찾기
    public void delete(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("없는 회원 입니다"));

        //2. 삭제하기
        userRepository.delete(user);
      }

}
