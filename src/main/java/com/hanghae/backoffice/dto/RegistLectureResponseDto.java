package com.hanghae.backoffice.dto;

import com.hanghae.backoffice.entity.Lecture;
import com.hanghae.backoffice.entity.Tutor;
import java.time.LocalDateTime;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data

public class RegistLectureResponseDto {
    private String title;
    private Integer price;
    private String category;

    private LocalDateTime regDate;
    private Tutor tutor;

    public RegistLectureResponseDto(Lecture lecture) {
        this.name = lecture.getName();
        this.intro = lecture.getIntro();
        this.category = lecture.getCategory();
        this.price = lecture.getPrice();
        this.regDate = lecture.getRegDate();

    }
}
