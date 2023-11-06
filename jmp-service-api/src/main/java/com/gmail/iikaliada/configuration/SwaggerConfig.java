package com.gmail.iikaliada.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi userApi() {
        return GroupedOpenApi.builder()
                .group("user-api")
                .pathsToMatch("/api/users/**")
                .build();
    }

    @Bean
    public GroupedOpenApi subscriptionApi() {
        return GroupedOpenApi.builder()
                .group("subscription-api")
                .pathsToMatch("/api/subscriptions/**")
                .build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("JMP Module Project")
                        .description("Provides API to manipulate data")
                        .contact(getContact())
                        .summary("Provides API to manipulate data")
                        .version("v1"));
    }

    private Contact getContact() {
        Contact contact = new Contact();
        contact.setEmail("iikaliada@gmail.com");
        contact.setName("Ivan Kaliada");
        return contact;
    }

}
