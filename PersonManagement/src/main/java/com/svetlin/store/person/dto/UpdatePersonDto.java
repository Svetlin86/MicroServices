package com.svetlin.store.person.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Getter
@Setter
public class UpdatePersonDto {

    private Long id;

    private String username;

    private String password;
}
