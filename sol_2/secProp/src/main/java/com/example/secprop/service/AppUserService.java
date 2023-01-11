package com.example.secprop.service;

import com.example.secprop.entity.AppUser;
import com.example.secprop.entity.Role;

import java.util.List;

public interface AppUserService {
    AppUser saveUser(AppUser user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    AppUser getUser(String name);
    List<AppUser> getList();
}
