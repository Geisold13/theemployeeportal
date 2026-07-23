package com.the_employee_portal.Service;


import com.the_employee_portal.DTO.EmployeeDTO;
import com.the_employee_portal.Payload.Request.CreateEmployeeRequest;

public interface EmployeeService {

    EmployeeDTO createEmployee(CreateEmployeeRequest request);
}
