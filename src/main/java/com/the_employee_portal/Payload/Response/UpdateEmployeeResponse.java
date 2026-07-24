package com.the_employee_portal.Payload.Response;


import com.the_employee_portal.DTO.EmployeeDTO;

public class UpdateEmployeeResponse {

    private EmployeeDTO updatedEmployee;

    public UpdateEmployeeResponse(EmployeeDTO updatedEmployee){
        this.updatedEmployee = updatedEmployee;
    }

    public UpdateEmployeeResponse() {

    }

    public EmployeeDTO getUpdatedEmployee() {
        return updatedEmployee;
    }

    public void setUpdatedEmployee(EmployeeDTO updatedEmployee) {
        this.updatedEmployee = updatedEmployee;
    }
}
