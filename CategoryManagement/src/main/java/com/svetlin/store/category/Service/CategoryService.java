package com.svetlin.store.category.Service;

import com.svetlin.store.category.dto.CategoryDto;
import java.util.List;

public interface CategoryService {

    CategoryDto getById(Long id);

    String create(CategoryDto category);

    List<CategoryDto> getAllCategories();

    String updateCategory (CategoryDto category);

}
