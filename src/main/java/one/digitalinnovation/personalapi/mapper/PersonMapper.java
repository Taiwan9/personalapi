package one.digitalinnovation.personalapi.mapper;

import one.digitalinnovation.personalapi.dto.request.PersonDto;
import one.digitalinnovation.personalapi.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDto personDto);
    PersonDto toDto(Person person);

}
