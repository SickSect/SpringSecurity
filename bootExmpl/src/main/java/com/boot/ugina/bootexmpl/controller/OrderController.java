package com.boot.ugina.bootexmpl.controller;

import com.boot.ugina.bootexmpl.entity.Item;
import com.boot.ugina.bootexmpl.entity.OnOrder;
import com.boot.ugina.bootexmpl.entity.OrderStatus;
import com.boot.ugina.bootexmpl.repo.CustomerRepo;
import com.boot.ugina.bootexmpl.repo.ItemRepo;
import com.boot.ugina.bootexmpl.repo.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderRepo o_repo;
    private final CustomerRepo c_repo;
    private  final ItemRepo i_repo;
    @GetMapping("/list")
    public List<OnOrder> orderList(){
        return o_repo.findAll();
    }

    @GetMapping("/by/id")
    public Optional<OnOrder> orderById(@RequestParam("id") Long id){
        return o_repo.findById(id);
    }
    record OrderRequest(
            String address,
            boolean status,
            Long ownerId,
            List<Long> itemList


    ){}
    @PostMapping("/create")
    public void createOrder(@RequestBody OrderRequest req){
        OnOrder order = new OnOrder();
        order.setStatus(req.status());
        order.setAddress(req.address());
        order.setOwner(c_repo.findById(req.ownerId()));
        order.setCurrentStatus(OrderStatus.CREATED);
        for (Long id: req.itemList) {
            Item item = i_repo.getReferenceById(id);
            order.getItemCollection().add(item);
        }
        o_repo.save(order);
    }
}
