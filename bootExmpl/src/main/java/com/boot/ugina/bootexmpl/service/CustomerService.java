package com.boot.ugina.bootexmpl.service;

import com.boot.ugina.bootexmpl.entity.Customer;
import com.boot.ugina.bootexmpl.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepo c_repo;

    public List<Customer> getList() {
        return c_repo.findAll();
    }

    public Customer getById(Long id){
        if (id <= 0)
            return null;
        Customer customer = new Customer();
        customer = c_repo.findById(id);
        if (customer != null)
            return customer;
        return null;
    }

    public boolean createCustomer(String name, String email, Integer age){
        if (!name.isEmpty() && !email.isEmpty() && age > 0)
        {
            Customer customer = new Customer();
            customer.setAge(age);
            customer.setEmail(email);
            customer.setName(name);
            c_repo.save(customer);
            return true;
        }
        return false;
    }
}
