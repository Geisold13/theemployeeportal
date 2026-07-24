package com.the_employee_portal.Controller;

import com.the_employee_portal.DTO.EmployeeDTO;
import com.the_employee_portal.Payload.Request.CreateEmployeeRequest;
import com.the_employee_portal.Payload.Request.UpdateEmployeeRequest;
import com.the_employee_portal.Payload.Response.CreateEmployeeResponse;
import com.the_employee_portal.Payload.Response.GetAllEmployeesResponse;
import com.the_employee_portal.Payload.Response.GetEmployeeResponse;
import com.the_employee_portal.Payload.Response.UpdateEmployeeResponse;
import com.the_employee_portal.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.boot.micrometer.observation.autoconfigure.ObservationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Request method responsible for taking create employee requests and transporting to service to be saved and then returns back to client
     * @param request - JSON full of employee creation data
     * @return - newly created employee saved into EmployeeDTO inside of the CreateEmployeeResponse
     */
    @PostMapping
    public ResponseEntity<CreateEmployeeResponse> createEmployee(@Valid @RequestBody CreateEmployeeRequest request) {

        EmployeeDTO createdEmployee = employeeService.createEmployee(request); // newly saved employee from service saved into a DTO to be transferred back to client

        return ResponseEntity.status(HttpStatus.CREATED).body(new CreateEmployeeResponse(createdEmployee)); // returns 201 created, with newly saved employee inside of DTO
    }


    /**
     * Request method is responsible for retrieving GET requests that have id in url to fetch employee
     * @param id - id of the employee
     * @return - 200 status with fetched employee
     */
    @GetMapping("/{id}")
    public ResponseEntity<GetEmployeeResponse> getEmployeeById(@PathVariable Long id){

        EmployeeDTO employee = employeeService.getEmployee(id);

        return ResponseEntity.status(HttpStatus.OK).body(new GetEmployeeResponse(employee));
    }

    /**
     * Request method is responsible for retrieving PUT requests that have an employee id and its contents that need to be updated
     * @param id - id of the employee
     * @param request - contains updated employee information
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody UpdateEmployeeRequest request) {

        EmployeeDTO employee = employeeService.updateEmployee(id, request);

        return ResponseEntity.status(HttpStatus.OK).body(new UpdateEmployeeResponse(employee));
    }

    /**
     * Request method is responsible for retrieving DELETE requests that have an employee id in url to delete an employee
     * @param id - id of employee thats wanting to be deleted
     * @return - 204 No content
     */
    @DeleteMapping ("/{id}")// responseEntity has void because we are returning no response body for deleting an employee
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {

        employeeService.deleteEmployee(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // Returns HTTP status 204 (no content) if successfully deleted.
   }

    /**
     * Request method is responsible for retrieving GET requests to fetch all employees
     * @return - all employees
     */
    @GetMapping
    public ResponseEntity<GetAllEmployeesResponse> getAllEmployees() {

        List<EmployeeDTO> employees = employeeService.getAllEmployees();

        return ResponseEntity.status(HttpStatus.OK).body(new GetAllEmployeesResponse(employees));
    }


}
