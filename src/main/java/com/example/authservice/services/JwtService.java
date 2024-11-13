package com.example.authservice.services;

import com.example.authservice.common.dtos.TokenResponse;
import io.jsonwebtoken.Claims;

public interface JwtService {
    TokenResponse generateToken(Long userId);

    TokenResponse validateToken(String token);

    Claims getClaimsFromToken(String token);

    Boolean isTokenExpired(String token);

    Integer getUserIdFromToken(String token);
}
