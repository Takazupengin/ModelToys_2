package com.example.ms_catalogo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Catálogo de Productos - ModelToys")
                        .version("1.0.0")
                        .description("Documentación interactiva del catálogo de maquetas.")
                        .contact(new Contact()
                                .name("Equipo de Desarrollo ModelToys")
                                .email("soporte@modeltoys.cl")));
    }
}
