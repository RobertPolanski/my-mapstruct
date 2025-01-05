package de.it4ipm.mymapstruct.mapper;

import de.it4ipm.mymapstruct.dto.DivisionDTO;
import de.it4ipm.mymapstruct.dto.EmployeeDTO;
import de.it4ipm.mymapstruct.entity.Division;
import de.it4ipm.mymapstruct.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    @Mapping(target = "employeeId", source = "entity.id")
    @Mapping(target = "employeeName", source = "entity.name")
    @Mapping(target = "employeeStartDt", source = "entity.startDt", dateFormat = "dd-MM-yyyy HH:mm:ss")
    @Mapping(target = "notMappedProperty", ignore = true)
    EmployeeDTO employeeToEmployeeDTO(Employee entity);

    @Mapping(target = "id", source = "dto.employeeId")
    @Mapping(target = "name", source = "dto.employeeName")
    @Mapping(target = "startDt", source = "dto.employeeStartDt", dateFormat = "dd-MM-yyyy HH:mm:ss")
    Employee employeeDTOtoEmployee(EmployeeDTO dto);

    DivisionDTO divisionToDivisionDTO(Division entity);

    Division divisionDTOtoDivision(DivisionDTO dto);

    List<Employee> convertEmployeeDTOListToEmployeeList(List<EmployeeDTO> list);

    List<EmployeeDTO> convertEmployeeListToEmployeeDTOList(List<Employee> list);

}
