package com.boot.ugina.bootexmpl.controller;

import com.boot.ugina.bootexmpl.DTO.AuthRequest;
import com.boot.ugina.bootexmpl.DTO.AuthResponse;
import com.boot.ugina.bootexmpl.DTO.RegRequest;
import com.boot.ugina.bootexmpl.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService service;
    private final Logger log = LoggerFactory.getLogger(AuthController.class);
    @PostMapping("/reg")
    public ResponseEntity<AuthResponse> register(@RequestBody RegRequest req) {
        return ResponseEntity.ok(service.register(req));
    }

    @PostMapping("/log")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest log){
        return ResponseEntity.ok(service.login(log));
    }
}

