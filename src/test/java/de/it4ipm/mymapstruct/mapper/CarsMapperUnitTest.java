package de.it4ipm.mymapstruct.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import de.it4ipm.mymapstruct.dto.CarDTO;
import de.it4ipm.mymapstruct.dto.FuelType;
import de.it4ipm.mymapstruct.entity.BioDieselCar;
import de.it4ipm.mymapstruct.entity.Car;
import de.it4ipm.mymapstruct.entity.ElectricCar;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;


class CarsMapperUnitTest {

    private final CarsMapper carsMapper = Mappers.getMapper(CarsMapper.class);

    @Test
    void testGivenSubTypeElectric_mapsModifiedFieldsToSuperTypeDto_whenBeforeAndAfterMappingMethodscarCalled() {
        Car car = new ElectricCar();
        car.setId(12);
        car.setName("Tesla_Model_C");
        
        CarDTO carDto = carsMapper.toCarDto(car);
        
        assertEquals("TESLA_MODEL_C", carDto.getName());
        assertEquals(FuelType.ELECTRIC, carDto.getFuelType());
    }
    
    @Test
    void testGivenSubTypeBioDiesel_mapsModifiedFieldsToSuperTypeDto_whenBeforeAndAfterMappingMethodscarCalled() {
        Car car = new BioDieselCar();
        car.setId(11);
        car.setName("Tesla_Model_X");
        
        CarDTO carDto = carsMapper.toCarDto(car);
        
        assertEquals("TESLA_MODEL_X", carDto.getName());
        assertEquals(FuelType.BIO_DIESEL, carDto.getFuelType());
    }

}
