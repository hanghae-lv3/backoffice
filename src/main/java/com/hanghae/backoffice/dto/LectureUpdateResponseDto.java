package com.hanghae.backoffice.dto;

import com.hanghae.backoffice.entity.Lecture;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LectureUpdateResponseDto {

    private String title;
    private Integer price;
    private String category;
    private String intro;
    public LectureUpdateResponseDto(Lecture lecture) {
        this.title = lecture.getTitle();
        this.intro = lecture.getIntro();
        this.category = lecture.getCategory();
        this.price = lecture.getPrice();

    }
}
