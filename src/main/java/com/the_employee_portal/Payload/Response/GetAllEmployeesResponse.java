package com.the_employee_portal.Payload.Response;

import com.the_employee_portal.DTO.EmployeeDTO;

import java.util.ArrayList;
import java.util.List;

public class GetAllEmployeesResponse {

    List<EmployeeDTO> employees;

    public GetAllEmployeesResponse() {

    }

    public GetAllEmployeesResponse(List<EmployeeDTO> employees) {
        this.employees = employees;
    }

    public List<EmployeeDTO> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDTO> employees) {
        this.employees = employees;
    }
}
