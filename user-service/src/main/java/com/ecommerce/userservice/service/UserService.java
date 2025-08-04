package com.ecommerce.userservice.service;



import com.ecommerce.userservice.dto.UserDto;

public interface UserService {
    UserDto getUserByUsername(String username);
}
