package com.test.TestPerson.Controller;

import com.test.TestPerson.Model.Gender;
import com.test.TestPerson.Model.Person;
import com.test.TestPerson.Repository.PersonRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PersonControllerTest {
    @Autowired
    private PersonRepository personRepository;
    @Test
    @Order(1)
    @Rollback(value = false)
    void addPersonTest() {
        Person person = Person.builder()
                .id(1l)
                .name("ismail")
                .gender(Gender.MALE)
                .num(771889460)
                .email("ismail2001@email.com")
                .adress("casablanca")
                .build();
        personRepository.save(person);
        Assertions.assertThat(person.getId()).isGreaterThan(0);

    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updatePersonTest() {
        Person person = personRepository.findById(1l).get();
        person.setEmail("ismail2001@email.com");
        Person personUpdate =personRepository.save(person);
        Assertions.assertThat(personUpdate.getEmail()).isEqualTo("ismail2001@email.com");
    }

    @Test
    @Order(2)
   public void findPersonByIdTest() {
        Person person = personRepository.findById(1l).get();
        Assertions.assertThat((person.getId())).isEqualTo(1l);
    }

    @Test
    @Order(3)
    public void findAllPersonsTest() {
        List<Person> persons = personRepository.findAll();
        Assertions.assertThat(persons.size()).isGreaterThan(0);
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deletePersonTest() {
        Person person = personRepository.findById(1l).get();
        personRepository.delete(person);
        Person person1 = null;
        Optional<Person> optionalPerson = personRepository.findByEmail("ismail2001@email.com");
        if(optionalPerson.isPresent()){
            Assertions.assertThat(person1).isNull();
        }
    }
}

