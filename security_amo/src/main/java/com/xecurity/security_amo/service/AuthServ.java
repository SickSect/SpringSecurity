package com.xecurity.security_amo.service;

import com.xecurity.security_amo.entity.Profile;
import com.xecurity.security_amo.entity.Role;
import com.xecurity.security_amo.repo.ProfileRepo;
import com.xecurity.security_amo.response.AuthRequest;
import com.xecurity.security_amo.response.AuthResponse;
import com.xecurity.security_amo.response.RegRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServ {
    private final ProfileRepo repo;
    private final PasswordEncoder pass;
    private final JwtServ jwtServ;
    private final AuthenticationManager manager;

    public AuthResponse register(RegRequest req) {
        // we have BUILDER annotation at Profile entity
        // so we should add info about user
        // and inject password encoder, before writing it into DB
        var user = Profile.builder()
                .name(req.getName())
                .surname(req.getSurname())
                .email(req.getEmail())
                .age(req.getAge())
                .password(pass.encode(req.getPassword()))
                .role(Role.USER)
                .build();
        repo.save(user);
        String jwtToken = jwtServ.generateToken(user); // generate token
        // and put it in return statement
        return AuthResponse.builder()
                .token(jwtToken).build();
    }

    public AuthResponse authenticate(AuthRequest req) {
        manager.authenticate(new UsernamePasswordAuthenticationToken(req.getEmail(),req.getPassword()));
        var user = repo.findByEmail(req.getEmail()).orElseThrow();
        String jwtToken = jwtServ.generateToken(user); // generate token
        // and put it in return statement
        return AuthResponse.builder()
                .token(jwtToken).build();
    }
}
