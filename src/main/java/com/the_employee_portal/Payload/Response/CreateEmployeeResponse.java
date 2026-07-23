package com.the_employee_portal.Payload.Response;

import com.the_employee_portal.DTO.EmployeeDTO;

public class CreateEmployeeResponse {

    private EmployeeDTO createdEmployee;

    public CreateEmployeeResponse(EmployeeDTO createdEmployee) {
        this.createdEmployee = createdEmployee;
    }

    public CreateEmployeeResponse() {

    }

    public EmployeeDTO getCreatedEmployee() {
        return createdEmployee;
    }

    public void setCreatedEmployee(EmployeeDTO createdEmployee) {
        this.createdEmployee = createdEmployee;
    }
}
