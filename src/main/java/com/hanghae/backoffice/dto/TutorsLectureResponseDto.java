package com.hanghae.backoffice.dto;

import com.hanghae.backoffice.entity.Lecture;
import com.hanghae.backoffice.entity.Tutor;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TutorsLectureResponseDto {
    private String title;
    private Integer price;
    private String intro;
    private String category;
    private LocalDateTime regDate;

    public TutorsLectureResponseDto(Lecture lecture) {
        this.title = lecture.getTitle();
        this.price = lecture.getPrice();
        this.intro = lecture.getIntro();
        this.category = lecture.getCategory();
        this.regDate = lecture.getRegDate();
    }
}
