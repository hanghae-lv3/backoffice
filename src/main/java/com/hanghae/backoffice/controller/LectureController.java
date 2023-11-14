package com.hanghae.backoffice.controller;


import com.hanghae.backoffice.dto.LectureUpdateResponseDto;
import com.hanghae.backoffice.dto.RegistLectureRequestDto;
import com.hanghae.backoffice.dto.RegistLectureResponseDto;
import com.hanghae.backoffice.dto.TutorsLectureResponseDto;
import com.hanghae.backoffice.entity.Lecture;
import com.hanghae.backoffice.service.LectureService;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController

public class LectureController {

    private final LectureService lectureService;



    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;

    }
    // 강의 등록


    @PostMapping("/lectures")
    public ResponseEntity<String> registerLecture(@RequestBody RegistLectureRequestDto requestDto) {
        String successMessage = lectureService.registerLecture(requestDto);

        return ResponseEntity.status(HttpStatus.CREATED)
            .header(
                HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE + ";charset=" + StandardCharsets.UTF_8)
            .body(successMessage);

    }

    @GetMapping("/lectures")
    public List<Lecture> getAllLectures() {
        return lectureService.getAllLectures();
    }

    @PutMapping("/lectures/{id}")
    public LectureUpdateResponseDto updateLecture(@PathVariable Long id, @RequestBody RegistLectureRequestDto requestDto) {
        return lectureService.updateLecture(id, requestDto);
    }
    @GetMapping("/lectures/{id}")
    public RegistLectureResponseDto getLectureById(@PathVariable Long id) {
        return lectureService.getLectureById(id);
    }

    @GetMapping("/lectures/category")
    public List<RegistLectureResponseDto> getLecturesByCategory(@RequestParam String category) {
        return lectureService.getLecturesByCategory(category);
    }

    @GetMapping("/lectures/{tutorsId}/lecture")
    public ResponseEntity<List<TutorsLectureResponseDto>> getTutorsLecture(@PathVariable Long tutorsId) {
        return new ResponseEntity<>(lectureService.getTutorsLecture(tutorsId), HttpStatus.OK);
    }

    @DeleteMapping("/lectures/{id}")
    public Long deleteLecture(@PathVariable Long id) {
        return lectureService.deleteLecture(id);
    }
}
