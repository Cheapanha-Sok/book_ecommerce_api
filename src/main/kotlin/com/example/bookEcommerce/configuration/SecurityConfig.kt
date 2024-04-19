package com.example.bookEcommerce.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    @Throws(Exception::class)
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .cors(Customizer.withDefaults())
            .authorizeHttpRequests {
                it.requestMatchers(
                    "/api/v1/auth/**",
                    "/v2/api-docs",
                    "/v3/api-docs",
                    "/v3/api-docs/**",
                    "/swagger-resources",
                    "/swagger-resources/**",
                    "/configuration/ui",
                    "/configuration/security",
                    "swagger-ui/**",
                    "/webjars/**",
                    "/swagger-ui.html"
                )
                    .permitAll()
                    it.requestMatchers(HttpMethod.GET,"/api/v1/**").permitAll()
                    .anyRequest().authenticated()
            }
            .oauth2Login(Customizer.withDefaults())
        return http.build()
    }
}