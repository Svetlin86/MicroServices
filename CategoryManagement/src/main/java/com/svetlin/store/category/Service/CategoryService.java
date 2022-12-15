package com.svetlin.store.category.Service;

import com.svetlin.store.category.dto.CategoryDto;
import com.svetlin.store.category.dto.CategoryResource;
import com.svetlin.store.category.model.Category;

public interface CategoryService {

    CategoryDto getById(Long id);

    CategoryResource getAll();

    Category create (Category category);

    Category updateCategory (Category category);


}
