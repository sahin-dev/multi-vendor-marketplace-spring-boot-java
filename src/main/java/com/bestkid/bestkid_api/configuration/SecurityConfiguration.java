package com.bestkid.bestkid_api.configuration;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.bestkid.bestkid_api.security.CustomAuthProvider;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private final CustomAuthProvider customAuthProvider;

    public SecurityConfiguration(CustomAuthProvider customAuthProvider) {
        this.customAuthProvider = customAuthProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return new ProviderManager(List.of(customAuthProvider));
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.
        csrf(csrf -> csrf.disable())
        .sessionManagement(session -> session.disable())
        .authorizeHttpRequests(auth -> auth.requestMatchers("/").permitAll())
        .authorizeHttpRequests(auth -> auth.anyRequest().authenticated()).formLogin(form -> {});

        return http.build();
    }
    
}
