package com.hanghae.backoffice.entity;

import com.hanghae.backoffice.dto.SignUpRequestDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "admin")
@NoArgsConstructor

public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private AdminDepartmentEnum department;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private AdminRoleEnum role;

    public Admin(SignUpRequestDto requestDto) { }

    public Admin(String email, String password, AdminDepartmentEnum department,
        AdminRoleEnum role) {
        this.email = email;
        this.password = password;
        this.department = department;
        this.role = role;
    }
}
