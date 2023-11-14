package com.hanghae.backoffice.dto;

import com.hanghae.backoffice.entity.Tutor;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class RegistLectureResponseDto {
    private String name;
    private Long price;
    private String intro;
    private String category;
    private LocalDateTime regDate;
    private Tutor tutor;
}
