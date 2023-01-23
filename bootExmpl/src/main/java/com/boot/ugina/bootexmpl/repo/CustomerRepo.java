package com.boot.ugina.bootexmpl.repo;

import com.boot.ugina.bootexmpl.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    Customer findById(Long ownerId);
}
