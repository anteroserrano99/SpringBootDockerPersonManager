package com.project.antero.personmanager.api;

import com.project.antero.personmanager.model.Person;
import com.project.antero.personmanager.service.PersonService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople(){
        List<Person> personas =personService.getAllPeople();
        return personas;
    }

    @GetMapping(path = "{id}")
    public Person getPersonbyID(@PathVariable("id") UUID id){
        return  personService.getPersonById(id)
                .orElse(null);
    }

    @PutMapping()
    public void updatePerson(@NotNull @RequestBody Person person){
         personService.updatePerson(person);
    }

    @DeleteMapping(path = "{id}")
    public void deletePerson(@PathVariable("id") UUID id){
        personService.deletePerson(id);
    }

}
