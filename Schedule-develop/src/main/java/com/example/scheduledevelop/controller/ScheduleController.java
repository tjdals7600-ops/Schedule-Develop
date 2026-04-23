package com.example.scheduledevelop.controller;
import com.example.scheduledevelop.dto.*;
import com.example.scheduledevelop.service.ScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//요청 연결 맵핑 어노테이션
//@PostMapping
//@GetMapping
//@PutMapping
//@PatchMapping
//@DeleteMapping
//@RequestMapping  = 클래스 연결!!!


@RestController   //빈으로 등록
@RequestMapping("/schedules")
public class ScheduleController {
    //속성  -> 컨트롤러가 서비스를 속성으로 가진다
    private final ScheduleService scheduleService;


    //생성자
    public ScheduleController(ScheduleService scheduleService){
        this.scheduleService = scheduleService;
    }

    //기능

    //일정 생성
    @PostMapping
    public ScheduleSaveResponse saveschedule(@RequestBody ScheduleSaveRequest request) {
        ScheduleSaveResponse response = scheduleService.save(request);
        return response;
    }

    //일정 전체 조회
    @GetMapping
    public ScheduleGetAllList findAll() {
        return scheduleService.ScheduleGetAllResponse();

    }

    //일정 단건 조회
    @GetMapping("/{id}")
    public ScheduleGetResponse findById(@PathVariable Long id) {
        return scheduleService.findById(id);
    }


    //일정 수정
    @PutMapping("/{id}")
    public ScheduleGetResponse update(@PathVariable Long id, @RequestBody ScheduleSaveRequest request) {
        return scheduleService.update(id, request);
    }


    //일정 삭제
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        scheduleService.delete(id);
    }










}
