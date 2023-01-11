package com.example.secprop.service;

import com.example.secprop.entity.AppUser;
import com.example.secprop.entity.Role;
import com.example.secprop.repo.AppUserRepo;
import com.example.secprop.repo.RoleRepo;
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
    private final AppUserRepo appUserRepo;
    private final RoleRepo roleRepo;
    @Override
    public AppUser saveUser(AppUser user) {
        log.info("Saving user....");
        return appUserRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving role....");
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        log.info("User: " + userName + " granted role " + roleName + " pre condition values");
        AppUser user = appUserRepo.findByUserName(userName);
        log.info("USR IS " + user.getUserName());
        Role role = roleRepo.findByName(roleName);
        log.info("ROLE IS " + role.getName());
        user.getRoleList().add(role);
    }

    @Override
    public AppUser getUser(String name) {
        return appUserRepo.findByUserName(name);
    }

    @Override
    public List<AppUser> getList() {
        return appUserRepo.findAll();
    }
}
