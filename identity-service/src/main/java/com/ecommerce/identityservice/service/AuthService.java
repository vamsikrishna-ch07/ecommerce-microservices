package com.ecommerce.identityservice.service;

import com.ecommerce.identityservice.entity.UserCredential;
import com.ecommerce.identityservice.repository.UserCredentialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class AuthService {
    @Autowired
    private  UserCredentialRepository userCredentialRepository;
    @Autowired
    private  PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    public String saveUser(UserCredential credential) {
        credential.setPassword(passwordEncoder.encode(credential.getPassword()));
         userCredentialRepository.save(credential);
        return "User saved successfully";
    }

    public String GenerateToken(){

    }
}
