package one.digitalinnovation.personalapi.service;

import one.digitalinnovation.personalapi.dto.request.PersonDto;
import one.digitalinnovation.personalapi.dto.response.MessageResponseDto;
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

    public MessageResponseDto createPerson(PersonDto personDto){

        Person personToSave = Person.builder()
                .firstName(personDto.getFirstName())
                .lastName(personDto.getLastName())
                .birthDate(personDto.getBirthDate())
                .phones(personDto.getPhones())
                .build();
        Person savedPerson = personRepository.save(personDto);
        return MessageResponseDto.builder()
                .message("Created person with ID= "+ savedPerson.getId())
                .build();
    }

}
