package com.hanghae.backoffice.dto;

import com.hanghae.backoffice.entity.AdminDepartmentEnum;
import com.hanghae.backoffice.entity.AdminRoleEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequestDto {
    private String email;
    private String password;
    private AdminDepartmentEnum department;
    private boolean manager = false;
}
