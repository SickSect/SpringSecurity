package com.boot.ugina.bootexmpl.controller;

import com.boot.ugina.bootexmpl.entity.Item;
import com.boot.ugina.bootexmpl.entity.enums.Category;
import com.boot.ugina.bootexmpl.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService serv;
    record ItemRequest(
         String name,
         Double price,
         Category type
    ){};
    @PostMapping("/add/item")
    public ResponseEntity addItem(@RequestBody ItemRequest req){
        if (!serv.addItem(req.name(), req.price(), req.type())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Wrong arguments");
        }
        else
            return ResponseEntity.status(HttpStatus.CREATED).body("Item was added");
    }

    @GetMapping("/list")
    public List<Item> getList(){
        return serv.getList();
    }

    @DeleteMapping("/delete/item")
    public void delete(@PathVariable("id") Long id){
        serv.deleteItem(id);
    }
}
