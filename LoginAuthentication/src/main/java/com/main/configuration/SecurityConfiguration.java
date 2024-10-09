package com.main.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {

//    @Bean
//    public SecurityFilterChain securityconfig(HttpSecurity http) throws Exception {
//        http.csrf().disable() // Disable CSRF (ensure you're using another mechanism like JWT if stateless)
//                .authorizeHttpRequests()
//                .requestMatchers("/signup").permitAll()
//                .and()
//                .authorizeHttpRequests().requestMatchers("")
//                .authenticated()
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Stateless session management, used typically for JWT
//                .and().httpBasic();
//                
//                return http.build();
//    }

    @Bean
    public PasswordEncoder secure() {
        return new BCryptPasswordEncoder();
    }
}
