package com.xecurity.security_amo.service;

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
public class JwtServ {
    private final static String SECRET = "66556A586E327235753878214125442A472D4B6150645367566B597033733676";

    public String generateToken(UserDetails details){
        return generateToken(new HashMap<>(), details);
    }

    private <K, V> String generateToken(Map<String, Object> map, UserDetails details) {
        return Jwts.builder()
                .setClaims(map)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .setSubject(details.getUsername())
                .signWith(getSIgnKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractingEmail(String jwt){
        return extractClaim(jwt, Claims::getSubject);
    }

    private <T> T extractClaim(String jwt, Function<Claims, T> resolver) {
        final Claims cl= extractAllClaims(jwt);
        return resolver.apply(cl);
    }

    private Key getSIgnKey() {
        byte[] bytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(bytes);
    }

    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSIgnKey())
                .build()
                .parseClaimsJwt(token)
                .getBody();
    }

    public boolean isTokenValid(String token, UserDetails user){
        final String username = user.getUsername();
        return (username.equals(user.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
}
