/**
 * 
 */
package com.providus.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author SUMIT VERMA
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("com.providus.controller"))
                .paths(PathSelectors.regex("/.*"))
                .build();
    }
    
    @Bean
    public ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("Providus Order Management REST API")
            .description("Providus Order Management REST API")
            .contact(new springfox.documentation.service.Contact("Sumit Verma", "https://www.linkedin.com/in/vsumit/", "vsumit42@gmail.com"))
            .version("1.0.0")
            .build();
    }
}
