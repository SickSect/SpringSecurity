package com.boot.ugina.bootexmpl.controller;

import com.boot.ugina.bootexmpl.entity.Item;
import com.boot.ugina.bootexmpl.entity.OnOrder;
import com.boot.ugina.bootexmpl.entity.OrderStatus;
import com.boot.ugina.bootexmpl.repo.CustomerRepo;
import com.boot.ugina.bootexmpl.repo.ItemRepo;
import com.boot.ugina.bootexmpl.repo.OrderRepo;
import com.boot.ugina.bootexmpl.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService serv;

    @GetMapping("/list")
    public List<OnOrder> orderList(){
        return serv.getList();
    }

    @GetMapping("/by/id")
    public Optional<OnOrder> orderById(@RequestParam("id") Long id){
        return serv.getById(id);
    }
    record OrderRequest(
            String address,
            Long ownerId,
            Collection<Long> itemList


    ){}
    @PostMapping("/create")
    public ResponseEntity createOrder(@RequestBody OrderRequest req){
        String address = req.address();
        Long ownerId = req.ownerId();
        Collection<Long> itemList = req.itemList();
        return serv.createOrder(address, ownerId, itemList);
    }
}
