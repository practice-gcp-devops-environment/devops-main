package org.example.devopsmain.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Value("${urls.domain_server}")
    private String domainServerURL;

    @Value("${urls.api_gateway_server}")
    private String apiGatewayServerURL;

    @Value("${urls.api_gateway_server2}")
    private String apiGatewayServer2URL;

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins(
                                domainServerURL,
                                apiGatewayServerURL,
                                apiGatewayServer2URL
                        ) // 허용할 도메인
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true); // 인증 정보 허용 (Authorization, Cookie 등)
            }
        };
    }
}