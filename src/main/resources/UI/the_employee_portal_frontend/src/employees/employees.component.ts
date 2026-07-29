import { Component } from '@angular/core';
import {EmployeeListComponent} from "./employee-list/employee-list.component";
import {EmployeeFormComponent} from "./employee-form/employee-form.component";
import {NgIf} from "@angular/common";

@Component({
  selector: 'app-employees',
  standalone: true,
  imports: [
    EmployeeListComponent,
    EmployeeFormComponent,
    NgIf
  ],
  templateUrl: './employees.component.html',
  styleUrl: './employees.component.css'
})
export class EmployeesComponent {

  isEmployeeFormShowing: boolean = false;


  changeEmployeeFormVisibility() {
    this.isEmployeeFormShowing = !this.isEmployeeFormShowing;
  }






}
