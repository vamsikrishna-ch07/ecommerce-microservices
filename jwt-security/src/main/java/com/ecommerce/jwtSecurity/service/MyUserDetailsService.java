package com.ecommerce.jwtSecurity.service;


import com.ecommerce.jwtSecurity.model.UserDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    // This should call User Service API or DB to fetch user details
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Dummy user, replace with real user fetching from User Service
        if ("user".equals(username)) {
            return org.springframework.security.core.userdetails.User
                    .withUsername("user")
                    .password("{noop}password") // Password should be encoded in real app
                    .roles("USER")
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
