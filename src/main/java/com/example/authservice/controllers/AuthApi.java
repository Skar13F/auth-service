package com.example.authservice.controllers;

import com.example.authservice.common.constants.ApiPathConstants;
import com.example.authservice.common.dtos.TokenResponse;
import com.example.authservice.common.dtos.UserRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(ApiPathConstants.V1_ROUT + ApiPathConstants.AUTH_ROUT)
public interface AuthApi {
    @PostMapping("/register")
    ResponseEntity<TokenResponse> createUser(@RequestBody @Valid UserRequest userRequest);
}
