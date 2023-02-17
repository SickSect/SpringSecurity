package com.boot.ugina.bootexmpl.service;

import com.boot.ugina.bootexmpl.DTO.AuthRequest;
import com.boot.ugina.bootexmpl.DTO.AuthResponse;
import com.boot.ugina.bootexmpl.DTO.RegRequest;
import com.boot.ugina.bootexmpl.entity.Customer;
import com.boot.ugina.bootexmpl.entity.Role;
import com.boot.ugina.bootexmpl.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final CustomerRepo c_repo;
    private final PasswordEncoder encoder;
    private final JwtService jwtServ;
    private final AuthenticationManager manager;

    public AuthResponse register(RegRequest req){
        var user = Customer.builder()
                .name(req.getName())
                .age(req.getAge())
                .email(req.getEmail())
                .username(req.getUsername())
                .surname(req.getSurname())
                .password(encoder.encode(req.getPassword()))
                .role(Role.USER)
                .build();
        c_repo.save(user);
        String jwt = jwtServ.generateToken(user);
        return AuthResponse.builder().token(jwt).build();
    }

    public AuthResponse login(AuthRequest req){
        manager.authenticate(new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword()));
        var user = c_repo.findByEmail(req.getEmail()).orElseThrow();
        String token = jwtServ.generateToken(user);
        return AuthResponse.builder().token(token).build();
    }
}
