package com.hanghae.backoffice.entity;

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

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_id")
    private List<Lecture> lectureList = new ArrayList<>();

    public Tutor(RegistTutorRequestDto registTutorRequestDto) {
        this.name = registTutorRequestDto.getName();
        this.career = registTutorRequestDto.getCareer();
        this.company = registTutorRequestDto.getCompany();
        this.phone = registTutorRequestDto.getPhone();
        this.intro = registTutorRequestDto.getIntro();
    }
}
