package com.hanghae.backoffice.dto;

import com.hanghae.backoffice.entity.Lecture;
import com.hanghae.backoffice.entity.Tutor;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RegistLectureResponseDto {
    private String title;
    private Integer price;
    private String category;
    private String intro;
    private String tutorName;



    public RegistLectureResponseDto(Lecture lecture) {
        this.title = lecture.getTitle();
        this.price = lecture.getPrice();
        this.category = lecture.getCategory();
        this.intro = lecture.getIntro();
        this.tutorName = lecture.getTutorName();
    }
}
