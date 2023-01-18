package com.ugina.springsec.access;

import com.ugina.springsec.entity.AppUser;
import com.ugina.springsec.service.AppUserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;

@Component
@Slf4j
public class JwtTokenProvider {

    private final AppUserService service;

    @Value("${auth.cookie.secret")
    private String secretKey;
    @Getter
    @Value("${auth.cookie.auth")
    private String authKey;
    @Getter
    @Value("${auth.cookie.refresh")
    private String refreshKey;
    @Getter
    @Value("${auth.cookie.expiration-auth")
    private Integer expirationAuthCookie;
    @Getter
    @Value("${auth.cookie.expiration-refresh")
    private Integer expirationRefreshCookie;
    @Getter
    @Value("${auth.token.path}")
    private String path;

    @Autowired
    public JwtTokenProvider(AppUserService service) {
        this.service = service;
    }

    @PostConstruct
    public void initSecret(){
        this.secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }
    public String createAuthToken(String username, String role){
        Claims claims = Jwts.claims().setSubject(username);// грубо говоря - тело токена
        claims.put("role", role);
        Date now = new Date();
        Date valid = new Date(now.getTime() + getExpirationAuthCookie());
        return Jwts.builder().setClaims(claims).setIssuedAt(now).setExpiration(valid).signWith(SignatureAlgorithm.ES256, secretKey).compact();
    }

    public boolean validateToken(String token){
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secretKey).parseClaimsJws();
        return claimsJws.getBody().getExpiration().after(new Date());
    }

    public Authentication getAuth(String token){
        AppUser appUser = service.loadUserByUsername(getUserName(token));
    }

    private String getUserName(String token) {
    }
}
