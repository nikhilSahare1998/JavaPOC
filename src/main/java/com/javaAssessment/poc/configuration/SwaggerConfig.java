package com.javaAssessment.poc.configuration;


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
                .apis(RequestHandlerSelectors.basePackage("com.javaAssessment.poc"))
                .paths(PathSelectors.ant("/api/**"))
                .build()
                .apiInfo(apiInfo());
    }

   /* private Predicate<String> postPaths() {
        return or(regex("/api/posts.*"), regex("/api/javainuse.*"));
    }*/

    private ApiInfo apiInfo() {
        Contact contact = new Contact("", "", "");

        return new ApiInfoBuilder()
                .title("POC")
                .description("")
                .version("")
                .contact(contact)
                .license("")
                .licenseUrl("")
                .build();
    }
}
