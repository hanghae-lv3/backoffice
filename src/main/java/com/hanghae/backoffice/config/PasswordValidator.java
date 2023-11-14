package com.hanghae.backoffice.config;

public class PasswordValidator {

    private static final String PASSWORD_PATTERN = "^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$";

    public static boolean validate(String password) {
        return password.matches(PASSWORD_PATTERN);
    }
}

