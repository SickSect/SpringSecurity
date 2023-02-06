package com.boot.ugina.bootexmpl.service;

import com.boot.ugina.bootexmpl.entity.Customer;
import com.boot.ugina.bootexmpl.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static com.boot.ugina.bootexmpl.entity.enums.Roles.ADMIN;
import static com.boot.ugina.bootexmpl.entity.enums.Roles.USER;

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
        customer = c_repo.findById(id).get();
        if (customer != null) {
            logger.info("Returning customer by id");
            return customer;
        }
        logger.info("List of customers is empty");
        return null;
    }

    public boolean createCustomer(String name,String surname,String username, String password, String email, Integer age){
        if (!name.isEmpty() && !email.isEmpty() && age > 0)
        {
            Customer customer = new Customer();
            customer.setAge(age);
            customer.setEmail(email);
            customer.setName(name);
            customer.setSurname(surname);
            customer.setUsername(username);
            customer.setPassword(password);
            customer.setCustomerUuid(UUID.randomUUID().toString());
            customer.setOrderList(null);
            //customer.setRole(USER);
            c_repo.save(customer);
            logger.info("Customer was created");
            return true;
        }
        logger.error("Bad arguments to create customer");
        return false;
    }

    public ResponseEntity changeUsername(String username) {
        // надо дописать проверку на схожие логины
        if (username.isEmpty() || c_repo.findByUsername(username) != null)
        {
            logger.error("Error changing username");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wrong username (try another one)");
        }
        // change username here
        return ResponseEntity.status(HttpStatus.OK).body("Username was changed");
    }
}
