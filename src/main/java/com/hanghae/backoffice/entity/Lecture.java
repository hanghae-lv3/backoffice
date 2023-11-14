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

    private String name;
    private Long price;
    private String intro;
    private String category;
    @Column(name = "reg_date")
    private LocalDateTime regDate;
    public Lecture(RegistLectureRequestDto registLectureRequestDto) {
        this.name = registLectureRequestDto.getName();
        this.price = registLectureRequestDto.getPrice();
        this.intro = registLectureRequestDto.getIntro();
        this.category = registLectureRequestDto.getCategory();
        this.regDate = registLectureRequestDto.getRegDate();
    }

    public void update(RegistLectureRequestDto requestDto) {
        this.name = requestDto.getName();
        this.price = requestDto.getPrice();
        this.intro = requestDto.getIntro();
        this.category = requestDto.getCategory();
    }
}
