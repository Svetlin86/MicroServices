package com.svetlin.store.category.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Getter
@Setter
public class CategoryDto {

    private Long id;
    private String name;

//    public static CategoryDto from(Category category) {
//        return new CategoryDto()
//                .setId(category.getId())
//                .setName(category.getName());
//    }
}
