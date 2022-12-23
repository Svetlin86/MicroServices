package com.svetlin.store.category.Service;

import com.svetlin.store.category.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto getById(Long id);

    CategoryDto createCategory(CategoryDto category);

    List<CategoryDto> getAllCategories();

    CategoryDto updateCategory(CategoryDto category);
}
