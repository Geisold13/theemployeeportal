import {Component, EventEmitter, Output} from '@angular/core';
import {NgForOf} from "@angular/common";

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

  employees: number[] = [];

  // creates event to send to Employees component (Parent)
  @Output()
  showEmployeeForm = new EventEmitter<void>();


  onAddEmployee(): void {
    // emits the Event to Employees (Parent), where parent can then change the state to show the form
    this.showEmployeeForm.emit();
    //this.employees.push(1);
   // console.log(this.employees.length);
  }

}
