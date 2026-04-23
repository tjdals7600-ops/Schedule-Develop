package com.example.scheduledevelop.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleSaveResponse {
    private final Long id;
    private final String author;
    private final String title;
    private final String content;


    public ScheduleSaveResponse(Long id, String author, String title, String content) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;

    }
}
