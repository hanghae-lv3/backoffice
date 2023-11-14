package com.hanghae.backoffice.service;

import com.hanghae.backoffice.dto.RegistLectureResponseDto;
import com.hanghae.backoffice.dto.RegistTutorRequestDto;
import com.hanghae.backoffice.dto.RegistTutorResponseDto;
import com.hanghae.backoffice.dto.TutorsLectureResponseDto;
import com.hanghae.backoffice.entity.Tutor;
import com.hanghae.backoffice.repository.TutorRepository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TutorService {

    private final TutorRepository tutorRepository;

    public TutorService(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    public RegistTutorResponseDto createTutors(RegistTutorRequestDto registTutorRequestDto) {
        Tutor tutor = new Tutor(registTutorRequestDto);
        return new RegistTutorResponseDto(tutorRepository.save(tutor));
    }

    public RegistTutorResponseDto getTutors(Long id) {
        Tutor tutor = tutorRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("등록되지 않은 사용자입니다.")
                );
        return new RegistTutorResponseDto(tutor);
    }

    @Transactional
    public RegistTutorResponseDto updateTutors(Long id, RegistTutorRequestDto registTutorRequestDto ) {
        Tutor tutor = tutorRepository.findById(id).orElseThrow(() ->
            new IllegalArgumentException("등록되지 않은 사용자입니다.")
        );
        tutor.update(registTutorRequestDto);
        return new RegistTutorResponseDto(tutor);
    }

    public List<TutorsLectureResponseDto> getTutorsLecture(Long tutorsId) {
        return tutorRepository.findByIdOrderByLectureList_RegDateDesc(tutorsId).stream().map(TutorsLectureResponseDto::new).toList();
    }
}
