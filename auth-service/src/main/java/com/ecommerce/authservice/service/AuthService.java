package com.ecommerce.authservice.service;


import com.ecommerce.authservice.dto.AuthRequest;
import com.ecommerce.authservice.dto.AuthResponse;
import com.ecommerce.authservice.entity.User;
import com.ecommerce.authservice.repository.UserRepository;
import com.ecommerce.authservice.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    public AuthResponse generateToken(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String token = jwtUtil.generateToken(userDetails);
        return new AuthResponse(token);
    }
}
