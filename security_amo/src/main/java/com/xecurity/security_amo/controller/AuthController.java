package com.xecurity.security_amo.controller;

import com.xecurity.security_amo.response.AuthRequest;
import com.xecurity.security_amo.response.AuthResponse;
import com.xecurity.security_amo.response.RegRequest;
import com.xecurity.security_amo.service.AuthServ;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthServ serv;
    @PostMapping("/reg")
    public ResponseEntity<AuthResponse> reg(@RequestBody RegRequest req){
        return ResponseEntity.ok(serv.register(req));
    }

    @PostMapping("/log")
    public ResponseEntity<AuthResponse> log(@RequestBody AuthRequest req){
        return ResponseEntity.ok(serv.authenticate(req));
    }
}
