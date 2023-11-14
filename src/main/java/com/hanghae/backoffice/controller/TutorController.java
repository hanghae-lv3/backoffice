package com.hanghae.backoffice.controller;

import com.hanghae.backoffice.dto.RegistTutorRequestDto;
import com.hanghae.backoffice.dto.RegistTutorResponseDto;
import com.hanghae.backoffice.entity.AdminRoleEnum;
import com.hanghae.backoffice.jwt.JwtUtil;
import com.hanghae.backoffice.service.TutorService;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TutorController {
    private final TutorService tutorService;
    private final JwtUtil jwtUtil;

    public TutorController(TutorService tutorService, JwtUtil jwtUtil) {
        this.tutorService = tutorService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/tutors")
    public ResponseEntity<RegistTutorResponseDto> createTutors(@RequestBody RegistTutorRequestDto registTutorRequestDto){
        return new ResponseEntity<>(tutorService.createTutors(registTutorRequestDto), HttpStatus.OK);
    }

}
