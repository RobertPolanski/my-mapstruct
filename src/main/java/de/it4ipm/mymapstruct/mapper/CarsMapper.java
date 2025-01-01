package de.it4ipm.mymapstruct.mapper;

import de.it4ipm.mymapstruct.dto.CarDTO;
import de.it4ipm.mymapstruct.dto.FuelType;
import de.it4ipm.mymapstruct.entity.BioDieselCar;
import de.it4ipm.mymapstruct.entity.Car;
import de.it4ipm.mymapstruct.entity.ElectricCar;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper
public abstract class CarsMapper {

    @BeforeMapping
    protected void enrichDTOWithFuelType(Car car, @MappingTarget CarDTO carDto) {
        if (car instanceof ElectricCar)
            carDto.setFuelType(FuelType.ELECTRIC);
        if (car instanceof BioDieselCar)
            carDto.setFuelType(FuelType.BIO_DIESEL);
    }

    @AfterMapping
    protected void convertNameToUpperCase(@MappingTarget CarDTO carDto) {
        carDto.setName(carDto.getName().toUpperCase());
    }

    public abstract CarDTO toCarDto(Car car);

}
