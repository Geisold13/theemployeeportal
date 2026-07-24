package com.the_employee_portal.Controller;

import com.the_employee_portal.DTO.EmployeeDTO;
import com.the_employee_portal.Payload.Request.CreateEmployeeRequest;
import com.the_employee_portal.Payload.Request.UpdateEmployeeRequest;
import com.the_employee_portal.Payload.Response.CreateEmployeeResponse;
import com.the_employee_portal.Payload.Response.GetEmployeeResponse;
import com.the_employee_portal.Payload.Response.UpdateEmployeeResponse;
import com.the_employee_portal.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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



    @GetMapping("/{id}")
    public ResponseEntity<GetEmployeeResponse> getEmployeeById(@PathVariable Long id){

        EmployeeDTO employee = employeeService.getEmployee(id);

        return ResponseEntity.status(HttpStatus.OK).body(new GetEmployeeResponse(employee));
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody UpdateEmployeeRequest request) {

        EmployeeDTO employee = employeeService.updateEmployee(id, request);

        return ResponseEntity.status(HttpStatus.OK).body(new UpdateEmployeeResponse(employee));
    }

    // @DeleteMapping deleteEmployee()
   // public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {

   //}

  //  @GetMapping
  //  public ResponseEntity<?> getAllEmployees() {

   // }
  //  */

}
