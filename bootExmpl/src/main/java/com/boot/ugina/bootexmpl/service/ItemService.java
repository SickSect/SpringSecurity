package com.boot.ugina.bootexmpl.service;

import com.boot.ugina.bootexmpl.entity.Item;
import com.boot.ugina.bootexmpl.entity.enums.Category;
import com.boot.ugina.bootexmpl.repo.ItemRepo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepo repo;
    private Logger logger = LoggerFactory.getLogger(ItemService.class);
    public boolean  addItem(String name, Double price, Category type){
        if (price.isNaN() || name.isEmpty() || type == null) {
            logger.error("Wrong arguments to create item");
            return false;
        }
        Item item = new Item();
        item.setName(name);
        item.setPrice(price);
        item.setType(type);
        item.setItemUuid(UUID.randomUUID().toString());

        repo.save(item);
        logger.info("Item was created");
        return true;
    }

    public boolean deleteItem(Long id) {
        if (id <= 0 || !repo.existsById(id)) {
            logger.error("Bad arguments to delete item");
            return false;
        }
        repo.deleteById(id);
        logger.info("Item was deleted");
        return true;
    }

    public List<Item> getList() {
        logger.info("Returning list of item");
        return repo.findAll();
    }
}
