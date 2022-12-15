package com.svetlin.store.category.Service;

import com.svetlin.store.category.dto.CategoryDto;
import com.svetlin.store.category.dto.CategoryResource;
import com.svetlin.store.category.model.Category;
import com.svetlin.store.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryDto getById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException(String.format("Category with id %d not found", id)));

        return new CategoryDto()
                .setId(category.getId())
                .setName(category.getName());
    }

    @Override
    public CategoryResource getAll() {
        List<Category> categories = categoryRepository
                .findAll(PageRequest.ofSize(10)).toList();

        return (CategoryResource) categories;
    }

    @Override
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }
}
