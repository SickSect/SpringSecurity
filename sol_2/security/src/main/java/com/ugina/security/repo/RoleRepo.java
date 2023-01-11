package com.ugina.security.repo;

import com.ugina.security.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role fingByName(String name);
}
