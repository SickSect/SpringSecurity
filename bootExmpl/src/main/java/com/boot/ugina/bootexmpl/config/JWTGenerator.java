package com.boot.ugina.bootexmpl.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;

import java.util.Date;

public class JWTGenerator {

    public String generateToken(Authentication auth) {
        String username = auth.getName();
        Date currentDate = new Date();
        Date expiredDate = new Date(currentDate.getTime() + SecurityConstants.JWT_EXP);
        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expiredDate)
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.JWT_SECRET)
                .compact();
        return token;
    }

    public String getUsernameFromJwt(String token) {
        Claims claim = Jwts.parser()
                .setSigningKey(SecurityConstants.JWT_SECRET)
                .parseClaimsJwt(token)
                .getBody();
        Claims cl = (Claims) Jwts.parserBuilder().setSigningKey(SecurityConstants.JWT_SECRET)
                .build()
                .parse(token)
                .getBody();

        System.out.println(claim.getSubject() + " this is through deprecated method");
        System.out.println(cl.getSubject() + " this is through builder");
        // its deprecated find another way to do it
        return cl.getSubject();
    }

    public boolean validateToken(String token){
        try {
            Jwts.parserBuilder().setSigningKey(SecurityConstants.JWT_SECRET).build()
                    .parse(token);
            return true;
        }
        catch (Exception ex){
            throw new AuthenticationCredentialsNotFoundException("JWT token is incorrect");
        }
    }
}

