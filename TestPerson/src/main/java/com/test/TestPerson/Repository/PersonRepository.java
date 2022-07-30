package com.test.TestPerson.Repository;

import com.test.TestPerson.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository  extends JpaRepository<Person, Long> {
    Person findByName(String name);
    Optional<Person> findByEmail(String emaol);
}
