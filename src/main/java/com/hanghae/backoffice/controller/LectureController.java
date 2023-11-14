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


    private final LectureService lectureService;
    private final JwtUtil jwtUtil;
    private final LectureRepository lectureRepository;


    public LectureController(LectureService lectureService, JwtUtil jwtUtil, LectureRepository lectureRepository) {
        this.lectureService = lectureService;
        this.jwtUtil = jwtUtil;
        this.lectureRepository = lectureRepository;
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
    @DeleteMapping("/{id}")
    public Long deleteLecture(@PathVariable Long id) {
        return lectureService.deleteLecture(id);
    }
}
