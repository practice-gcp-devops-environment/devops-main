package org.example.devopsmain.common.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Collection;

@Component
public class ResponseLoggingInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(ResponseLoggingInterceptor.class);

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        // 응답 URI
        String responseUri = request.getRequestURL().toString();
        String method = request.getMethod();

        // 모든 응답 헤더 가져오기
        Collection<String> headerNames = response.getHeaderNames();
        StringBuilder headerLog = new StringBuilder();
        for (String headerName : headerNames) {
            headerLog.append(headerName).append(": ").append(response.getHeader(headerName)).append("\n");
        }

        System.out.println("[OUTBOUND RESPONSE] " + method + " " + responseUri);
        System.out.println("[HEADERS] \n" + headerLog);
        System.out.println("[STATUS] " + response.getStatus());
    }
}

