package com.the_employee_portal.Service;

import com.the_employee_portal.DTO.EmployeeDTO;
import com.the_employee_portal.Entity.Employee;
import com.the_employee_portal.Exception.EmployeeNotFoundException;
import com.the_employee_portal.Mapper.EmployeeMapper;
import com.the_employee_portal.Payload.Request.CreateEmployeeRequest;
import com.the_employee_portal.Payload.Request.UpdateEmployeeRequest;
import com.the_employee_portal.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    public EmployeeDTO createEmployee(CreateEmployeeRequest request) {

        Employee newEmployee = employeeMapper.employeeDTOtoEmployee(request.getEmployee());

        EmployeeDTO createdEmployee = employeeMapper.employeeToEmployeeDTO(employeeRepository.save(newEmployee));
        return createdEmployee;
    }

    public EmployeeDTO getEmployee(Long id) {

        EmployeeDTO employee = employeeMapper.employeeToEmployeeDTO(employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id)));
        return employee;
    }

    public EmployeeDTO updateEmployee(Long id, UpdateEmployeeRequest request) {

        // finds the existing employee in the database
        Employee employeeToUpdate = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));

        // uses mapper method to update existing employee, doesn't need to return an Employee because of JPA/Hibernates persistence context keeps track of the employee passed into the method
        employeeMapper.updateEmployeeFromEmployeeDTO(request.getEmployee(), employeeToUpdate);

        EmployeeDTO updatedEmployeeDTO = employeeMapper.employeeToEmployeeDTO(employeeRepository.save(employeeToUpdate));
        return updatedEmployeeDTO;

    }
}
