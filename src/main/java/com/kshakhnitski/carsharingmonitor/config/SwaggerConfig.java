package com.kshakhnitski.carsharingmonitor.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Car Sharing Monitor API",
                version = "1.0",
                description = "System for tracking car sharing cars"
        )
)
public class SwaggerConfig {
}
