package com.svetlin.store.person.service;

import com.svetlin.store.person.dto.CreatePersonDto;
import com.svetlin.store.person.dto.GetPersonDto;
import com.svetlin.store.person.dto.UpdatePersonDto;

import java.util.List;

public interface PersonService {

    GetPersonDto getById(Long id);

    List<GetPersonDto> getAllPersons();

    CreatePersonDto createPerson(CreatePersonDto createPersonDto);

    UpdatePersonDto updatePerson(UpdatePersonDto updatePersonDto);
}
