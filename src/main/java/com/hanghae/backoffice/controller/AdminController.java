package com.hanghae.backoffice.controller;

import com.hanghae.backoffice.dto.SignInRequestDto;
import com.hanghae.backoffice.dto.SignUpRequestDto;
import com.hanghae.backoffice.jwt.JwtUtil;
import com.hanghae.backoffice.service.AdminService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import java.nio.charset.StandardCharsets;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    private final AdminService adminService;
    private final JwtUtil jwtUtil;
    public AdminController(AdminService adminService, JwtUtil jwtUtil) {
        this.adminService = adminService;
        this.jwtUtil = jwtUtil;
    }



    // 관리자 등록
    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody @Valid SignUpRequestDto requestDto) {
        String successMessage = adminService.signUp(requestDto);

        return ResponseEntity.status(HttpStatus.CREATED)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE + ";charset=" + StandardCharsets.UTF_8)
            .body(successMessage);
    }


    // 로그인
    @PostMapping("/signin")
    public ResponseEntity<String> signIn(@RequestBody @Valid SignInRequestDto requestDto, HttpServletResponse res) {
        try {
            String successMessage = adminService.signIn(requestDto, res);
            return ResponseEntity.status(HttpStatus.CREATED)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE + ";charset=" + StandardCharsets.UTF_8)
                .body(successMessage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
