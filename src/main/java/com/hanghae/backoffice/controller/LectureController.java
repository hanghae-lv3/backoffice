package com.hanghae.backoffice.controller;

import com.hanghae.backoffice.dto.RegistLectureResponseDto;
import com.hanghae.backoffice.service.LectureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LectureController {
    private final LectureService lectureService;

    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @GetMapping("/lecture/{tutorsId}")
    public ResponseEntity<List<RegistLectureResponseDto>> getTutorsLecture(@PathVariable Long tutorsId) {
        return new ResponseEntity<>(lectureService.getTutorsLecture(tutorsId), HttpStatus.OK);
    }
}
