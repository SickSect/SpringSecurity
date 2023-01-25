package com.boot.ugina.bootexmpl.service;

import com.boot.ugina.bootexmpl.entity.OnOrder;
import com.boot.ugina.bootexmpl.entity.enums.OrderStatus;
import com.boot.ugina.bootexmpl.repo.CustomerRepo;
import com.boot.ugina.bootexmpl.repo.ItemRepo;
import com.boot.ugina.bootexmpl.repo.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class OrderService {
    private final OrderRepo o_repo;
    private final CustomerRepo c_repo;
    private  final ItemRepo i_repo;

    public List<OnOrder> getList() {
        return o_repo.findAll();
    }

    public Optional<OnOrder> getById(Long id) {
        if (id <= 0 || !(o_repo.existsById(id)))
            return null;
        return o_repo.findById(id);
    }

    public ResponseEntity createOrder(String address, Long ownerId, Collection<Long> itemList) {
        if (address.isEmpty() || ownerId <= 0)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wrong arguments inside request 1");
        OnOrder order = new OnOrder();
        order.setAddress(address);
        order.setStatus(true);
        if (!c_repo.existsById(ownerId))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wrong arguments inside request 2");
        for (Long id:
             itemList) {
            order.getItemCollection().add(i_repo.getReferenceById(id));
        }
        if (order.getItemCollection().isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No items in order");
        order.setOrderUuid(UUID.randomUUID().toString());
        order.setCurrentStatus(OrderStatus.CREATED);
        o_repo.save(order);
        return ResponseEntity.status(HttpStatus.CREATED).body("Order created");
    }

    public ResponseEntity deleteOrder(Long id) {
        if (id <= 0 || !o_repo.existsById(id))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There is no order with such id");
        o_repo.deleteById(id);
        return  ResponseEntity.status(HttpStatus.OK).body("Order deleted");
    }

    public ResponseEntity changeStatus(Long id, OrderStatus accepted) {
        Optional<OnOrder> order = o_repo.findById(id);
        if (order.isEmpty())
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Changing order's status failed");
        order.get().setCurrentStatus(accepted);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Order become status accepted");
    }
}
