package com.example.scheduledevelop.entity;

import com.example.scheduledevelop.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//엔티티 -> 테이블을 표현하는 클래스

@Entity  // 엔티티 지정
@Getter
@Setter
@Table(name = "schedules")  // 테이블 이름은 schedules
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule extends BaseEntity {   //baseentity 클래스를 상속

    //속성
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String title;
    private String content;

    //생성자
    public Schedule(String author, String title, String content) {
        this.author = author;
        this.title = title;
        this.content = content;
    }

}
