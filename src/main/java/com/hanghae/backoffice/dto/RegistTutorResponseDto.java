package com.hanghae.backoffice.dto;

import com.hanghae.backoffice.entity.Tutor;
import lombok.Getter;

@Getter
public class RegistTutorResponseDto {
    private String name;
    private Integer career;
    private String company;
    private String phone;
    private String intro;

    public RegistTutorResponseDto(Tutor tutor) {
        this.name = tutor.getName();
        this.career = tutor.getCareer();
        this.company = tutor.getCompany();
        this.phone = tutor.getCompany();
        this.intro = tutor.getIntro();
    }
}
