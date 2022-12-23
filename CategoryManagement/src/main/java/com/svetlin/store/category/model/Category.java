package com.svetlin.store.category.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "CATEGORY")
@Accessors(chain = true)
@Getter
@Setter
public class Category {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;
}
