import {Component, EventEmitter, Output} from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {FormControl} from "@angular/forms";

@Component({
  selector: 'app-employee-form',
  standalone: true,
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './employee-form.component.html',
  styleUrl: './employee-form.component.css'
})
export class EmployeeFormComponent {

  employeeForm: FormGroup;

  // creates event to send Employees component (parent)
  @Output()
  closeEmployeeForm = new EventEmitter<void>();

  constructor(private employeeFb: FormBuilder) {

    this.employeeForm = this.employeeFb.group({
      firstName: ['', [Validators.required]],
      middleName: ['', [Validators.required]],
      lastName: ['', [Validators.required]],
      email: ['', [Validators.required]],
      phoneNumber: ['', [Validators.required]],
      state: ['', [Validators.required]],
      city: ['', [Validators.required]],
      zipCode: ['', [Validators.required]],
      streetAddress: ['', [Validators.required]],
      jobTitle: ['', [Validators.required]],
      dateOfHire: [Date, [Validators.required]],
      status: ['', [Validators.required]]
    });

  }


  submitEmployeeForm() {
  }


  onCloseEmployeeForm() {
    // emits the event to Employees (the parent), where the parent then changes the state to close the form
    this.closeEmployeeForm.emit();
  }

}
