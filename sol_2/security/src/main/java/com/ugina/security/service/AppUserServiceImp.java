package com.ugina.security.service;

import com.ugina.security.entity.AppUser;
import com.ugina.security.entity.Role;
import com.ugina.security.repo.AppUserRepo;
import com.ugina.security.repo.RoleRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AppUserServiceImp implements AppUserService{
    private final AppUserRepo userRepo;
    private final RoleRepo roleRepo;
    @Override
    public AppUser saveUser(AppUser user) {
        log.info("Saving user....");
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving role....");
        return roleRepo.save(role);
    }

    @Override
    public void addRoleUser(String username, String rolename) {
        log.info("User: " + username + " granted role " + rolename);
        AppUser user = userRepo.findByName(username);
        Role role = roleRepo.fingByName(rolename);
        user.getRoleList().add(role);
    }

    @Override
    public AppUser getUser(String name) {
        return userRepo.findByName(name);
    }

    @Override
    public List<AppUser> getList() {
        return userRepo.findAll();
    }
}
