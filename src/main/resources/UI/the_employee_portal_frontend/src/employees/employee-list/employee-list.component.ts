import {Component, EventEmitter, Input, Output} from '@angular/core';
import {NgForOf} from "@angular/common";
import {Employee} from "../../model/employee.model";

@Component({
  selector: 'app-employee-list',
  standalone: true,
  imports: [
    NgForOf
  ],
  templateUrl: './employee-list.component.html',
  styleUrl: './employee-list.component.css'
})
export class EmployeeListComponent {


  // creates event to send to Employees component (Parent)
  @Output()
  showEmployeeForm = new EventEmitter<void>();

  @Output()
  deleteEmployee = new EventEmitter<number>();

  @Input()
  employees: Employee[] = [];

  onAddEmployee(): void {
    // emits the Event to Employees (Parent), where parent can then change the state to show the form
    this.showEmployeeForm.emit();
  }

  onDeleteEmployee(employeeId: number) {
    this.deleteEmployee.emit(employeeId);
  }


}
