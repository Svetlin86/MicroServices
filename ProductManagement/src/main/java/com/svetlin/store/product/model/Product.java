package com.svetlin.store.product.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "PRODUCT")
@Accessors(chain = true)
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(unique = true, name = "NAME")
    @NotEmpty(message = "Please specify the name of the product")
    private String name;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "QUANTITY")
    private int quantity;

//       @Version
//    private Long version;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "CATEGORY_ID")
//    private Category category;

}
