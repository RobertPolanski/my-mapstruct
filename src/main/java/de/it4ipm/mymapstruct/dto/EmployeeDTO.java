package de.it4ipm.mymapstruct.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private int employeeId;
    private String employeeName;
    private Integer height;
    private String graduation;
    private DivisionDTO division;
    private String employeeStartDt;
    private String notMappedProperty;
    private VolumeDTO volume;
    private boolean outsider;
}
