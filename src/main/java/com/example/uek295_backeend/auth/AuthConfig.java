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

/**
 * Configuration class for authentication and authorization.
 * It sets up the JWT filter and defines access permissions for various API endpoints.
 */
@Configuration
public class AuthConfig {

    @Autowired
    private JwtFilter jwtFilter;

    /**
     * Defines the security filter chain for the application.
     * It adds the JWT filter and specifies access rights for different API paths.
     *
     * @param httpSecurity The HttpSecurity object to configure.
     * @return The configured SecurityFilterChain.
     * @throws Exception if an error occurs during configuration.
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)  // Add the JWT filter
                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
                    // Define access permissions for various API paths
                    authorizationManagerRequestMatcherRegistry
                            .requestMatchers(new AntPathRequestMatcher("/api/auth/*")).permitAll()
                            .requestMatchers(new AntPathRequestMatcher("/v3/api-docs")).permitAll()
                            .requestMatchers(new AntPathRequestMatcher("/api/categories/**")).permitAll()
                            .requestMatchers(new AntPathRequestMatcher("/api/products/**")).permitAll()
                            .requestMatchers(new AntPathRequestMatcher("/api/user/**")).permitAll()
                            .requestMatchers(new AntPathRequestMatcher("/swagger-ui/*")).permitAll()
                            .requestMatchers(new AntPathRequestMatcher("/v3/api-docs/swagger-config")).permitAll()
                            .requestMatchers(new AntPathRequestMatcher("/api/persons")).hasAuthority("admin");
                    authorizationManagerRequestMatcherRegistry.requestMatchers(new AntPathRequestMatcher("/api/persons/*", HttpMethod.GET.name())).hasAnyAuthority("admin", "user");
                    authorizationManagerRequestMatcherRegistry.requestMatchers(new AntPathRequestMatcher("/api/persons/*", HttpMethod.DELETE.name())).hasAuthority("admin");
                    authorizationManagerRequestMatcherRegistry.anyRequest().authenticated();  // All other requests require authentication
                })
                .httpBasic(AbstractHttpConfigurer::disable)  // Disable basic authentication
                .csrf(AbstractHttpConfigurer::disable)  // Disable CSRF protection
                .build();
    }
}
