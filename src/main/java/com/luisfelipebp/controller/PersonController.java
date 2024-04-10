package com.luisfelipebp.controller;

import com.luisfelipebp.models.Loans;
import com.luisfelipebp.models.Person;
import com.luisfelipebp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/customer-loans/{id}")
    public ResponseEntity<Optional<Person>> getPersonById(@PathVariable Integer id){
        return ResponseEntity.ok().body(personService.getPersonById(id));
    }

    @PostMapping("/customer-loans")
    public ResponseEntity<Loans> createPerson(@RequestBody Person person){
        return ResponseEntity.ok().body(personService.savePerson(person));
    }
}
