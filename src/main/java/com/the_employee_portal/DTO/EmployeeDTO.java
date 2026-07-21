package com.the_employee_portal.DTO;

import jakarta.persistence.Column;

import java.time.LocalDate;

// used for transporting employee data between layers
public class EmployeeDTO {

    private long employeeId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String state;
    private String city;
    private String zipCode;
    private String streetAddress;
    private String jobTitle;
    private LocalDate dateOfHire; // Format off Month, Day, Year
    private LocalDate dateOfTermination;
    private String status;

    public EmployeeDTO() {

    }
}
