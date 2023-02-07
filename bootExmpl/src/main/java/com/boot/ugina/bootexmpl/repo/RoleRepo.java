package com.boot.ugina.bootexmpl.repo;

import com.boot.ugina.bootexmpl.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface  RoleRepo extends JpaRepository<Role, Long> {

    Role findByName(String user);
}
