package com.project.smartbuidingapp.CorsConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {


    @Bean
    public WebMvcConfigurer getCorsInformation(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {

                registry.addMapping("/**")
                .allowedOrigins("http://localhost:8080")
                        .allowedMethods("GET","POST","PUT","DELETE")
                        .allowedHeaders("*");


            }
        };
    }
}
