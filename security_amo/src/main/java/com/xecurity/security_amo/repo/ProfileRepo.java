package com.xecurity.security_amo.repo;

import com.xecurity.security_amo.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepo extends JpaRepository<Profile, Long> {
}
