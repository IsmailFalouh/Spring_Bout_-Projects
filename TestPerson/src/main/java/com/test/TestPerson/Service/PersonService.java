package com.test.TestPerson.Service;

import com.test.TestPerson.Model.Person;
import com.test.TestPerson.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;
    public Person addPerson(Person person){
        return repository.save(person);
    }

    public Person updatePerson(Person person){
        Person existingPerson=repository.findById(person.getId()).orElse(null);
        existingPerson.setName(person.getName());
        existingPerson.setGender(person.getGender());
        existingPerson.setAdress(person.getAdress());
        existingPerson.setEmail(person.getEmail());
        existingPerson.setNum(person.getNum());
        return repository.save(existingPerson);
    }

    public Person getPersonById( long id){
        return repository.findById(id).orElse(null);
    }

    public Person getPersonByName(String name){
        return repository.findByName(name);
    }

    public List<Person> getPersons(){
        return repository.findAll();
    }
    public  String deletePerson(long id){
        repository.deleteById(id);
        return "Person removed !!"+id;
    }

}
