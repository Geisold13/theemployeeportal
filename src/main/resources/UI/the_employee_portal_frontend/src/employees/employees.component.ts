import { Component } from '@angular/core';
import {EmployeeListComponent} from "./employee-list/employee-list.component";
import {EmployeeFormComponent} from "./employee-form/employee-form.component";
import {NgIf} from "@angular/common";
import {Employee} from "../model/employee.model";
import {CreateEmployeeResponse} from "../model/create-employee-response";
import {OnInit} from "@angular/core";
import {EmployeeService} from "../services/employee.service";
import {GetEmployeesResponse} from "../model/get-employees-reponse";
import {EmployeeProfileComponent} from "./employee-profile/employee-profile.component";

@Component({
  selector: 'app-employees',
  standalone: true,
  imports: [
    EmployeeListComponent,
    EmployeeFormComponent,
    NgIf,
    EmployeeProfileComponent
  ],
  templateUrl: './employees.component.html',
  styleUrl: './employees.component.css'
})
export class EmployeesComponent implements OnInit{

  isEmployeeFormShowing: boolean = false;
  isEmployeeProfileShowing: boolean = false;

  employees: Employee[] = [];

  // ? means Employee can be undefined (may not exist)
  currentEmployee?: Employee = {
    employeeId: 0,
    firstName: "",
    middleName: "",
    lastName: "",
    email: "",
    phoneNumber: "",
    state: "",
    city: "",
    zipCode: "",
    streetAddress: "",
    jobTitle: "",
    dateOfHire: new Date(),
    dateOfTermination: null,
    status: ""
  }


  constructor(private employeeService: EmployeeService) {
  }

  ngOnInit() {
    this.loadEmployees();
  }

  loadEmployees() {

    this.employeeService.getAllEmployees().subscribe({

      next: (employees: GetEmployeesResponse) => {
          this.employees = employees.employees;
      },

      error: (error) => {

        console.error(error);
      }
    })
  }


  changeEmployeeFormVisibility() {
    this.isEmployeeFormShowing = !this.isEmployeeFormShowing;
  }

  onEmployeeCreated(employee: CreateEmployeeResponse) {
    var createdEmployee: Employee = employee.createdEmployee;
    this.employees.push(createdEmployee);
  }

  deleteEmployee(employeeId: number) {
    this.employeeService.deleteEmployee(employeeId).subscribe({

      next: ( ) => {
        this.employees = this.employees.filter(
          employee => employee.employeeId !== employeeId
        );

      },


      error: (err) => {
        console.error(err);
      }

    });
  }

  viewEmployeeProfile(employeeId: number) {
    this.isEmployeeProfileShowing = !this.isEmployeeProfileShowing;

    // sets current Employee to Employee with specific employee Id.  Uses the .find function to help filter through all employees
    this.currentEmployee = this.employees.find(employee => employee.employeeId = employeeId);

  }

  closeEmployeeProfile() {
    this.isEmployeeProfileShowing = false;
  }




}
