package com.svetlin.store.person.service;

import com.svetlin.store.person.dto.PersonDto;

import java.util.List;

public interface PersonService {

    PersonDto getById(Long id);

    List<PersonDto> getAllPersons();

    PersonDto createPerson(PersonDto createPersonDto);

    PersonDto updatePerson(PersonDto updatePersonDto);
}
