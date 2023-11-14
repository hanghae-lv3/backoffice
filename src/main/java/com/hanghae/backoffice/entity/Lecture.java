package com.hanghae.backoffice.entity;

import com.hanghae.backoffice.dto.RegistLectureRequestDto;
import jakarta.persistence.*;

import java.time.LocalDateTime;

import java.util.Date;

import lombok.Data;

import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "lecture")
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Integer price;
    private String intro;
    private String category;
    @Column(name = "reg_date")
    private LocalDateTime regDate;

    @ManyToOne
    private Tutor tutor;

    public Lecture(RegistLectureRequestDto registLectureRequestDto) {
        this.title = registLectureRequestDto.getTitle();
        this.price = registLectureRequestDto.getPrice();
        this.intro = registLectureRequestDto.getIntro();
        this.category = registLectureRequestDto.getCategory();
//        this.tutor = registLectureRequestDto.getTutorName();
        this.regDate = registLectureRequestDto.getRegDate();
    }

    public void update(RegistLectureRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.price = requestDto.getPrice();
        this.intro = requestDto.getIntro();
        this.category = requestDto.getCategory();
    }

}
