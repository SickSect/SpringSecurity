package com.boot.ugina.bootexmpl.controller;

import com.boot.ugina.bootexmpl.entity.Customer;
import com.boot.ugina.bootexmpl.entity.Role;
import com.boot.ugina.bootexmpl.repo.CustomerRepo;
import com.boot.ugina.bootexmpl.repo.RoleRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private AuthenticationManager authenticationManager;
    private CustomerRepo c_repo;
    private RoleRepo r_repo;
    private PasswordEncoder passwordEncoder;
    private Logger log = LoggerFactory.getLogger(AuthController.class);

    public AuthController(AuthenticationManager authenticationManager, CustomerRepo c_repo, RoleRepo r_repo, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.c_repo = c_repo;
        this.r_repo = r_repo;
        this.passwordEncoder = passwordEncoder;
    }

    record RegisterReq(String username, String password) {
    }

    @PostMapping("/reg")
    public ResponseEntity<String> register(@RequestBody RegisterReq req) {
        // ADD HERE EMAIL and etc features
        log.info("User: " + req.username() + " Try to register");
        if (c_repo.findByUsername(req.username()) == null) { // check if exist
            log.error("This name is already in use");
            return ResponseEntity.status(HttpStatus.CONFLICT).body("This name is already in use");
        }
        Customer customer = new Customer();
        customer.setPassword(passwordEncoder.encode(req.password())); // need do encode pass
        customer.setUsername(req.username());

        Role role = r_repo.findByName("USER");
        customer.setRoles(Collections.singletonList(role));
        c_repo.save(customer);
        return ResponseEntity.status(HttpStatus.OK).body("Customer registered success");
    }

    record LoginInfo(String username, String password) {
    }

    /*@PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginInfo log) {
        Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(log.username(), log.password()));

    }*/
}

