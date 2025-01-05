package de.it4ipm.mymapstruct.mapper;

import de.it4ipm.mymapstruct.dto.DivisionDTO;
import de.it4ipm.mymapstruct.dto.EmployeeDTO;
import de.it4ipm.mymapstruct.dto.VolumeDTO;
import de.it4ipm.mymapstruct.entity.Address;
import de.it4ipm.mymapstruct.entity.AddressFactory;
import de.it4ipm.mymapstruct.entity.Division;
import de.it4ipm.mymapstruct.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(uses = {AddressFactory.class})
public abstract class EmployeeMapper {

    @Mapping(target = "employeeId", source = "entity.id")
    @Mapping(target = "employeeName", source = "entity.name")
    @Mapping(target = "employeeStartDt", source = "entity.startDt", dateFormat = "dd-MM-yyyy HH:mm:ss")
    @Mapping(target = "notMappedProperty", ignore = true)
    @Mapping(target = "volume", source = "entity")
    @Mapping(target = "outsider", source = "entity")
    public abstract EmployeeDTO employeeToEmployeeDTO(Employee entity);

    @Mapping(target = "id", source = "dto.employeeId")
    @Mapping(target = "name", source = "dto.employeeName")
    @Mapping(target = "startDt", source = "dto.employeeStartDt", dateFormat = "dd-MM-yyyy HH:mm:ss")
    @Mapping(target = "address", source = "dto")
    @Mapping(target = "height", defaultValue = "180")
    public abstract Employee employeeDTOtoEmployee(EmployeeDTO dto);

    protected abstract DivisionDTO divisionToDivisionDTO(Division entity);

    protected abstract Division divisionDTOtoDivision(DivisionDTO dto);

    public abstract List<Employee> convertEmployeeDTOListToEmployeeList(List<EmployeeDTO> list);

    public abstract List<EmployeeDTO> convertEmployeeListToEmployeeDTOList(List<Employee> list);

    protected VolumeDTO mapVolume(Employee entity) {
        if(entity.getHeight() > 180) {
            return new VolumeDTO(entity.getHeight(), "High");
        } else {
            return new VolumeDTO(entity.getHeight(), "Not High");
        }
    }

    public boolean mapOutsider(Employee entity) {
        //todo finish
        return true;
    }

    protected abstract Address mapAddress(EmployeeDTO dto);

}
