package com.boot.ugina.bootexmpl.service;

import com.boot.ugina.bootexmpl.entity.Item;
import com.boot.ugina.bootexmpl.entity.OnOrder;
import com.boot.ugina.bootexmpl.entity.enums.OrderStatus;
import com.boot.ugina.bootexmpl.repo.CustomerRepo;
import com.boot.ugina.bootexmpl.repo.ItemRepo;
import com.boot.ugina.bootexmpl.repo.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.lang.model.element.Element;
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
    private Logger logger = LoggerFactory.getLogger(OrderService.class);
    public List<OnOrder> getList() {
        logger.info("Returning list of orders");

        return o_repo.findAll();
    }

    public Optional<OnOrder> getById(Long id) {
        if (id <= 0 || !(o_repo.existsById(id))) {
            logger.error("Bad arguments to find order by id");
            return null;
        }
        logger.info("Returning order by id");
        return o_repo.findById(id);
    }

    public ResponseEntity createOrder(String address, Long ownerId, Collection<Long> itemList) {
        System.out.println("LOOK HERE" + itemList.toString());
        if (address.isEmpty() || ownerId <= 0) {
            logger.error("Bad arguments to create new order");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wrong arguments inside request");
        }
        OnOrder order = new OnOrder();
        order.setAddress(address);
        order.setStatus(true);
        if (!c_repo.existsById(ownerId)) {
            logger.error("Bad arguments to create new order");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wrong arguments inside request");
        }
        order.setOwner(c_repo.findById(ownerId));
        itemList.forEach(e -> order.getItemCollection().add(i_repo.findById(e).get()));
        if (order.getItemCollection().isEmpty()) {
            logger.error("Bad arguments to create new order (empty order)");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No items in order");
        }
        order.setOrderUuid(UUID.randomUUID().toString());
        order.setCurrentStatus(OrderStatus.CREATED);
        o_repo.save(order);
        logger.info("Order was created");
        return ResponseEntity.status(HttpStatus.CREATED).body("Order created");
    }

    public ResponseEntity deleteOrder(Long id) {
        if (!o_repo.existsById(id))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No order by id " + id);
        o_repo.deleteById(id);
        logger.info("Order was deleted");
        return  ResponseEntity.status(HttpStatus.OK).body("Order deleted");
    }

    public ResponseEntity changeStatus(Long id, OrderStatus accepted) {
        Optional<OnOrder> order = o_repo.findById(id);
        if (order.isEmpty()) {
            logger.error("Bad arguments for changing order's status");
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Changing order's status failed");
        }
        order.get().setCurrentStatus(accepted);
        logger.info("Order's status was changed");
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Order become status accepted");
    }
}
