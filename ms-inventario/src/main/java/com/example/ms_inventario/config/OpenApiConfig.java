package com.example.ms_inventario.config;

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
                        .title("API de ModelToys - Inventario")
                        .version("1.0.0") // Ponemos la versión estable 1.0.0 igual que en ventas
                        .description("Documentación interactiva de inventario.")
                        .contact(new Contact() // <-- Esto activa el import de la línea 5
                                .name("Equipo de Desarrollo ModelToys")
                                .email("soporte@modeltoys.cl"))); // <-- Aquí cierra bien el paréntesis y punto y coma
    }
}