package com.jazs32045nbp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(title = "Jaz s32045 NBP",
                version = "1.0",
                description = "Service for checking rates of currency"),
        servers = {@Server(url = "http://localhost:8080",
                description = "Local server")}
)
@Configuration
public class CustomConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
