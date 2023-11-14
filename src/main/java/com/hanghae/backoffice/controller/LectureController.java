package com.hanghae.backoffice.controller;


import com.hanghae.backoffice.dto.RegistLectureRequestDto;
import com.hanghae.backoffice.dto.RegistLectureResponseDto;
import com.hanghae.backoffice.entity.Lecture;
import com.hanghae.backoffice.jwt.JwtUtil;
import com.hanghae.backoffice.repository.LectureRepository;
import com.hanghae.backoffice.service.LectureService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController

@RequestMapping("/lecture")

public class LectureController {

    private final LectureService lectureService;



    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;

    }
    // 강의 등록


    @PostMapping
    public void registerLecture(@RequestBody RegistLectureRequestDto requestDto) {
        lectureService.registerLecture(requestDto);
    }

    @GetMapping
    public List<Lecture> getAllLectures() {
        return lectureService.getAllLectures();
    }
    @Secured("ROLE_MANAGER")
    @PutMapping("/{id}")
    public Long updateLecture(Long id, @RequestBody RegistLectureRequestDto requestDto) {
        return lectureService.updateLecture(id, requestDto);
    }
    @GetMapping("/{id}")
    public RegistLectureResponseDto getLectureById(@PathVariable Long id) {
        return lectureService.getLectureById(id);
    }

    @GetMapping("/category")
    public List<RegistLectureResponseDto> getLecturesByCategory(@RequestParam String category) {
        return lectureService.getLecturesByCategory(category);


    }
}
