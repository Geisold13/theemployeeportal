package com.the_employee_portal.Controller;

import com.the_employee_portal.Payload.Request.CreateEmployeeRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @PostMapping
    public ResponseEntity<?> createEmployee(@Valid @RequestBody CreateEmployeeRequest request) {

        return new ResponseEntity<>(HttpStatus.OK);
    }

    //@GetMapping getEmployee

    // @PostMapping createEmployee()

    // @PutMapping updateEmployee()

    // @DeleteMapping deleteEmployee()

    // @GetMapping getAllEmployees()
}
