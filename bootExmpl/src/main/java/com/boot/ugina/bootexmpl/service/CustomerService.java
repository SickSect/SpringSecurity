package com.boot.ugina.bootexmpl.service;

import com.boot.ugina.bootexmpl.entity.Customer;
import com.boot.ugina.bootexmpl.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepo c_repo;
    private Logger logger = LoggerFactory.getLogger(CustomerService.class);
    public List<Customer> getList() {
        logger.info("Returning list of customers");
        return c_repo.findAll();
    }

    public Customer getById(Long id){
        if (id <= 0) {
            return null;
        }
        Customer customer = new Customer();
        customer = c_repo.findById(id);
        if (customer != null) {
            logger.info("Returning customer by id");
            return customer;
        }
        logger.info("List of customers is empty");
        return null;
    }

    public boolean createCustomer(String name, String email, Integer age){
        if (!name.isEmpty() && !email.isEmpty() && age > 0)
        {
            Customer customer = new Customer();
            customer.setAge(age);
            customer.setEmail(email);
            customer.setName(name);
            customer.setCustomerUuid(UUID.randomUUID().toString());
            c_repo.save(customer);
            logger.info("Customer was created");
            return true;
        }
        logger.error("Bad arguments to create customer");
        return false;
    }
}
