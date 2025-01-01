package de.it4ipm.mymapstruct.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import de.it4ipm.mymapstruct.dto.CarDTO;
import de.it4ipm.mymapstruct.entity.Car;
import org.junit.jupiter.api.Test;


public class CarMapperUnitTest {

    @Test
    public void givenCarEntitytoCar_whenMaps_thenCorrect() {
        
        Car entity  = new Car();
        entity.setId(1);
        entity.setName("Toyota");
        
        CarDTO carDto = CarMapper.INSTANCE.carToCarDTO(entity);

        assertEquals(carDto.getId(), entity.getId());
        assertEquals(carDto.getName(), entity.getName());
    }
}
