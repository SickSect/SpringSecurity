package com.boot.ugina.bootexmpl.repo;

import com.boot.ugina.bootexmpl.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CustomerRepo extends JpaRepository<Customer, Long> {

    Optional<Customer> findById(Long ownerId);
    Optional<Customer> findByUsername(String username);

    boolean existsById(Long ownerId);

    //boolean existByCustomerusername(String username);
}
