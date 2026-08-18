package com.example.inventory_api.controller;

import com.example.inventory_api.dto.ItemRequestDTO;
import com.example.inventory_api.model.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.inventory_api.service.ItemService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    @PostMapping("/items")
    public Item addItem(@Valid @RequestBody ItemRequestDTO itemRequestDTO){
        return itemService.saveItem(itemRequestDTO);
    }
    @GetMapping("/items")
    public Page<Item> getAllItems(Pageable pageable){
        return itemService.getAllItems(pageable);
    }
    @GetMapping("/items/{id}")
    public Item getItemById(@PathVariable Long id){
        return itemService.getItemById(id);
    }
    @PutMapping("/items/{id}")
    public Item updateItem(@PathVariable Long id, @RequestBody Item item){
        return itemService.updateItem(id, item);
    }
    @DeleteMapping("/items/{id}")
    public String deleteItem(@PathVariable Long id){
        return itemService.deleteItem(id);
    }
}

