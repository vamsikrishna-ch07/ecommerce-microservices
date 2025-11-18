//package com.ecommerce.userservice.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf(AbstractHttpConfigurer::disable) // Disable CSRF for testing (add custom config for production!)
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/users/register", "/users/findByUsername/**").permitAll()
//                        .anyRequest().authenticated()
//                );
//        return http.build();
//    }
//}
