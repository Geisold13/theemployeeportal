package com.the_employee_portal.Mapper;

import com.the_employee_portal.DTO.EmployeeDTO;
import com.the_employee_portal.Entity.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMapper {

    public EmployeeMapper() {
    }

    public void employeeDTOtoEmployee(EmployeeDTO employeeDTO, Employee employee) {

        //Employee employee = new Employee();
        //employee.setEmployeeId(employeeDTO.getEmployeeId());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setMiddleName(employeeDTO.getMiddleName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setPhoneNumber(employeeDTO.getPhoneNumber());
        employee.setState(employeeDTO.getState());
        employee.setCity(employeeDTO.getCity());
        employee.setZipCode(employeeDTO.getZipCode());
        employee.setStreetAddress(employeeDTO.getStreetAddress());
        employee.setDateOfHire(employeeDTO.getDateOfHire());
        employee.setDateOfTermination(employeeDTO.getDateOfTermination());
        employee.setStatus(employeeDTO.getStatus());
        employee.setJobTitle(employeeDTO.getJobTitle());

    }

    public EmployeeDTO employeeToEmployeeDTO(Employee employee) {


        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setEmployeeId(employee.getEmployeeId());
        employeeDTO.setFirstName(employee.getFirstName());
        employeeDTO.setMiddleName(employee.getMiddleName());
        employeeDTO.setLastName(employee.getLastName());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setPhoneNumber(employee.getPhoneNumber());
        employeeDTO.setState(employee.getState());
        employeeDTO.setCity(employee.getCity());
        employeeDTO.setZipCode(employee.getZipCode());
        employeeDTO.setStreetAddress(employee.getStreetAddress());
        employeeDTO.setDateOfHire(employee.getDateOfHire());
        employeeDTO.setDateOfTermination(employee.getDateOfTermination());
        employeeDTO.setStatus(employee.getStatus());
        employeeDTO.setJobTitle(employee.getJobTitle());

        return employeeDTO;
    }

    public void updateEmployeeFromEmployeeDTO(EmployeeDTO updatedEmployeeDTO, Employee employeeToUpdate) {


        employeeToUpdate.setFirstName(updatedEmployeeDTO.getFirstName());
        employeeToUpdate.setMiddleName(updatedEmployeeDTO.getMiddleName());
        employeeToUpdate.setLastName(updatedEmployeeDTO.getLastName());
        employeeToUpdate.setEmail(updatedEmployeeDTO.getEmail());
        employeeToUpdate.setPhoneNumber(updatedEmployeeDTO.getPhoneNumber());
        employeeToUpdate.setState(updatedEmployeeDTO.getState());
        employeeToUpdate.setCity(updatedEmployeeDTO.getCity());
        employeeToUpdate.setZipCode(updatedEmployeeDTO.getZipCode());
        employeeToUpdate.setStreetAddress(updatedEmployeeDTO.getStreetAddress());
        employeeToUpdate.setDateOfHire(updatedEmployeeDTO.getDateOfHire());
        employeeToUpdate.setDateOfTermination(updatedEmployeeDTO.getDateOfTermination());
        employeeToUpdate.setStatus(updatedEmployeeDTO.getStatus());
        employeeToUpdate.setJobTitle(updatedEmployeeDTO.getJobTitle());

    }
}
