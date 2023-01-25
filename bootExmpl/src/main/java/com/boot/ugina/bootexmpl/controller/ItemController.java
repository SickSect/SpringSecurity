package com.boot.ugina.bootexmpl.controller;

import com.boot.ugina.bootexmpl.entity.Item;
import com.boot.ugina.bootexmpl.repo.ItemRepo;
import com.boot.ugina.bootexmpl.service.ItemService;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class ItemController {
    private final ItemService serv;
    record ItemRequest(
         String name,
         Double price
    ){};
    @PostMapping("/add/item")
    public ResponseEntity addItem(@RequestBody ItemRequest req){
        if (!serv.addItem(req.name(), req.price())){
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
