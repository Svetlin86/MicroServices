package com.svetlin.store.category.controller;

import com.svetlin.store.category.Service.CategoryService;
import com.svetlin.store.category.dto.CategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<String> create(CategoryDto categoryDto) {
        return ResponseEntity.ok().body(categoryService.create(categoryDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(categoryService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        return ResponseEntity.ok().body(categoryService.getAllCategories());
    }

    @PutMapping
    public ResponseEntity<String> updateProduct(CategoryDto categoryDto) {
        return ResponseEntity.ok().body(categoryService.updateCategory(categoryDto));
    }
}
