package com.api.combodigital.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfo(
                "Combo Digital",
                "Descripción",
                "1.0",
                "https://giorman.github.io/combodigital-frontend/",
                new Contact("Giorman Rodriguez", "https://github.com/giorman", "giormanrodriguez96@gmail.com"),
                "Licencia",
                "https://giorman.github.io/combodigital-frontend/",
                Collections.emptyList()
        );
    }
}
