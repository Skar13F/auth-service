package com.example.authservice.controllers;

import com.example.authservice.common.dtos.TokenResponse;
import com.example.authservice.common.dtos.UserRequest;
import com.example.authservice.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController implements AuthApi{
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public ResponseEntity<TokenResponse> createUser(UserRequest userRequest){
        return ResponseEntity.ok(authService.createUser(userRequest));
    }
}
