package de.it4ipm.mymapstruct.mapper;


import de.it4ipm.mymapstruct.dto.PersonDTO;
import de.it4ipm.mymapstruct.entity.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonMapperUnitTest {

    @Test
    public void givenPersonEntitytoPersonWithExpression_whenMaps_thenCorrect() {
        
        Person entity  = new Person();
        entity.setName("Micheal");
        
        PersonDTO personDto = PersonMapper.INSTANCE.personToPersonDTO(entity);

        assertNull(entity.getId());
        assertNotNull(personDto.getId());
        assertEquals(personDto.getName(), entity.getName());
    }

    @Test
    public void givenPersonEntityWithNullName_whenMaps_thenCorrect() {
        // Given a Person entity with no name set and no ID
        Person entity = new Person();
        entity.setId("1"); // Explicitly setting ID to null for clarity

        // When mapping to PersonDTO
        PersonDTO personDto = PersonMapper.INSTANCE.personToPersonDTO(entity);
        // And the name in PersonDTO should be the default value "anonymous"
        assertEquals("anonymous", personDto.getName());
    }
}
