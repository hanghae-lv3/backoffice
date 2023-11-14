package com.hanghae.backoffice.dto;

import com.hanghae.backoffice.entity.Lecture;
import com.hanghae.backoffice.entity.Tutor;
import java.time.LocalDateTime;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistLectureResponseDto {
    private String title;
    private Integer price;
    private String category;
    private String intro;
    private LocalDateTime regDate;
    private Tutor tutor;

    public RegistLectureResponseDto(Lecture lecture) {
        this.title = lecture.getTitle();
        this.intro = lecture.getIntro();
        this.category = lecture.getCategory();
        this.price = lecture.getPrice();
        this.regDate = lecture.getRegDate();
    }
}
