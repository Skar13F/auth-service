package com.example.authservice.services;

import com.example.authservice.common.dtos.TokenResponse;
import com.example.authservice.common.dtos.UserRequest;

public interface AuthService{
    TokenResponse createUser(UserRequest userRequest);
}
