package com.example.secprop.repo;

import com.example.secprop.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser, Long> {
    AppUser findByUserName(String userName);
}
