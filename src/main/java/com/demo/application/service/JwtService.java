package com.demo.application.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Service
public class JwtService {
    private final String SECRET_KEY="zfqWPPMx3HDJepyQAjfgyZ1imzbJpetkXLHb7I3wU74";

    //method to generate the signed key
    private SecretKey getSignedKey(){
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }
    //method to generate an JWT token
    public String generateToken(String subject){
        return Jwts.builder()
                .subject(subject)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+1000*60*60))
                .signWith(getSignedKey())
                .compact();
    }

    //method to extract claims
    private Claims extractClaims(String token){
        return Jwts.parser()
                .verifyWith(getSignedKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    //method to extract subject
    public String extractSubject(String token){
        return extractClaims(token).getSubject();
    }

    //method to get expiration
    private Date extractExpiration(String token){
        return extractClaims(token).getExpiration();
    }

    //method to validate the token
    public boolean isTokenValid(String token, UserDetails userDetails){
        String subject=extractSubject(token);
        return subject.equals(userDetails.getUsername())
                &&extractExpiration(token).after(new Date(System.currentTimeMillis()));
    }
}
