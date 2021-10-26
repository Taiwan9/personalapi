package one.digitalinnovation.personalapi.controller;


import one.digitalinnovation.personalapi.dto.request.PersonDto;
import one.digitalinnovation.personalapi.dto.response.MessageResponseDto;
import one.digitalinnovation.personalapi.entity.Person;
import one.digitalinnovation.personalapi.exception.PersonNotFoundException;
import one.digitalinnovation.personalapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDto createPerson(@RequestBody @Valid PersonDto personDto){
        return personService.createPerson(personDto);

    }

    @GetMapping
    public List<PersonDto> listAll(){
        return personService.listAll();

    }
    @GetMapping("/{id}")
    public PersonDto findbyId(@PathVariable Long id)throws PersonNotFoundException {
        return  personService.findById(id);
    }
}
