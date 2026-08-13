package com.the_employee_portal.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

// used for transporting employee data between layers
public class EmployeeDTO {

    @NotNull
    private long employeeId;

    @NotBlank
    private String firstName;

    @NotNull
    private String middleName; // middle name is optional, but cannot be null

    @NotBlank
    private String lastName;

    @NotBlank
    @Email(message = "Must be valid email format.") // must be valid email address format
    private String email;

    @NotBlank
    @Pattern(regexp = "^\\d{3}-?\\d{3}-?\\d{4}$", message = "Phone number must contain exactly 10 digits")
    private String phoneNumber;

    @NotBlank
    private String state;

    @NotBlank
    private String city;

    @NotBlank
    @Pattern(regexp = "^[0-9]{5}$", message = "Zip code must only contain exactly 5 digits")
    private String zipCode;

    @NotBlank
    private String streetAddress;

    @NotBlank
    private String jobTitle;

    @NotNull
    private LocalDate dateOfHire; // Format off Month, Day, Year

    //@NotNull
    private LocalDate dateOfTermination;

    @NotBlank
    private String status;

    private String photoUrl;

    public EmployeeDTO() {

    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public LocalDate getDateOfHire() {
        return dateOfHire;
    }

    public void setDateOfHire(LocalDate dateOfHire) {
        this.dateOfHire = dateOfHire;
    }

    public LocalDate getDateOfTermination() {
        return dateOfTermination;
    }

    public void setDateOfTermination(LocalDate dateOfTermination) {
        this.dateOfTermination = dateOfTermination;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
