package com.ecommerce.userservice.controller;


import com.ecommerce.userservice.dto.UserDto;
import com.ecommerce.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // For inter-service call to get user details by username
    @GetMapping("/username/{username}")
    public UserDto getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    // Sample secured endpoint to test JWT
    @GetMapping("/test")
    public String securedMessage() {
        return "Access granted to secured User Service endpoint";
    }
}
