package com.svetlin.store.person.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import jakarta.persistence.*;
import javax.validation.constraints.NotEmpty;
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
