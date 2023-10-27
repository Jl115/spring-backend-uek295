package com.example.uek295_backeend.auth;

import com.example.uek295_backeend.user.User;
import com.example.uek295_backeend.user.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * Filter for JWT (JSON Web Token) validation.
 * This filter checks for the presence of a valid JWT in the Authorization header of incoming requests.
 * If a valid JWT is found, it sets the authentication for the user.
 */
@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository userRepository;

    /**
     * Determines whether the filter should not be applied to a particular request.
     * In this case, the filter is not applied to paths that start with "/auth".
     *
     * @param request The incoming HTTP request.
     * @return True if the filter should not be applied, otherwise false.
     */
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return request.getRequestURI().startsWith("/auth");
    }

    /**
     * Applies the filter logic to incoming requests.
     * It checks for the presence of a JWT in the Authorization header, validates it,
     * and sets the authentication context for the user.
     *
     * @param request The incoming HTTP request.
     * @param response The HTTP response.
     * @param filterChain The filter chain to proceed with the next filter in the chain.
     * @throws ServletException If a servlet exception occurs.
     * @throws IOException If an I/O exception occurs.
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");
        if (authorization == null || !authorization.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        String jwt = authorization.substring("Bearer ".length());
        String userName = jwtService.getUserName(jwt);
        Optional<User> user = userRepository.findByName(userName);

        if (user.isPresent()) {
            List<GrantedAuthority> authorities = List.of(() -> user.get().getAdmin() ? "admin" : "user");
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userName, null, authorities);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }
}
