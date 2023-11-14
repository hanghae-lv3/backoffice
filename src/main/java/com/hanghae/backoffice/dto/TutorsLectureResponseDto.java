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
    private String name;
    private Long price;
    private String intro;
    private String category;
    private LocalDateTime regDate;
    private List<Lecture> lectures;

    public TutorsLectureResponseDto(Tutor tutor) {
        this.name = tutor.getName();
        this.lectures = tutor.getLectures();
    }
}
