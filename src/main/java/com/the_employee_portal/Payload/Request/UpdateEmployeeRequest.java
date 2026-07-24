package com.the_employee_portal.Payload.Request;

import com.the_employee_portal.DTO.EmployeeDTO;
import jakarta.validation.Valid;

public class UpdateEmployeeRequest {

    @Valid
    private EmployeeDTO employee;

    public UpdateEmployeeRequest(EmployeeDTO employee) {
        this.employee = employee;
    }

    public UpdateEmployeeRequest() {

    }

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }
}
