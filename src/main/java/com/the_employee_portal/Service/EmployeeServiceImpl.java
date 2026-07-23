package com.the_employee_portal.Service;

import com.the_employee_portal.DTO.EmployeeDTO;
import com.the_employee_portal.Entity.Employee;
import com.the_employee_portal.Mapper.EmployeeMapper;
import com.the_employee_portal.Payload.Request.CreateEmployeeRequest;
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
}
