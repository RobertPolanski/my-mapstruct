package de.it4ipm.mymapstruct.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CarDTO {
    private int id;
    private String name;
    private FuelType fuelType;
}
