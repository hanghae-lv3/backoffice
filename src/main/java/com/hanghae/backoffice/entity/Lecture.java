package com.hanghae.backoffice.entity;

import com.hanghae.backoffice.dto.RegistLectureRequestDto;
import jakarta.persistence.*;

import java.time.LocalDateTime;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Data
@Entity
@Table(name = "lecture")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Integer price;
    private String intro;
    private String category;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime regDate;

    @ManyToOne
    private Tutor tutor;

    public void update(RegistLectureRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.price = requestDto.getPrice();
        this.intro = requestDto.getIntro();
        this.category = requestDto.getCategory();
    }

}
