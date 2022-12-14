package com.svetlin.store.product.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import static javax.persistence.GenerationType.IDENTITY;
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
