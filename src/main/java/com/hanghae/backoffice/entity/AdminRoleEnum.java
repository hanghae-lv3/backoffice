package com.hanghae.backoffice.entity;

import lombok.Getter;

@Getter
public enum AdminRoleEnum {
    MANAGER(Authority.MANAGER),  // 매니저 권한
    STAFF(Authority.STAFF);  // 스태프 권한

    private final String authority;

    AdminRoleEnum(String authority) {
        this.authority = authority;
    }

    public static class Authority {
        public static final String MANAGER = "ROLE_MANAGER";
        public static final String STAFF = "ROLE_STAFF";
    }
}