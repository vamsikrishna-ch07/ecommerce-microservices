package com.flm.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.flm.entity.User;
import com.flm.model.AuthenticationRequest;
import com.flm.model.AuthenticationResponse;
import com.flm.model.RegisterRequest;
import com.flm.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private  final UserRepository userRepository;
    private  final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public void register(RegisterRequest registerRequest) {
       var user = User.builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(registerRequest.getRole())
                .build();
       userRepository.save(user);
        //var savedUser = userRepository.save(user);
        //String jwtToken = jwtService.generateToken(user);
        //return AuthenticationResponse.builder().accessToken(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        //FirstStep
            //We need to validate our request (validate whether password & username is correct)
            //Verify whether user present in the database
            //Which AuthenticationProvider -> DaoAuthenticationProvider (Inject)
            //We need to authenticate using authenticationManager injecting this authenticationProvider
        //SecondStep
            //Verify whether userName and password is correct => UserNamePasswordAuthenticationToken
            //Verify whether user present in db
            //generateToken
            //Return the token
        Authentication auth =  authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        if (auth.isAuthenticated()) {
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().accessToken(jwtToken).build();
        }
        throw new BadCredentialsException("Authentication is failed...");
    }
}

