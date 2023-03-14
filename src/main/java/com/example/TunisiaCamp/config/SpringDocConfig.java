//package com.example.TunisiaCamp.config;
//
//import io.swagger.v3.oas.annotations.info.Contact;
//import io.swagger.v3.oas.annotations.info.Info;
//import io.swagger.v3.oas.models.OpenAPI;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class SpringDocConfig {
//    @Bean
//    public OpenAPI springShopOpenAPI() {
//        return new OpenAPI().info(infoAPI());
//    }
//    public Info infoAPI() {
//        return new Info().title("SpringDoc-Demo")
//                .description("TP étude de cas")
//                .contact(contactAPI());
//    }
//    public Contact contactAPI() {
//        Contact contact = new Contact().name("Equipe ASI II")
//                        .email("*************@esprit.tn")
//                .url("https://www.linkedin.com/in/**********/");
//        return contact;
//    }