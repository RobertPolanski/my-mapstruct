package de.it4ipm.mymapstruct.mapper;

import de.it4ipm.mymapstruct.dto.PersonDTO;
import de.it4ipm.mymapstruct.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface PersonMapper {
    
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
    
    @Mapping(target = "id", source = "person.id", defaultExpression = "java(java.util.UUID.randomUUID().toString())")
    @Mapping(target = "name", source = "person.name", defaultValue = "anonymous")
    PersonDTO personToPersonDTO(Person person);
}
