package com.svetlin.store.category.Service;

import com.svetlin.store.category.dto.CategoryDto;
import com.svetlin.store.category.model.Category;
import com.svetlin.store.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public CategoryDto getById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException(String.format("Category with id %d not found", id)));

        return new CategoryDto()
                .setId(category.getId())
                .setName(category.getName());
    }

    @Override
    public String create(CategoryDto categoryDto) {
        if (categoryRepository.findById(categoryDto.getId()).isPresent()) {
            return "Category exists!";
        }

        Category category = modelMapper.map(categoryDto, Category.class);
        categoryRepository.save(category);
        return "Category created successfully!";
    }

    @Override
    public List<CategoryDto> getAllCategories() {

        List<Category> categories = categoryRepository.findAll();
        return categories
                .stream()
                .map(category -> modelMapper.map(category, CategoryDto.class))
                .toList();
    }

    @Override
    public String updateCategory(CategoryDto categoryDto) {

        Category category = modelMapper.map(categoryDto, Category.class);
        categoryRepository.save(category);
        return "Category updated successfully!";
    }
}
