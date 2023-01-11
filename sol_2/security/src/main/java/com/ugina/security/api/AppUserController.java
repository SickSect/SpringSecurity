package com.ugina.security.api;

import com.ugina.security.entity.AppUser;
import com.ugina.security.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AppUserController {
    private final AppUserService service;

    @GetMapping("/list")
    public ResponseEntity<List<AppUser>>getAppUsers(){
        return ResponseEntity.ok().body(service.getList());
    }
}
