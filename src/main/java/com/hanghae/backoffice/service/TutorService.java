package com.hanghae.backoffice.service;

import com.hanghae.backoffice.dto.RegistTutorRequestDto;
import com.hanghae.backoffice.dto.RegistTutorResponseDto;
import com.hanghae.backoffice.entity.Lecture;
import com.hanghae.backoffice.entity.Tutor;
import com.hanghae.backoffice.repository.TutorRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
}
