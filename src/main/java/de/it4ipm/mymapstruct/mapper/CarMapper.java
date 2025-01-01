package de.it4ipm.mymapstruct.mapper;

import de.it4ipm.mymapstruct.dto.CarDTO;
import de.it4ipm.mymapstruct.entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface CarMapper {
    
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);
    
    CarDTO carToCarDTO(Car car);
}
