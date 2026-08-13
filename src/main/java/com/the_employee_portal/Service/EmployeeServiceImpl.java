package com.the_employee_portal.Service;

import com.the_employee_portal.DTO.EmployeeDTO;
import com.the_employee_portal.Entity.Employee;
import com.the_employee_portal.Exception.EmployeeNotFoundException;
import com.the_employee_portal.Mapper.EmployeeMapper;
import com.the_employee_portal.Payload.Request.CreateEmployeeRequest;
import com.the_employee_portal.Payload.Request.UpdateEmployeeRequest;
import com.the_employee_portal.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    public EmployeeDTO createEmployee(CreateEmployeeRequest request) {
        Employee newEmployee = new Employee();
        employeeMapper.employeeDTOtoEmployee(request.getEmployee(), newEmployee);

        EmployeeDTO createdEmployee = employeeMapper.employeeToEmployeeDTO(employeeRepository.save(newEmployee));
        return createdEmployee;
    }

    public EmployeeDTO getEmployee(Long id) {

        EmployeeDTO employee = employeeMapper.employeeToEmployeeDTO(employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id)));
        return employee;
    }

    public List<EmployeeDTO> getAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();

        List<EmployeeDTO> employeeDTOList = new ArrayList<>();

        // for each loop iterates through each employee fetched from the database
        for (Employee employee : employees) {

            // copies Employee data to EmployeeDTO and then that DTO is saved into the DTO list
            EmployeeDTO employeeDTO = employeeMapper.employeeToEmployeeDTO(employee);
            employeeDTOList.add(employeeDTO);
        }

        return employeeDTOList;

    }

    public EmployeeDTO updateEmployee(Long id, UpdateEmployeeRequest request) {

        // finds the existing employee in the database
        Employee employeeToUpdate = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));

        // uses mapper method to update existing employee, doesn't need to return an Employee because of JPA/Hibernates persistence context keeps track of the employee passed into the method
        employeeMapper.updateEmployeeFromEmployeeDTO(request.getEmployee(), employeeToUpdate);

        EmployeeDTO updatedEmployeeDTO = employeeMapper.employeeToEmployeeDTO(employeeRepository.save(employeeToUpdate));
        return updatedEmployeeDTO;

    }

    public void deleteEmployee(Long id) {

        // ensures that there is an employee to delete in the first place
        Employee employeeToDelete = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        // deletes the fetched employee from the db
        employeeRepository.delete(employeeToDelete);
    }

    public void updateEmployeePhoto(Long id, MultipartFile photo) throws IOException {

        String fileName = "profile.jpg";
        String photoUrl = "/uploads/employees/" + id + "/" + fileName;

        Path destination = Paths.get(
                "C:/Users/17154/Desktop/uploads/employees/" + id + "/" + fileName
        );

        Files.createDirectories(destination.getParent());

        Files.copy(
          photo.getInputStream(),
          destination,
                StandardCopyOption.REPLACE_EXISTING
        );

        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        employee.setPhotoUrl(photoUrl);
        employeeRepository.save(employee);

    }
}
