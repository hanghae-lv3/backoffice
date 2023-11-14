package com.hanghae.backoffice.dto;

import com.hanghae.backoffice.entity.Tutor;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class RegistLectureRequestDto {
    private String title;
    private Integer price;
    private String intro;
    private String category;
    private Long tutorId;
}
