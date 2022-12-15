package com.svetlin.store.category.Service;

import com.svetlin.store.category.dto.CategoryDto;
import com.svetlin.store.category.dto.CategoryResource;

public interface CategoryService {

    CategoryDto getById(Long id);

    CategoryResource getAll();

}
