package com.the_employee_portal.Service;


import com.the_employee_portal.DTO.EmployeeDTO;
import com.the_employee_portal.Payload.Request.CreateEmployeeRequest;
import com.the_employee_portal.Payload.Request.UpdateEmployeeRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface EmployeeService {

    EmployeeDTO createEmployee(CreateEmployeeRequest request);

    EmployeeDTO getEmployee(Long id);

    EmployeeDTO updateEmployee(Long id, UpdateEmployeeRequest request);

    void deleteEmployee(Long id);

    List<EmployeeDTO> getAllEmployees();

    void updateEmployeePhoto(Long id, MultipartFile photo) throws IOException;
}
