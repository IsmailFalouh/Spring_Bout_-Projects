package com.test.TestPerson.Controller;

import com.test.TestPerson.Model.Person;
import com.test.TestPerson.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonService service;
    @PostMapping("/addPerson")
    public Person addPerson(@RequestBody Person person){
        return  service.addPerson(person);
    }
    @PutMapping("/update")
    public Person updatePerson(@RequestBody Person person){
        return  service.updatePerson(person);
    }

    @GetMapping("/Person/{id}")
    public Person findPersonById(@PathVariable int id){
        return service.getPersonById(id);
    }
    @GetMapping("/Person/{name}")
    public Person findPersonByName(@PathVariable String name){
        return service.getPersonByName(name);
    }
    @GetMapping("/Persons")
    public List<Person> findAllPersons(){
        return service.getPersons();
    }
    @DeleteMapping("/delete/{id}")
    public  String deletePerson(@PathVariable long id){
        return service.deletePerson(id);
    }





}
