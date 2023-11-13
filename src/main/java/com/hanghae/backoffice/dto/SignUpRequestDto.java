package com.hanghae.backoffice.dto;

import lombok.Getter;

@Getter
public class SignUpRequestDto {
    private String email;
    private String password;
    private String department;
    private String role;
}
