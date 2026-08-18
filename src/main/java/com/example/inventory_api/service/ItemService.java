package com.example.inventory_api.service;

import GlobalExceptionHandler.ItemNotFoundException;
import com.example.inventory_api.dto.ItemRequestDTO;
import com.example.inventory_api.model.Category;
import com.example.inventory_api.model.Item;
import com.example.inventory_api.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import com.example.inventory_api.repository.ItemRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;

    public ItemService(ItemRepository itemRepository, CategoryRepository categoryRepository){
        this.itemRepository = itemRepository;
        this.categoryRepository = categoryRepository;
    }
    //postmapping
    public Item saveItem(ItemRequestDTO itemRequestDTO) {
        Category category = categoryRepository.findById(itemRequestDTO.getCategoryId())
                .orElseThrow(() -> new ItemNotFoundException("Category not found"));
        Item item = new Item(
                itemRequestDTO.getName(),
                itemRequestDTO.getQuantity(),
                itemRequestDTO.getPrice(),
                category
        );
        return itemRepository.save(item);
    }
    //getmapping
    public Page<Item>getAllItems(Pageable pageable){
        return itemRepository.findAll(pageable);
    }
    public Item getItemById(Long id){
        return itemRepository.findById(id)
            .orElseThrow(() -> new ItemNotFoundException("Item not found"));
    }
    public Item updateItem(Long id, Item UpdatedItem){
        Item existingItem = itemRepository.findById(id).orElseThrow(()-> new ItemNotFoundException("Item not found"));
        existingItem.setName (UpdatedItem.getName());
        existingItem.setQuantity(UpdatedItem.getQuantity());
        existingItem.setPrice(UpdatedItem.getPrice());
        return itemRepository.save(existingItem);
    }
    public String deleteItem(Long id){
        itemRepository.findById(id)
                .orElseThrow(()-> new ItemNotFoundException("Item not found"));
        itemRepository.deleteById(id);

        return "Item Deleted Successfully";
    }
}
