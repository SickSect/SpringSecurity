package com.boot.ugina.bootexmpl.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private final static String SECRET = "66556A586E327235753878214125442A472D4B6150645367566B597033733676";
    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(), userDetails);
    }
    public String generateToken(Map<String, Object>extraClaims, UserDetails userDetails){
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .setIssuedAt(new Date())
                .signWith(getSighKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getSighKey() {
        byte[] bytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(bytes);
    }

    public String extractingEmail(String jwtToken){
        return extractClaim(jwtToken, Claims::getSubject);
    }

    private <T>T extractClaim(String jwtToken, Function<Claims, T> resolver) {
        final Claims claims = extractAllClaim(jwtToken);
        return resolver.apply(claims);
    }

    private Claims extractAllClaim(String jwtToken) {
        return Jwts.parserBuilder()
                .setSigningKey(getSighKey())
                .build()
                .parseClaimsJws(jwtToken)
                .getBody();
    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        final String username = userDetails.getUsername();
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
}
