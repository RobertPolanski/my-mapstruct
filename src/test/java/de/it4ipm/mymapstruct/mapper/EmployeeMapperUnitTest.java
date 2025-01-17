package de.it4ipm.mymapstruct.mapper;

import de.it4ipm.mymapstruct.dto.DivisionDTO;
import de.it4ipm.mymapstruct.dto.EmployeeDTO;
import de.it4ipm.mymapstruct.dto.VolumeDTO;
import de.it4ipm.mymapstruct.entity.Address;
import de.it4ipm.mymapstruct.entity.AddressFactory;
import de.it4ipm.mymapstruct.entity.Division;
import de.it4ipm.mymapstruct.entity.Employee;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class EmployeeMapperUnitTest {

    EmployeeMapper mapper = Mappers.getMapper(EmployeeMapper.class);

    private static final String DATE_FORMAT = "dd-MM-yyyy HH:mm:ss";

    @Test
    public void givenEmployeeDTOWithDiffNameToEmployee_whenMaps_thenCorrect() {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setEmployeeId(1);
        dto.setEmployeeName("John");
        dto.setHeight(181);

        Employee entity = mapper.employeeDTOtoEmployee(dto);

        assertEquals(dto.getEmployeeId(), entity.getId());
        assertEquals(dto.getEmployeeName(), entity.getName());
        assertEquals(dto.getHeight(), entity.getHeight());
    }

    @Test
    public void givenEmployeeWithDiffNameToEmployeeDTO_whenMaps_thenCorrect() {
        Employee entity = new Employee();
        entity.setId(1);
        entity.setName("John");
        entity.setHeight(181);

        EmployeeDTO dto = mapper.employeeToEmployeeDTO(entity);

        assertEquals(entity.getId(), dto.getEmployeeId());
        assertEquals(entity.getName(), dto.getEmployeeName());
        assertEquals(entity.getHeight(), dto.getHeight());
        assertEquals(entity.getHeight(), dto.getVolume().volume());
        assertEquals("High", dto.getVolume().description());
    }

    @Test
    public void givenEmpDTONestedMappingToEmp_whenMaps_thenCorrect() {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setDivision(new DivisionDTO(1, "Division1"));
        dto.setVolume(new VolumeDTO(1, "Volume1"));

        AddressFactory addressFactory = new AddressFactory();
        Address factoryAddress = addressFactory.createAddress();

        Employee entity = mapper.employeeDTOtoEmployee(dto);

        assertEquals(dto.getDivision().getId(), entity.getDivision().getId());
        assertEquals(dto.getDivision().getName(), entity.getDivision().getName());
        assertEquals(factoryAddress.getCity(), entity.getAddress().getCity());
        assertEquals(factoryAddress.getStreet(), entity.getAddress().getStreet());
        assertEquals(factoryAddress.getZip(), entity.getAddress().getZip());
        assertEquals(180, entity.getHeight());
    }

    @Test
    public void givenEmployeeWithNestedMappingToEmployeeDTO_whenMaps_thenCorrect() {
        Employee entity = new Employee();
        entity.setDivision(new Division(1, "Division1"));
        entity.setHeight(181);

        EmployeeDTO dto = mapper.employeeToEmployeeDTO(entity);

        assertEquals(entity.getDivision().getId(), dto.getDivision().getId());
        assertEquals(entity.getDivision().getName(), dto.getDivision().getName());
        assertEquals(181, dto.getVolume().volume());
        assertEquals("High", dto.getVolume().description());
    }

    @Test
    public void givenEmployeeListToEmployeeDTOList_whenMaps_thenCorrect() {
        List<Employee> employeeList = new ArrayList<>();
        Employee emp = new Employee();
        emp.setId(1);
        emp.setName("EmpName");
        emp.setDivision(new Division(1, "Division1"));
        employeeList.add(emp);

        List<EmployeeDTO> employeeDtoList = mapper.convertEmployeeListToEmployeeDTOList(employeeList);
        EmployeeDTO employeeDTO = employeeDtoList.getFirst();
        assertEquals(employeeDTO.getEmployeeId(), emp.getId());
        assertEquals(employeeDTO.getEmployeeName(), emp.getName());
        assertEquals(employeeDTO.getDivision().getId(), emp.getDivision().getId());
        assertEquals(employeeDTO.getDivision().getName(), emp.getDivision().getName());
    }

    @Test
    public void givenEmployeeDTOListToEmployeeList_whenMaps_thenCorrect() {
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        EmployeeDTO empDTO = new EmployeeDTO();
        empDTO.setEmployeeId(1);
        empDTO.setEmployeeName("EmpName");
        empDTO.setDivision(new DivisionDTO(1, "Division1"));
        employeeDTOList.add(empDTO);

        List<Employee> employeeList = mapper.convertEmployeeDTOListToEmployeeList(employeeDTOList);
        Employee employee = employeeList.getFirst();
        assertEquals(employee.getId(), empDTO.getEmployeeId());
        assertEquals(employee.getName(), empDTO.getEmployeeName());
        assertEquals(employee.getDivision().getId(), empDTO.getDivision().getId());
        assertEquals(employee.getDivision().getName(), empDTO.getDivision().getName());
    }

    @Test
    public void givenEmpStartDtMappingToEmpDTO_whenMaps_thenCorrect() throws ParseException {
        Employee entity = new Employee();
        entity.setStartDt(new Date());

        EmployeeDTO dto = mapper.employeeToEmployeeDTO(entity);
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
        assertEquals(entity.getStartDt().toString(), format.parse(dto.getEmployeeStartDt()).toString());
    }

    @Test
    public void givenEmpDTOStartDtMappingToEmp_whenMaps_thenCorrect() throws ParseException {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setEmployeeStartDt("01-04-2016 01:00:00");

        Employee entity = mapper.employeeDTOtoEmployee(dto);
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
        assertEquals(format.parse(dto.getEmployeeStartDt()).toString(), entity.getStartDt().toString());
    }
}
