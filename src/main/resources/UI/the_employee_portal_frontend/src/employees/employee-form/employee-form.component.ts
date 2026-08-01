import {Component, EventEmitter, Output} from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {FormControl} from "@angular/forms";
import {NgForOf, NgIf} from "@angular/common";
import {StateList} from "../../enums/state-list.enum";
import {StatusList} from "../../enums/status-list.enum";
import {CreateEmployeeRequest} from "../../model/create-employee-request.model";
import {EmployeeService} from "../../services/employee.service";

@Component({
  selector: 'app-employee-form',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    NgIf,
    NgForOf
  ],
  templateUrl: './employee-form.component.html',
  styleUrl: './employee-form.component.css'
})
export class EmployeeFormComponent {

  employeeForm: FormGroup;

  // creates event to send Employees component (parent)
  @Output()
  closeEmployeeForm = new EventEmitter<void>();

  states = Object.values(StateList);
  statuses =  Object.values(StatusList);

  constructor(private employeeFb: FormBuilder, private employeeService: EmployeeService) {

    this.employeeForm = this.employeeFb.group({
      firstName: ['', [Validators.required, Validators.minLength(2), Validators.maxLength(50), Validators.pattern(/^[A-Za-z]+(?:[ '-][A-Za-z]+)*$/)]],
      middleName: ['', [Validators.required, Validators.minLength(2), Validators.maxLength(50), Validators.pattern(/^[A-Za-z]+(?:[ '-][A-Za-z]+)*$/)]],
      lastName: ['', [Validators.required, Validators.minLength(2), Validators.maxLength(50), Validators.pattern(/^[A-Za-z]+(?:[ '-][A-Za-z]+)*$/)]],
      email: ['', [Validators.required, Validators.minLength(6), Validators.maxLength(254), Validators.email]],
      phoneNumber: ['', [Validators.required, Validators.minLength(10), Validators.maxLength(12), Validators.pattern(/^\d{3}-?\d{3}-?\d{4}$/)]],
      state: ['', [Validators.required, Validators.minLength(2), Validators.maxLength(2)]],
      city: ['', [Validators.required, Validators.minLength(2), Validators.maxLength(50), Validators.pattern(/^[A-Za-z]+(?:[ .'-][A-Za-z]+)*$/)]],
      zipCode: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(5), Validators.pattern(/^\d{5}$/)]],
      streetAddress: ['', [Validators.required, Validators.minLength(2), Validators.maxLength(100), Validators.pattern(/^[A-Za-z0-9]+(?:[ .,'#/-][A-Za-z0-9]+)*$/)]],
      jobTitle: ['', [Validators.required, Validators.minLength(3), Validators.maxLength(50)]],
      dateOfHire: [Date, [Validators.required]],
      status: ['', [Validators.required]]
    });

  }


  submitEmployeeForm() {

    if (this.employeeForm.valid) {

      const request: CreateEmployeeRequest = {
        employee: this.employeeForm.value
      };


      this.employeeService.createEmployee(request).subscribe({

        next: (employee: any) => {

        },

        error: (error) => {
          console.error(error);
        }

      });

    }

  }


  onCloseEmployeeForm() {
    // emits the event to Employees (the parent), where the parent then changes the state to close the form
    this.closeEmployeeForm.emit();
  }

}
