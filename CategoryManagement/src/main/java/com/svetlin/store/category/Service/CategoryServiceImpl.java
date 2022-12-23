package com.svetlin.store.category.Service;

import com.svetlin.store.category.dto.CategoryDto;
import com.svetlin.store.category.exception.BadRequestException;
import com.svetlin.store.category.model.Category;
import com.svetlin.store.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public CategoryDto getById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(
                        () -> new BadRequestException(String.format("Category with id %d not found", id)));

        return modelMapper.map(category, CategoryDto.class);
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
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class);
        Category savedCategory = categoryRepository.save(category);

        return modelMapper.map(savedCategory, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto) {
        if (categoryDto.getId() == null) {
            throw new RuntimeException("The id must not be null");
        }
        Optional<Category> maybeCategory = categoryRepository.findById(categoryDto.getId());
        if (maybeCategory.isPresent()) {
            Category category = modelMapper.map(categoryDto, Category.class);
            Category updatedCategory = categoryRepository.save(category);
            return modelMapper.map(updatedCategory, CategoryDto.class);
        }
        throw new RuntimeException("Category with id does not exist");
    }
}
