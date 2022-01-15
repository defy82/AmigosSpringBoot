package com.example.amigosspringboot.api;

import com.example.amigosspringboot.model.Person;
import com.example.amigosspringboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@NotNull @Valid @RequestBody Person person) {
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id) {
        return personService.getPersonById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonByID(@PathVariable("id") UUID id) {
        personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePersonById(@NotNull @Valid @RequestBody Person person, @PathVariable("id") UUID id) {
        personService.updatePerson(id, person);
    }

}
