package com.hanghae.backoffice.repository;

import com.hanghae.backoffice.dto.RegistLectureRequestDto;
import com.hanghae.backoffice.dto.RegistLectureResponseDto;
import com.hanghae.backoffice.entity.Lecture;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long> {


    List<Lecture> findByCategoryOrderByRegDateDesc(String category);

    Optional<Lecture> findByid(Long lectureId);
}
