package de.it4ipm.mymapstruct.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private int id;
    private String name;
    private Division division;
    private Date startDt;
}
