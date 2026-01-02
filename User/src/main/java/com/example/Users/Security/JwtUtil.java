package com.example.Users.Security;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.example.Users.Entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
private final String SECRET_KEY = "eu8Jk9zXlQk3rYv5pQ2s8hJf9lZx3tWq1r8vJk9zXlQk3rYv5pQ2s8hJf9l";
    private final long EXPRIRATION=1000 * 60 * 60;
    public String generateToken(User user) {
        return Jwts.builder()
        		   .setSubject(user.getEmail())
                .claim("role",user.getRole().name())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPRIRATION)) // 1 hours
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();}
   //Extract email
    public String extractEmail(String token) {
        return getClaims(token).getSubject();}

    public String extractRole(String token) {
        return getClaims(token).get("role",String.class);
    }

    public boolean isTokenValid(String token) {
        return !getClaims(token).getExpiration().before(new Date());
    }

    private Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }
}