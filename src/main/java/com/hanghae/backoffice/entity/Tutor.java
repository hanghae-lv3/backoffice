package com.hanghae.backoffice.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tutor")
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer career;
    private String company;
    private String phone;
    private String intro;

    @OneToMany
    @JoinColumn(name = "lecture_id")
    private List<Lecture> lectureList = new ArrayList<>();
}
