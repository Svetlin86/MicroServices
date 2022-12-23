package com.svetlin.store.category.controller;

import com.svetlin.store.category.service.CategoryService;
import com.svetlin.store.category.dto.CategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(categoryService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        return ResponseEntity.ok().body(categoryService.getAllCategories());
    }

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        return ResponseEntity.status(CREATED).body(categoryService.createCategory(categoryDto));
    }

    @PutMapping
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto) {
        return ResponseEntity.ok().body(categoryService.updateCategory(categoryDto));
    }
}
