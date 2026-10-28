package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.ItemEntity;
import com.example.demo.service.ItemService;

@RestController
@RequestMapping("/item/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ItemController {

    @Autowired
    ItemService iserv;

    @GetMapping("/printAuthor")
    public String printAuthor() {
        return "Edvard Antony De los Reyes";
    }

    @PostMapping("/postNewItem")
    public ItemEntity postItem(@RequestBody ItemEntity item) {
        return iserv.postItem(item);
    }

    @GetMapping("/getAllItems")
    public List<ItemEntity> getAllItems() {
        return iserv.getAllItems();
    }

    @PutMapping("/putItem")
    public ItemEntity putItem(@RequestParam int id, @RequestBody ItemEntity newItemDetails) {
        return iserv.putItem(id, newItemDetails);
    }

    @DeleteMapping("/deleteItem/{id}")
    public String deleteItem(@PathVariable int id) {
        return iserv.deleteItem(id);
    }
}