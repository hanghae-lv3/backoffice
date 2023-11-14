package com.hanghae.backoffice.dto;

import com.hanghae.backoffice.entity.Lecture;
import com.hanghae.backoffice.entity.Tutor;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RegistLectureResponseDto {
    private String name;
    private Long price;
    private String intro;
    private String category;
    private LocalDateTime regDate;
    private Tutor tutor;

    public RegistLectureResponseDto(Lecture lecture) {
        this.name = lecture.getName();
        this.price = lecture.getPrice();
        this.intro = lecture.getIntro();
        this.category = lecture.getCategory();
        this.regDate = lecture.getRegDate();
    }
}
