package com.svetlin.store.product.controller;

import com.svetlin.store.product.dto.ProductDto;
import com.svetlin.store.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto> createCategory(@RequestBody ProductDto productDto) {
        return ResponseEntity.status(CREATED).body(productService.createProduct(productDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(productService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return ResponseEntity.ok().body(productService.getAllProducts());
    }

    @PutMapping
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto categoryDto) {
        return ResponseEntity.ok().body(productService.updateProduct(categoryDto));
    }
}
