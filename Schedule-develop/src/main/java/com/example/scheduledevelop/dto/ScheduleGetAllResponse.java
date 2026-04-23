package com.example.scheduledevelop.dto;

import lombok.Getter;

@Getter
public class ScheduleGetAllResponse {

    private final Long id;
    private final String author;
    private final String title;
    private final String content;


    public ScheduleGetAllResponse(Long id, String author, String title, String content) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
    }


}
