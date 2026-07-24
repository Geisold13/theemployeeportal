package com.the_employee_portal.Payload.Response;

import com.the_employee_portal.DTO.EmployeeDTO;

public class GetEmployeeResponse {

    private EmployeeDTO employee;

    public GetEmployeeResponse(EmployeeDTO employee) {
        this.employee = employee;
    }

    public GetEmployeeResponse() {

    }

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }
}
