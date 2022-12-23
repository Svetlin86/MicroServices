package com.svetlin.store.person.service;

import com.svetlin.store.person.dto.CreatePersonDto;
import com.svetlin.store.person.dto.GetPersonDto;
import com.svetlin.store.person.dto.UpdatePersonDto;
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
    private final ModelMapper modelMapper;

    @Override
    public GetPersonDto getById(Long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(
                        () -> new BadRequestException(String.format("Person with id %d not found", id)));

        return modelMapper.map(person, GetPersonDto.class);
    }

    @Override
    public List<GetPersonDto> getAllPersons() {
        List<Person> personList = personRepository.findAll();

        return personList
                .stream()
                .map(person -> modelMapper.map(person, GetPersonDto.class))
                .toList();
    }

    @Override
    public CreatePersonDto createPerson(CreatePersonDto createPersonDto) {
        Person person = modelMapper.map(createPersonDto, Person.class);
        Person createdPerson = personRepository.save(person);

        return modelMapper.map(createdPerson, CreatePersonDto.class);
    }

    @Override
    public UpdatePersonDto updatePerson(UpdatePersonDto updatePersonDto) {
        if (updatePersonDto.getId() == null) {
            throw new RuntimeException("The id must not be null");
        }
        Optional<Person> maybePerson = personRepository.findById(updatePersonDto.getId());
        if (maybePerson.isPresent()) {
            Person person = modelMapper.map(maybePerson, Person.class);
            Person updatedPerson = personRepository.save(person);

            return modelMapper.map(updatedPerson, UpdatePersonDto.class);
        }
        throw new RuntimeException("Person with id %d does not exist");
    }
}
