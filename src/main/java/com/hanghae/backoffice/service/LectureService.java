package com.hanghae.backoffice.service;


import com.hanghae.backoffice.dto.RegistLectureRequestDto;
import com.hanghae.backoffice.dto.RegistLectureResponseDto;
import com.hanghae.backoffice.entity.Lecture;
import com.hanghae.backoffice.entity.Tutor;
import com.hanghae.backoffice.repository.LectureRepository;
import com.hanghae.backoffice.repository.TutorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class LectureService {
    private final LectureRepository lectureRepository;
    private final TutorRepository tutorRepository;

    public LectureService(LectureRepository lectureRepository, TutorRepository tutorRepository) {
        this.lectureRepository = lectureRepository;
        this.tutorRepository = tutorRepository;
    }


    public void registerLecture(RegistLectureRequestDto requestDto) {
        Lecture lecture = new Lecture(requestDto);
        lectureRepository.save(lecture);
    }
    public List<Lecture> getAllLectures() {
        return lectureRepository.findAll();
    }
    public Long updateLecture(Long id, RegistLectureRequestDto requestDto) {
        // 매니저 권한 확인

        // 해당 강의가 DB에 있는지 확인
        Lecture lecture = findLecture(id);
        lecture.update(requestDto);
        return id;
    }
    private Lecture findLecture(Long id) {
        return lectureRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 강의는 없습니다")
        );
    }

    public RegistLectureResponseDto getLectureById(Long id) {
        Lecture lecture = findLecture(id);
        return new RegistLectureResponseDto(lecture);
    }

    public List<RegistLectureResponseDto> getLecturesByCategory(String category) {
        // 강의 조회 및 등록일 기준으로 내림차순 정렬
        List<Lecture> lectures = lectureRepository.findByCategoryOrderByRegDateDesc(category);
        return lectures.stream()
                .map(lecture -> {
                    RegistLectureResponseDto responseDto = new RegistLectureResponseDto(lecture);
                    BeanUtils.copyProperties(lecture, responseDto);

                    return responseDto;
                })
                .collect(Collectors.toList());
    }

    public Long deleteLecture(Long id) {
        Lecture lecture = findLecture(id);
        lectureRepository.delete(lecture);
        return id;
    }
}
