package com.hanghae.backoffice.service;

import com.hanghae.backoffice.config.PasswordValidator;
import com.hanghae.backoffice.dto.SignInRequestDto;
import com.hanghae.backoffice.dto.SignUpRequestDto;
import com.hanghae.backoffice.entity.Admin;
import com.hanghae.backoffice.entity.AdminDepartmentEnum;
import com.hanghae.backoffice.entity.AdminRoleEnum;
import com.hanghae.backoffice.jwt.JwtUtil;
import com.hanghae.backoffice.repository.AdminRepository;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    // DI
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    public AdminService(AdminRepository adminRepository, PasswordEncoder passwordEncoder,
        JwtUtil jwtUtil) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    // 회원 등록
    public String signUp(SignUpRequestDto requestDto) {
        String email = requestDto.getEmail();

        // 이메일 중복 확인
        Optional<Admin> checkEmail = adminRepository.findByEmail(email);
        if (checkEmail.isPresent()) {
            throw new IllegalArgumentException("중복된 Email 입니다.");
        }

        // 비밀번호 검증
        if (!PasswordValidator.validate(requestDto.getPassword())) {
            throw new IllegalArgumentException(
                "비밀번호는 최소 8자 이상, 15자 이하, 알파벳 대소문자, 숫자, 특수문자로 구성되어야 합니다."
            );
        }

        String password = passwordEncoder.encode(requestDto.getPassword());


        // MANAGER 권한 검증
        AdminRoleEnum role = AdminRoleEnum.STAFF;
        if (requestDto.isManager()) {
            if (AdminDepartmentEnum.MARKETING.equals(requestDto.getDepartment()) ) {
                throw new IllegalArgumentException("마케팅 부서는 매니저 권한을 얻을 수 없습니다.");
            }
            role = AdminRoleEnum.MANAGER;
        }

        Admin admin = new Admin(email, password, requestDto.getDepartment(), role);
        adminRepository.save(admin);

        return "가입에 성공하였습니다.";
    }

    public String signIn(SignInRequestDto requestDto, HttpServletResponse res) {
        String email = requestDto.getEmail();
        String password = requestDto.getPassword();

        Admin admin = adminRepository.findByEmail(email).orElseThrow(
            () -> new IllegalArgumentException("등록된 이메일이 없습니다.")
        );

        if(!passwordEncoder.matches(password, admin.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        String token = jwtUtil.createToken(admin.getEmail(), admin.getRole());
        jwtUtil.addJwtToCookie(token, res);

        return "로그인 성공";

    }
}



