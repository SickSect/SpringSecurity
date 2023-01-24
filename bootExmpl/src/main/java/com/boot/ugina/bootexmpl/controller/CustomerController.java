package com.boot.ugina.bootexmpl.controller;

import com.boot.ugina.bootexmpl.entity.Customer;
import com.boot.ugina.bootexmpl.repo.CustomerRepo;
import com.boot.ugina.bootexmpl.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class CustomerController {
    private final CustomerService serv;
    @GetMapping("/list")
    public List<Customer> customerList(){
        return serv.getList();
    }

    @GetMapping("/by/id")
    public Customer getById(@RequestParam("id") Long id){
        Customer customer = new Customer();
        customer = serv.getById(id);
        if (customer != null)
            return customer;
        else
            return null;
    }

    record CustomerRequest(
            String name,
            String email,
            Integer age
    ){}
    @PostMapping("/create")
    public ResponseEntity create(@RequestBody CustomerRequest req){
        if (!serv.createCustomer(req.name(), req.email(), req.age()))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wrong typed argument (name/age/email)");
        return ResponseEntity.status(HttpStatus.CREATED).body("Create new customer");
    }

    /*@PostMapping("/makeOrder")
    public ResponseEntity makeOrder(@RequestBody Long id){

    }*/
}
