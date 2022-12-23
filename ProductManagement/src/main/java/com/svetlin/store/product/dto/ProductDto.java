package com.svetlin.store.product.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Accessors(chain = true)
@Getter
@Setter
public class ProductDto {

    private Long id;

    private String name;

    private BigDecimal price;

    private int quantity;
}
