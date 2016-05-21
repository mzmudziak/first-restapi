package com.mzmudziak.firstrestapi.controller;

import com.mzmudziak.firstrestapi.entity.Person;
import com.mzmudziak.firstrestapi.entity.request.AddPersonRequest;
import com.mzmudziak.firstrestapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {
    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Person> findAllPerson() {
        return personRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addPerson(@RequestParam(value = "firstName") String name, @RequestParam(value = "lastName") String surname) {
        AddPersonRequest rp = new AddPersonRequest();
        Person person = new Person();
        person.setFirstName(name);
        person.setLastName(surname);
        personRepository.save(person);
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public Person getPerson(@PathVariable long id) {
        return personRepository.findById(id);
    }

    @RequestMapping(value = "/name/{firstName}", method = RequestMethod.GET)
    public List<Person> getPersonByFirstName(@PathVariable String firstName) {
        return personRepository.findByFirstName(firstName);
    }

}
