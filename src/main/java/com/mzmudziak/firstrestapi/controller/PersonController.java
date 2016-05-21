package com.mzmudziak.firstrestapi.controller;

import com.mzmudziak.firstrestapi.entity.Person;
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
    public List<Person> findPersonByFirstNameOrLastNameOrFindAll(@RequestParam(value = "firstName", required = false) String firstName, @RequestParam(value = "lastName", required = false) String lastName) {
        if (firstName == null && lastName == null)
        return personRepository.findAll();
        else if (lastName == null) {
            return personRepository.findByFirstName(firstName);
        } else if (firstName == null) {
            return personRepository.findByLastName(lastName);
        } else return personRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addPerson(@RequestParam(value = "firstName") String name, @RequestParam(value = "lastName") String surname) {
        Person person = new Person();
        person.setFirstName(name);
        person.setLastName(surname);
        personRepository.save(person);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person findPersonById(@PathVariable("id") long id) {
        return personRepository.findById(id);
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public long getCount() {
        return personRepository.count();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void removePersonById(@PathVariable long id) {
        personRepository.delete(id);
    }
}
