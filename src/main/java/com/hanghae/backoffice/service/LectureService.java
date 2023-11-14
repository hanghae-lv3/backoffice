package com.hanghae.backoffice.service;


import com.hanghae.backoffice.dto.RegistLectureRequestDto;
import com.hanghae.backoffice.dto.RegistLectureResponseDto;
import com.hanghae.backoffice.dto.TutorsLectureResponseDto;
import com.hanghae.backoffice.entity.Lecture;
import com.hanghae.backoffice.entity.Tutor;
import com.hanghae.backoffice.repository.LectureRepository;
import com.hanghae.backoffice.repository.TutorRepository;
import java.util.Comparator;
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


    public String registerLecture(RegistLectureRequestDto requestDto) {
        Lecture lecture = new Lecture();
        Tutor tutor = findById(requestDto.getTutorId());
        lecture.setTitle(requestDto.getTitle());
        lecture.setPrice(requestDto.getPrice());
        lecture.setIntro(requestDto.getIntro());
        lecture.setCategory(requestDto.getCategory());
        lecture.setTutor(tutor);

        lectureRepository.save(lecture);

        return "강의가 등록되었습니다.";
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
        System.out.println(category);
        List<Lecture> lectures = lectureRepository.findByCategoryOrderByRegDateDesc(category);
        return lectures.stream()
                .map(RegistLectureResponseDto::new)
                .collect(Collectors.toList());
    }

    public List<TutorsLectureResponseDto> getTutorsLecture(Long tutorsId) {
        Tutor tutor = tutorRepository.findById(tutorsId)
            .orElseThrow(() -> new IllegalArgumentException("강사가 존재하지 않습니다."));

        List<Lecture> lectureList = tutor.getLectureList();

        return lectureList.stream()
            .sorted(Comparator.comparing(Lecture::getRegDate).reversed())
            .map(TutorsLectureResponseDto::new)
            .collect(Collectors.toList());
    }


    private Tutor findById(Long tutorId) {
        return tutorRepository.findByid(tutorId).orElseThrow(() ->
            new IllegalArgumentException("존재하지 않는 강사입니다.")
        );
    }
}
