package com.svetlin.store.product.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Entity
@Table(name = "PRODUCT")
@Accessors(chain = true)
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

//    @Version
//    private Long version;

    @Column(unique = true, name = "NAME")
    @NotEmpty(message = "Please specify the name of the product")
    private String name;

    @Column(name = "PRICE")
    private BigDecimal price;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "CATEGORY_ID")
//    private Category category;

    @Column(name = "QUANTITY")
    private int quantity;
}
