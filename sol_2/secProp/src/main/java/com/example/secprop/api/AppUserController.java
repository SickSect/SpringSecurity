package com.example.secprop.api;

import com.example.secprop.entity.AppUser;
import com.example.secprop.entity.Role;
import com.example.secprop.service.AppUserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AppUserController {
    private final AppUserService service;

    @GetMapping("/list")
    public ResponseEntity<List<AppUser>>getAppUsers(){
        return ResponseEntity.ok().body(service.getList());
    }

    @PostMapping("/user/save")
    public ResponseEntity<AppUser>saveAppUsers(@RequestBody AppUser user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(service.saveUser(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role>roleAppUsers(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(service.saveRole(role));
    }

    @PostMapping("/addToUser/save")
    public ResponseEntity<?>addRoleAppUsers(@RequestBody RoleToUserForm form){
        service.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }
}
@Data
class RoleToUserForm{
    private String username;
    private String roleName;
}
