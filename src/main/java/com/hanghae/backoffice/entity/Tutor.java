package com.hanghae.backoffice.entity;

import com.hanghae.backoffice.dto.RegistLectureResponseDto;
import com.hanghae.backoffice.dto.RegistTutorRequestDto;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tutor")
@NoArgsConstructor
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer career;
    private String company;
    private String phone;
    private String intro;

    @OneToMany(mappedBy="tutor", orphanRemoval = true)
    private List<Lecture> lectureList = new ArrayList<>();


    public Tutor(RegistTutorRequestDto registTutorRequestDto) {
        this.name = registTutorRequestDto.getName();
        this.career = registTutorRequestDto.getCareer();
        this.company = registTutorRequestDto.getCompany();
        this.phone = registTutorRequestDto.getPhone();
        this.intro = registTutorRequestDto.getIntro();
    }

    public void update(RegistTutorRequestDto registTutorRequestDto) {
        this.career = registTutorRequestDto.getCareer();
        this.company = registTutorRequestDto.getCompany();
        this.phone = registTutorRequestDto.getPhone();
        this.intro = registTutorRequestDto.getIntro();
    }

    public List<Lecture> getLectures() {
        return lectureList;
    }
}
