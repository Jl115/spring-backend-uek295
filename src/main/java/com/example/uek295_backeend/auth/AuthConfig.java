package com.example.uek295_backeend.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class AuthConfig {

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
                    authorizationManagerRequestMatcherRegistry.requestMatchers(new AntPathRequestMatcher("/api/auth/*")).permitAll();
                    authorizationManagerRequestMatcherRegistry.requestMatchers(new AntPathRequestMatcher("/api/persons")).hasAuthority("admin");
                    authorizationManagerRequestMatcherRegistry.requestMatchers(new AntPathRequestMatcher("/api/persons/*", HttpMethod.GET.name())).hasAnyAuthority("admin", "user");
                    authorizationManagerRequestMatcherRegistry.requestMatchers(new AntPathRequestMatcher("/api/persons/*", HttpMethod.DELETE.name())).hasAuthority("admin");
                    authorizationManagerRequestMatcherRegistry.anyRequest().authenticated();
                })
                .httpBasic(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .build();
    }

}
