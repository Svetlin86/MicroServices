package com.svetlin.store.product.service;

import com.svetlin.store.product.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto getById(Long id);

    ProductDto createProduct(ProductDto productDto);

    List<ProductDto> getAllProducts();

    ProductDto updateProduct(ProductDto productDto);
}
