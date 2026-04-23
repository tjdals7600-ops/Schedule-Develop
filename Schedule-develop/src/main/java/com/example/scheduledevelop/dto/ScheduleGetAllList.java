package com.example.scheduledevelop.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class ScheduleGetAllList {

    //속성
    private List<ScheduleGetAllResponse> scheduleList;


    //생성자
    public ScheduleGetAllList(List<ScheduleGetAllResponse> scheduleList) {
        this.scheduleList = scheduleList;
    }
}
