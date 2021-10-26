package one.digitalinnovation.personalapi.service;

import one.digitalinnovation.personalapi.dto.MessageResponseDto;
import one.digitalinnovation.personalapi.entity.Person;
import one.digitalinnovation.personalapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private PersonRepository personRepository;

    @Autowired
    public  PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public MessageResponseDto createPerson(Person person){
        Person savedPerson = personRepository.save(person);
        return MessageResponseDto.builder()
                .message("Created person with ID= "+ savedPerson.getId())
                .build();
    }

}
