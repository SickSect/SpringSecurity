package com.example.secprop.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

@Component
public class JwtUtils {
    private String jwtSignKey = "secret";

    public String extractUserName(String token){
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claim = extractAllClaims(token);
        return claimsResolver.apply(claim);
    }

    public boolean hasClaim(String token, String claimName){
        final Claims claim = extractAllClaims(token);
        return claim.get(claimName)!= null;
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(jwtSignKey).parseClaimsJws(token).getBody();
    }

    public String generateToken(UserDetails details){
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, details);
    }

    public String generateToken(UserDetails details, Map <String, Object> claims){
        return createToken(claims, details);
    }

    private String createToken(Map<String, Object> claims, UserDetails details) {
        return Jwts.builder().setClaims(claims)
                .setSubject(details.getUsername())
                .claim("authorities", details.getAuthorities())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(24)))
                .signWith(SignatureAlgorithm.HS256, jwtSignKey).compact();
    }

    public boolean isTokenValid(String token, UserDetails details){
        final String username = extractUserName(token);
        return (username.equals(details.getUsername()) && !IsTokenExpired(token));
    }

    private boolean IsTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
}
