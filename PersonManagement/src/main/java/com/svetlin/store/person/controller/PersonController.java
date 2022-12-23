package com.svetlin.store.person.controller;

import com.svetlin.store.person.dto.CreatePersonDto;
import com.svetlin.store.person.dto.GetPersonDto;
import com.svetlin.store.person.dto.UpdatePersonDto;
import com.svetlin.store.person.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("/{id}")
    public ResponseEntity<GetPersonDto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(personService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<GetPersonDto>> getAllPersons() {
        return ResponseEntity.ok().body(personService.getAllPersons());
    }

    @PostMapping
    public ResponseEntity<CreatePersonDto> createPerson(@RequestBody CreatePersonDto createPersonDto) {
        return ResponseEntity.status(CREATED).body(personService.createPerson(createPersonDto));
    }

    @PutMapping
    public ResponseEntity<UpdatePersonDto> updatePerson(@RequestBody UpdatePersonDto updatePersonDto) {
        return ResponseEntity.ok().body(personService.updatePerson(updatePersonDto));
    }
}
