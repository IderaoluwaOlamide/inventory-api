package com.example.inventory_api.service;

import com.example.inventory_api.model.Category;
import com.example.inventory_api.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }
}
