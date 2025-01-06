package com.badabdd.beautysal00n;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")  // Dostęp do wszystkich endpointów
                        .allowedOrigins("*")  // Zezwolenie na dostęp z dowolnej domeny i portu
                        .allowedMethods("*")  // Zezwolenie na wszystkie metody (GET, POST, PUT, DELETE, itd.)
                        .allowedHeaders("*"); // Zezwolenie na wszystkie nagłówki
            }
        };
    }
}

