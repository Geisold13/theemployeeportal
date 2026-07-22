package com.the_employee_portal.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


        return http
                .csrf(csrf -> csrf.disable()) // disables the required csrf token for requests, otherwise would get 403 forbidden error.
        .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/**").permitAll() // temporarily permitting all requests from /api for initial code testing.
               // .requestMatchers("").authenticated() //
             //   .anyRequest().authenticated()
                .anyRequest().permitAll()

        )
                .build();
    }
}
