package com.hanghae.backoffice.service;

import com.hanghae.backoffice.dto.RegistTutorRequestDto;
import com.hanghae.backoffice.dto.RegistTutorResponseDto;
import com.hanghae.backoffice.entity.Tutor;
import com.hanghae.backoffice.repository.TutorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        Optional<Tutor> tutor = tutorRepository.findById(id);
        if(tutor.isPresent()){
            return new RegistTutorResponseDto(tutor.get());
        }
        throw new EntityNotFoundException("등록되지 않은 강사입니다.");
    }

}
