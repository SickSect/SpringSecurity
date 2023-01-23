package com.boot.ugina.bootexmpl.service;

import com.boot.ugina.bootexmpl.entity.Item;
import com.boot.ugina.bootexmpl.repo.ItemRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepo repo;
    public boolean  addItem(String name, Double price){
        if (price.isNaN() || name.isEmpty())
            return false;
        Item item = new Item();
        item.setName(name);
        item.setPrice(price);
        repo.save(item);
        return true;
    }

    public boolean deleteItem(Long id) {
        if (id <= 0 || !repo.existsById(id))
            return false;
        repo.deleteById(id);
        return true;
    }
}
