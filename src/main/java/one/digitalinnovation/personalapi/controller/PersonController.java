package one.digitalinnovation.personalapi.controller;


import one.digitalinnovation.personalapi.dto.MessageResponseDto;
import one.digitalinnovation.personalapi.entity.Person;
import one.digitalinnovation.personalapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonRepository personRepository;

    @Autowired
    public  PersonController(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @PostMapping
    public MessageResponseDto createPerson(@RequestBody Person person){
        Person savedPerson = personRepository.save(person);
        return "API test";
    }
}
