package org.example.devopsmain.common.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@OpenAPIDefinition
@Configuration
public class SwaggerConfig {
    @Value("${urls.domain_server}")
    private String domainServerURL;

    @Value("${urls.api_gateway_server}")
    private String apiGatewayServerURL;

    @Value("${urls.api_gateway_server2}")
    private String apiGatewayServer2URL;

    @Value("${urls.api_gateway_server3}")
    private String apiGatewayServer3URL;

    @Value("${urls.api_gateway_server4}")
    private String apiGatewayServer4URL;

    @Value("${urls.api_gateway_server5}")
    private String apiGatewayServer5URL;

    @Value("${urls.api_gateway_server6}")
    private String apiGatewayServer6URL;

    @Value("${urls.api_gateway_server7}")
    private String apiGatewayServer7URL;

    @Value("${urls.api_gateway_server8}")
    private String apiGatewayServer8URL;

    @Value("${urls.api_gateway_server9}")
    private String apiGatewayServer9URL;

    @Value("${urls.api_gateway_server10}")
    private String apiGatewayServer10URL;

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .servers(List.of(
                        new Server().url(domainServerURL),
                        new Server().url(apiGatewayServerURL),
                        new Server().url(apiGatewayServer2URL),
                        new Server().url(apiGatewayServer3URL),
                        new Server().url(apiGatewayServer4URL),
                        new Server().url(apiGatewayServer5URL),
                        new Server().url(apiGatewayServer6URL),
                        new Server().url(apiGatewayServer7URL),
                        new Server().url(apiGatewayServer8URL),
                        new Server().url(apiGatewayServer9URL),
                        new Server().url(apiGatewayServer10URL)
                ))
                .components(new Components().addSecuritySchemes("Bearer",
                        new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")))
                .addSecurityItem(new SecurityRequirement().addList("Bearer"))
                .info(new Info().title("✩ devops-main SWAGGER")
                        .description("API")
                        .version("v0.0.1"));
    }
}