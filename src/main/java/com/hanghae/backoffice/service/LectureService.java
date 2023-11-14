package com.hanghae.backoffice.service;

import com.hanghae.backoffice.dto.RegistLectureResponseDto;
import com.hanghae.backoffice.repository.LectureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectureService {
    private final LectureRepository lectureRepository;


    public LectureService(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    public List<RegistLectureResponseDto> getTutorsLecture(Long tutorsId) {
        return lectureRepository.findAllByTutorIDOrderByRegDateDesc(tutorsId).stream().map(RegistLectureResponseDto::new).toList();

    }
}
