package com.ecommerce.jwtSecurity.controller;


import com.ecommerce.jwtSecurity.model.JwtRequest;
import com.ecommerce.jwtSecurity.model.JwtResponse;
import com.ecommerce.jwtSecurity.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest) throws Exception {
        return ResponseEntity.ok(authService.authenticateAndGenerateToken(authRequest));
    }
}
