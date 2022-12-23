package com.svetlin.store.person.service;

import com.svetlin.store.person.dto.PersonDto;
import com.svetlin.store.person.exception.BadRequestException;
import com.svetlin.store.person.model.Person;
import com.svetlin.store.person.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final ModelMapper modelMapper= new ModelMapper();

    @Override
    public PersonDto getById(Long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(
                        () -> new BadRequestException(String.format("Person with id %d not found", id)));

        return modelMapper.map(person, PersonDto.class);
    }

    @Override
    public List<PersonDto> getAllPersons() {
        List<Person> personList = personRepository.findAll();

        return personList
                .stream()
                .map(person -> modelMapper.map(person, PersonDto.class))
                .toList();
    }

    @Override
    public PersonDto createPerson(PersonDto createPersonDto) {
        Person person = modelMapper.map(createPersonDto, Person.class);
        Person createdPerson = personRepository.save(person);

        return modelMapper.map(createdPerson, PersonDto.class);
    }

    @Override
    public PersonDto updatePerson(PersonDto updatePersonDto) {
        if (updatePersonDto.getId() == null) {
            throw new RuntimeException("The id must not be null");
        }
        Optional<Person> maybePerson = personRepository.findById(updatePersonDto.getId());
        if (maybePerson.isPresent()) {
            Person person = modelMapper.map(updatePersonDto, Person.class);
            Person updatedPerson = personRepository.save(person);

            return modelMapper.map(updatedPerson, PersonDto.class);
        }
        throw new RuntimeException("Person with id %d does not exist");
    }
}
