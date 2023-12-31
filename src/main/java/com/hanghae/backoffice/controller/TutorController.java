package com.hanghae.backoffice.controller;

import com.hanghae.backoffice.dto.RegistLectureResponseDto;
import com.hanghae.backoffice.dto.RegistTutorRequestDto;
import com.hanghae.backoffice.dto.RegistTutorResponseDto;
import com.hanghae.backoffice.dto.TutorsLectureResponseDto;
import com.hanghae.backoffice.service.TutorService;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
public class TutorController {
    private final TutorService tutorService;

    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @PostMapping("/tutors")
    public ResponseEntity<RegistTutorResponseDto> createTutors(@RequestBody RegistTutorRequestDto registTutorRequestDto) {
        return new ResponseEntity<>(tutorService.createTutors(registTutorRequestDto), HttpStatus.OK);
    }

    @GetMapping("/tutors/{id}")
    public ResponseEntity<RegistTutorResponseDto> getTutors(@PathVariable Long id) {
        return new ResponseEntity<>(tutorService.getTutors(id), HttpStatus.OK);
    }

    @PutMapping("/tutors/{id}")
    public ResponseEntity<RegistTutorResponseDto> updateTutors(@PathVariable Long id, @RequestBody RegistTutorRequestDto registTutorRequestDto) {
        return new ResponseEntity<>(tutorService.updateTutors(id, registTutorRequestDto), HttpStatus.OK);
    }
    @DeleteMapping("/tutors/{id}")
    public ResponseEntity<String> deleteTutors(@PathVariable Long id) {
        String successMessage = tutorService.deleteTutors(id);
        return ResponseEntity.status(HttpStatus.CREATED)
            .header(
                HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE + ";charset=" + StandardCharsets.UTF_8)
            .body(successMessage);
    }


}
