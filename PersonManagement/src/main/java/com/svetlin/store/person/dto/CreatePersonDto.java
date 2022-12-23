package com.svetlin.store.person.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Getter
@Setter
public class CreatePersonDto {

    private Long id;

    private String name;

    private String username;

    private String password;
}
