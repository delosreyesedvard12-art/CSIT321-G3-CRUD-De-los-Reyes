package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.ItemEntity;
import com.example.demo.exception.ItemNotFoundException;
import com.example.demo.repository.ItemRepository;

@Service
public class ItemService {

    @Autowired
    ItemRepository irepo;

    public ItemEntity postItem(ItemEntity item) {
        return irepo.save(item);
    }

    public List<ItemEntity> getAllItems() {
        return irepo.findAll();
    }

    public ItemEntity putItem(int id, ItemEntity newItemDetails) {
        ItemEntity item = irepo.findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Item " + id + " does not exist!"));
        item.setName(newItemDetails.getName());
        item.setUnit(newItemDetails.getUnit());
        item.setPrice(newItemDetails.getPrice());
        return irepo.save(item);
    }

    public String deleteItem(int id) {
        if (!irepo.existsById(id)) {
            throw new ItemNotFoundException("Item " + id + " does not exist!");
        }
        irepo.deleteById(id);
        return "Item " + id + " is successfully deleted!";
    }
}