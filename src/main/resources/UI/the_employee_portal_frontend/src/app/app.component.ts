import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {EmployeesComponent} from "../employees/employees.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, EmployeesComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'the_employee_portal_frontend';
}
