package com.hanghae.backoffice.filter;


import com.hanghae.backoffice.entity.Admin;
import com.hanghae.backoffice.entity.AdminRoleEnum;
import com.hanghae.backoffice.jwt.JwtUtil;
import com.hanghae.backoffice.repository.AdminRepository;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Slf4j(topic = "AuthFilter")
@Component
@Order(1)
public class AuthFilter implements Filter {

    private final AdminRepository adminRepository;
    private final JwtUtil jwtUtil;

    public AuthFilter(AdminRepository adminRepository, JwtUtil jwtUtil) {
        this.adminRepository = adminRepository;
        this.jwtUtil = jwtUtil;
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String url = httpServletRequest.getRequestURI();

        if (StringUtils.hasText(url) && (url.startsWith("/signup") || url.startsWith("/signin")))
        // if(url.startsWith("/signup") || url.startsWith("/signin") || url.startsWith("/swagger-ui/**") || url.startsWith("/") || url.startsWith("/v3/api-docs/**")) // swagger 버전
         {
            chain.doFilter(request, response);
        } else {
            String tokenValue = jwtUtil.getTokenFromRequest(httpServletRequest);

            if (StringUtils.hasText(tokenValue)) {
                String token = jwtUtil.substringToken(tokenValue);

                if (!jwtUtil.validateToken(token)) {
                    throw new IllegalArgumentException("Token Error");
                }

                Claims info = jwtUtil.getAdminInfoFromToken(token);

                Admin admin = adminRepository.findByEmail(info.getSubject()).orElseThrow(() ->
                    new NullPointerException("Not Found User")
                );

                if (StringUtils.hasText(url) && ((httpServletRequest.getMethod().equals("PUT")) || (httpServletRequest.getMethod().equals("DELETE"))) &&
                    (url.startsWith("/tutors/") || url.startsWith("/lectures/"))){
                    String authority = (String) info.get(JwtUtil.AUTHORIZATION_KEY);

                    if (!Objects.equals(authority, AdminRoleEnum.MANAGER.getAuthority())) {
                        throw new IllegalArgumentException("허가 되지 않은 사용자입니다.");
                    }
                }

                request.setAttribute("admin", admin);
                chain.doFilter(request, response);
            } else {
                throw new IllegalArgumentException("Not Found Token");
            }
        }
    }
}