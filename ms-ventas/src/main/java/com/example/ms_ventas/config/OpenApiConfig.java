package com.example.ms_ventas.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gestión de Ventas - ModelToys")
                        .version("1.0.0")
                        .description("Documentación interactiva del microservicio de ventas integrado con AWS RDS.")
                        .contact(new Contact()
                                .name("Equipo de Desarrollo ModelToys")
                                .email("soporte@modeltoys.cl")));
    }
}