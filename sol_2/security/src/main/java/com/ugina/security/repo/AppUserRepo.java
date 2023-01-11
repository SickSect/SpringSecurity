package com.ugina.security.repo;

import com.ugina.security.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser, Long> {
    AppUser findByName(String name);
}
