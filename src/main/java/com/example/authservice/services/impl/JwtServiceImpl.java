package com.example.authservice.services.impl;

import com.example.authservice.common.dtos.TokenResponse;
import com.example.authservice.services.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.sql.Date;

@Service
public class JwtServiceImpl implements JwtService {
    private final String secretToken;

    public JwtServiceImpl(@Value("${jwt.secret}") String secretToken) {
        this.secretToken = secretToken;
    }

    @Override
    public TokenResponse generateToken(Long userId) {
        Date expirationDate = new Date(System.currentTimeMillis() + 10 * 60 * 1000);
        String token = Jwts.builder()
                .setSubject(String.valueOf(userId))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(expirationDate)
                .signWith(this.getKey(), SignatureAlgorithm.HS256)
                .compact();
        return TokenResponse.builder()
                .accessToken(token)
                .build();
    }

    @Override
    public TokenResponse validateToken(String token) {
        return null;
    }

    @Override
    public Claims getClaimsFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(this.getKey())
                .build()
                .parseClaimsJwt(token)
                .getBody();
    }

    @Override
    public Boolean isTokenExpired(String token) {
        try {
            return this.getClaimsFromToken(token).getExpiration().before(new Date(System.currentTimeMillis()));
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Integer getUserIdFromToken(String token) {
        try {
            return Integer.parseInt(this.getClaimsFromToken(token).getSubject());
        } catch (Exception e) {
            return null;
        }
    }

    private Key getKey(){

        byte[] byteKey = Decoders.BASE64.decode(this.secretToken);

        return Keys.hmacShaKeyFor(byteKey);

    }
}
