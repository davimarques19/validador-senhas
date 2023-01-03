package com.validacao.senha.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Davi Estudos - Validador de senhas")
                .description("O objetivo deste projeto é desenvolver uma funcionalidade que valide senhas.")
                .version("1.0")
                .termsOfServiceUrl("https://github.com/davimarques19")
                .contact(
                        new Contact("Davi Marques", "https://github.com/davimarques19", "daviestudos19@gmail.com")
                )
                .license("License of API")
                .licenseUrl("https://github.com/davimarques19")
                .build();
    }

}

