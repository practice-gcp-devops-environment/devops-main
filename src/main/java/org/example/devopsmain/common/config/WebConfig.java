package org.example.devopsmain.common.config;

import lombok.RequiredArgsConstructor;
import org.example.devopsmain.common.interceptor.RequestLoggingInterceptor;
import org.example.devopsmain.common.interceptor.ResponseLoggingInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final RequestLoggingInterceptor requestLoggingInterceptor;
    private final ResponseLoggingInterceptor responseLoggingInterceptor;

    public WebConfig(RequestLoggingInterceptor requestLoggingInterceptor, ResponseLoggingInterceptor responseLoggingInterceptor) {
        this.requestLoggingInterceptor = requestLoggingInterceptor;
        this.responseLoggingInterceptor = responseLoggingInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestLoggingInterceptor);
        registry.addInterceptor(responseLoggingInterceptor);
    }
}