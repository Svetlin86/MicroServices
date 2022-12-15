package com.svetlin.store.category.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import java.util.ArrayList;
import java.util.List;

@Accessors(chain = true)
@Getter
@Setter
public class CategoryResource {

    public List<CategoryDto> categories = new ArrayList<>();

}
