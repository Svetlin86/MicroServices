package com.svetlin.store.person.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Accessors(chain = true)
@Getter
@Setter
public class Person {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

//    @Version
//    private Long version;

    private String name;

    @Column(unique = true, name = "username")
    private String username;

    @NotEmpty(message = "Please enter your password")
    private String password;

//    @ManyToMany(fetch = EAGER)
//    private List<Role> roles = new ArrayList<>();
}
