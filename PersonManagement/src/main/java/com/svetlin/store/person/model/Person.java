package com.svetlin.store.person.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import jakarta.persistence.*;
import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Accessors(chain = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(unique = true, name = "NAME")
    private String name;

    @Column(name = "USERNAME")
    private String username;

    @NotEmpty(message = "Please enter your password")
    private String password;

//     @Version
//    private Long version;

//    @ManyToMany(fetch = EAGER)
//    private List<Role> roles = new ArrayList<>();
}
