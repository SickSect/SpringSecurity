package com.xecurity.security_amo.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
<<<<<<< HEAD
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
=======
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
>>>>>>> origin/main
import java.util.function.Function;

@Service
public class JwtServ {
    private final static String SECRET = "66556A586E327235753878214125442A472D4B6150645367566B597033733676";
<<<<<<< HEAD

    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails){
        return Jwts.builder()
                .setClaims(extraClaims) // should find what is claims!!!!!!!!!!!!!!!!
                .setSubject(userDetails.getUsername()) // set our info about user
                .setIssuedAt(new Date(System.currentTimeMillis())) // when was createdClaim
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60  * 24)) // expiration time
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact(); // generating
    }

    public String generateToken(UserDetails user){
        return generateToken(new HashMap<>(), user);
    }
    public String extractingEmail(String jwtToken) {
        return extractClaim(jwtToken, Claims::getSubject);
=======
    public String extractingEmail(String jwtToken) {
        return null;
>>>>>>> origin/main
    }

    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
<<<<<<< HEAD
                .parseClaimsJws(token)
=======
                .parseClaimsJwt(token)
>>>>>>> origin/main
                .getBody();
    }

    private Key getSignInKey() {
        byte[] bytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(bytes);
    }

<<<<<<< HEAD
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token); // we take all claims
        return claimsResolver.apply(claims); // and apply our func on them
    }

    public boolean isTokenValid(String token, UserDetails user){
        final String username = extractingEmail(token); //
        return (username.equals(user.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration); // what we will return depends on our func!
=======
    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
>>>>>>> origin/main
    }
}
