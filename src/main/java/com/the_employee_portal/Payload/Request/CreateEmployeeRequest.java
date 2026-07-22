package com.the_employee_portal.Payload.Request;

import com.the_employee_portal.DTO.EmployeeDTO;
import jakarta.validation.Valid;

public class CreateEmployeeRequest {

    @Valid
    private EmployeeDTO employee;

    public CreateEmployeeRequest() {

    }

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }
}
