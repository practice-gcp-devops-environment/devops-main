package org.example.devopsmain.common.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Enumeration;

@Component
public class RequestLoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 전체 URL 가져오기
        String fullUrl = request.getRequestURL().toString();
        String queryString = request.getQueryString();
        if (queryString != null) {
            fullUrl += "?" + queryString; // 쿼리스트링 추가
        }
        String method = request.getMethod();

        // 모든 헤더 가져오기
        Enumeration<String> headerNames = request.getHeaderNames();
        StringBuilder headerLog = new StringBuilder();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            headerLog.append(headerName).append(": ").append(request.getHeader(headerName)).append("\n");
        }

        System.out.println("[INCOMING REQUEST] " + method + " " + fullUrl);
        System.out.println("[HEADERS] \n" + headerLog);

        return true; // 요청 계속 진행
    }
}
