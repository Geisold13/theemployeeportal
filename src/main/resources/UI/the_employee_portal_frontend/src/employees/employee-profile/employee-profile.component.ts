import {Component, EventEmitter, Input, Output} from '@angular/core';
import {NgClass, NgIf, NgStyle} from "@angular/common";
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {Employee} from "../../model/employee.model";
import {OnChanges} from "@angular/core";

@Component({
  selector: 'app-employee-profile',
  standalone: true,
  imports: [
    NgIf,
    NgClass,
    ReactiveFormsModule
  ],
  templateUrl: './employee-profile.component.html',
  styleUrl: './employee-profile.component.css'
})
export class EmployeeProfileComponent implements OnChanges{

  isGeneralInfoShowing: boolean = true;
  isContactInfoShowing: boolean = false;
  isPersonalInfoShowing: boolean = false;
  isEmploymentInfoShowing: boolean = false;

  editEmployeeForm: FormGroup;

  @Input() employee?: Employee;

  @Output()
  closeEmployeeProfile = new EventEmitter<void>;

  @Output()
  changeEmployeePhoto = new EventEmitter<any>;


  constructor(private editEmployeeFb: FormBuilder) {

    this.editEmployeeForm = this.editEmployeeFb.group({
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
      dateOfHire: [new Date(), [Validators.required]],
      status: ['', [Validators.required]],
      photoUrl: ['']
    });
  }

  ngOnChanges() {
    if (this.employee) {
      this.editEmployeeForm.patchValue({
        firstName: this.employee.firstName,
        middleName: this.employee.middleName,
        lastName: this.employee.lastName,
        email: this.employee.email,
        phoneNumber: this.employee.phoneNumber,
        state: this.employee.state,
        city: this.employee.city,
        zipCode: this.employee.zipCode,
        streetAddress: this.employee.streetAddress,
        jobTitle: this.employee.jobTitle,
        dateOfHire: this.employee.dateOfHire,
        status: this.employee.status,
        photoUrl: this.employee.photoUrl
      });
    }
    console.log(this.employee);
    this.editEmployeeForm.disable();

  }

  onClickEmployeePage(button: HTMLButtonElement) {


    let currentPage: string | null = button.textContent;

    if (currentPage === "General") {
      this.isGeneralInfoShowing = true;
      this.isContactInfoShowing = false;
      this.isPersonalInfoShowing = false;
      this.isEmploymentInfoShowing = false;
    }

    if (currentPage === "Contact Info") {
      this.isGeneralInfoShowing = false;
      this.isContactInfoShowing = true;
      this.isPersonalInfoShowing = false;
      this.isEmploymentInfoShowing = false;
    }

    if (currentPage === "Personal") {
      this.isGeneralInfoShowing = false;
      this.isContactInfoShowing = false;
      this.isPersonalInfoShowing = true;
      this.isEmploymentInfoShowing = false;
    }

    if (currentPage === "Employment") {
      this.isGeneralInfoShowing = false;
      this.isContactInfoShowing = false;
      this.isPersonalInfoShowing = false;
      this.isEmploymentInfoShowing = true;
    }

  }

  onToggleEditEmployee() {

    if (this.editEmployeeForm.disabled) {
      this.editEmployeeForm.enable();
    } else {
      this.editEmployeeForm.disable();
    }
  }

  onCloseEmployeeProfile() {
    this.closeEmployeeProfile.emit();
  }

  onChangeEmployeePhoto(event: Event) {
    const input = event.target as HTMLInputElement;
    const file = input.files?.[0];

    if (file) {
      const formData = new FormData();
      formData.append('photo', file);
      this.changeEmployeePhoto.emit(formData);
    }

  }


}
