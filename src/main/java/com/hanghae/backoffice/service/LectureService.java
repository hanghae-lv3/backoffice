package com.hanghae.backoffice.service;

import com.hanghae.backoffice.dto.RegistLectureResponseDto;
import com.hanghae.backoffice.entity.Lecture;
import com.hanghae.backoffice.repository.LectureRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LectureService {
    private final LectureRepository lectureRepository;


    public LectureService(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    public List<RegistLectureResponseDto> getTutorsLecture(Long tutorsId) {
        return lectureRepository.findByTutor_TutorIdOrderByRegDateDesc(tutorsId).stream().map(RegistLectureResponseDto::new).toList();

    }
}
