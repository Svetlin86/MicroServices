package com.svetlin.store.category;

import com.svetlin.store.category.domain.Category;
import com.svetlin.store.category.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CategoryManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(CategoryManagementApplication.class, args);
    }

    @Bean
    CommandLineRunner run(CategoryRepository categoryRepository) {
        return args -> {
            categoryRepository.save(
                    new Category()
                            .setName("FOOD"));
            categoryRepository.save(
                    new Category()
                            .setName("ALCOHOL"));
            categoryRepository.save(
                    new Category()
                            .setName("BEVERAGES"));
            categoryRepository.save(
                    new Category()
                            .setName("CIGARETTES"));
            categoryRepository.save(
                    new Category()
                            .setName("SWEETS"));
            categoryRepository.save(
                    new Category()
                            .setName("DOMESTIC"));
            categoryRepository.save(
                    new Category()
                            .setName("AUTO"));
        };
    }
}
