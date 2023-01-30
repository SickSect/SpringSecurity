package com.boot.ugina.bootexmpl.controller;

import com.boot.ugina.bootexmpl.entity.Customer;
import com.boot.ugina.bootexmpl.repo.CustomerRepo;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/greet")
@RequiredArgsConstructor
public class GreetController {
    private final CustomerRepo repo;

    /*@GetMapping("/start")
    public String greet(){
        return "Hello"; // return us just word Hello in page
    }*/
    /*@GetMapping("/start")
    public GreetResponse greet(){
        return new GreetResponse("This is msg"); // it will   return json format msg
    }
    record GreetResponse (String msg){}*/
    @GetMapping("/start")
    @PreAuthorize("hasRole('ADMIN')")
    public GreetResponse greet(){
        return new GreetResponse("This is msg"); // it will   return json format msg
    }
    @GetMapping("/list")
    public List<Customer> getCustomers(){
        return repo.findAll();
    }
    record NewCustomerRequest(
        String email,
        String name,
        Integer age
    ){}

    @PostMapping("/new")
    public void addCustomer(@RequestBody  NewCustomerRequest req){
        Customer customer = new Customer();
        customer.setAge(req.age());
        customer.setName(req.name());
        customer.setEmail(req.email());
        repo.save(customer);
    }

    @DeleteMapping("/delete")
    public void deleteById(@RequestParam("id") Integer id){
        Optional<Customer> customer = repo.findById(id);
        if(!customer.isEmpty())
            repo.deleteById(id);
    }

    @Data
    class GreetResponse{
        private String greetMsg;
        private Date date;

        GreetResponse(String greetMsg) {
            this.greetMsg = greetMsg;
            SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            date = new Date(System.currentTimeMillis());
        }
    }
}
