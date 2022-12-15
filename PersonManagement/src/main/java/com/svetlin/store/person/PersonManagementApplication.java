package com.svetlin.store.person;

import com.svetlin.store.person.domain.Person;
import com.svetlin.store.person.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EntityScan({"com.svetlin.store.person","com.svetlin.store.person.domain"})
public class PersonManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(PersonManagementApplication.class, args);
    }

    @Bean
    CommandLineRunner run(PersonRepository personRepository) {
        return args -> {
            personRepository.save(
                    new Person(null,"John Doe","John123","letmein")
            );
            personRepository.save(
                    new Person(null,"Jane Doe","Jane123","letmein")
            );
        };
    }
}
