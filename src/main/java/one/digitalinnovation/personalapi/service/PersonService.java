package one.digitalinnovation.personalapi.service;

import one.digitalinnovation.personalapi.dto.request.PersonDto;
import one.digitalinnovation.personalapi.dto.response.MessageResponseDto;
import one.digitalinnovation.personalapi.entity.Person;
import one.digitalinnovation.personalapi.exception.PersonNotFoundException;
import one.digitalinnovation.personalapi.mapper.PersonMapper;
import one.digitalinnovation.personalapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private final PersonMapper personRepository = PersonMapper.INSTANCE;

    @Autowired
    public  PersonService(PersonRepository personRepository){

        this.personRepository = personRepository;
    }

    public MessageResponseDto createPerson(PersonDto personDto){

        Person personToSave = personMapper.toModel(personDto);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDto.builder()
                .message("Created person with ID= "+ savedPerson.getId())
                .build();
    }

    public List<PersonDto> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(PersonMapper::toDto)
                .collect(Collectors.toList());
    }

    public PersonDto findById()  throws  PersonNotFoundException{

        personRepository.findByid(id).orElseThrow(()-> new PersonNotFoundException(id));

        return personMapper.toDto(optionalPerson.get());
    }
}
