package com.example.demo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();

        // Allow login page, static resources, and logout
        if (uri.startsWith("/login") || uri.startsWith("/css/") || uri.startsWith("/logout")) {
            return true;
        }

        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("loggedIn") != null) {
            return true; // logged in
        }

        // Not logged in → redirect to login
        response.sendRedirect("/login");
        return false;
    }
}
