package com.svetlin.store.category.controller;

import com.svetlin.store.category.Service.CategoryService;
import com.svetlin.store.category.dto.CategoryDto;
import com.svetlin.store.category.dto.CategoryResource;
import com.svetlin.store.category.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/{id}")
    public CategoryDto getById(@PathVariable("id") Long id) {
        return categoryService.getById(id);
    }

    @GetMapping
    public CategoryResource getAll() {
        return categoryService.getAll();
    }

    @PostMapping
    public ResponseEntity<Category> getAllCategories(Category category) {
        return ResponseEntity.ok().body(categoryService.create(category));
    }

    @PutMapping
    public ResponseEntity<Category> updateProduct(Category category) {
        return ResponseEntity.ok().body(categoryService.updateCategory(category));
    }
}
