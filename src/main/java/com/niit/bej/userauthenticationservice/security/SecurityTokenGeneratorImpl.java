package com.niit.bej.userauthenticationservice.security;

import com.niit.bej.userauthenticationservice.domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class SecurityTokenGeneratorImpl implements SecurityTokenGenerator {
    @Override
    public Map<String, String> generateToken(User user) {
        String generateToken = Jwts.builder().setSubject(user.getEmailId()).setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "book").compact();
        return Map.of("Token", generateToken, "Message", "Token Generated");

    }
}
