package com.estudo.java.spring.CompaninVTR.Infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity
                .csrf(csrf -> csrf.disable())

                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )

                .authorizeHttpRequests(authorize -> authorize

                        // LOGIN LIVRE
                        .requestMatchers(HttpMethod.POST, "/api/auth/login").permitAll()

                        // PROFESSOR
                        .requestMatchers(HttpMethod.POST, "/alunos/criar").hasRole("PROFESSOR")
                        .requestMatchers(HttpMethod.POST, "/alunos/alterar").hasRole("PROFESSOR")

                        .requestMatchers(HttpMethod.POST, "/professores/criar").hasRole("PROFESSOR")
                        .requestMatchers(HttpMethod.POST, "/professores/alterar").hasRole("PROFESSOR")

                        .requestMatchers(HttpMethod.POST, "/diciplinas/criar").hasRole("PROFESSOR")
                        .requestMatchers(HttpMethod.POST, "/diciplinas/alterar").hasRole("PROFESSOR")

                        .requestMatchers(HttpMethod.GET, "/alunos").hasRole("PROFESSOR")
                        .requestMatchers(HttpMethod.GET, "/professores").hasRole("PROFESSOR")
                        .requestMatchers(HttpMethod.GET, "/diciplinas").hasRole("PROFESSOR")

                        // ALUNO
                        .requestMatchers(HttpMethod.GET, "/diciplinas").hasRole("ALUNO")
                        .requestMatchers(HttpMethod.GET, "/professores").hasRole("ALUNO")

                        // QUALQUER OUTRA REQUISIÇÃO
                        .anyRequest().authenticated()
                )

                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}