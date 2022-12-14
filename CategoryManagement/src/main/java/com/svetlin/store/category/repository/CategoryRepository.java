package com.svetlin.store.category.repository;

import com.svetlin.store.category.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "category")
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
