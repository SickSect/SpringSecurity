package com.ugina.security.service;

import com.ugina.security.entity.AppUser;
import com.ugina.security.entity.Role;

import java.util.List;

public interface AppUserService {
    AppUser saveUser(AppUser user);
    Role saveRole(Role role);
    void addRoleUser(String username, String rolename);
    AppUser getUser(String name);
    List<AppUser> getList();
}
