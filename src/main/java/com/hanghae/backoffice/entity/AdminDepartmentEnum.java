package com.hanghae.backoffice.entity;

import lombok.Getter;

@Getter
public enum AdminDepartmentEnum {
    MARKETING(Department.MARKETING),  // 마케팅 부서
    DEVELOPMENT(Department.DEVELOPMENT),  // 개발 부서
    CURRICULUM(Department.CURRICULUM);  // 커리큘럼 부서

    private final String department;

    AdminDepartmentEnum(String department) {
        this.department = department;
    }

    public static class Department {
        public static final String MARKETING = "MARKETING";
        public static final String DEVELOPMENT = "DEVELOPMENT";
        public static final String CURRICULUM = "CURRICULUM";
    }
}
