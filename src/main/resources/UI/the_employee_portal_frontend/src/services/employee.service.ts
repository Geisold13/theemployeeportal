import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {CreateEmployeeRequest} from "../model/create-employee-request.model";
import {CreateEmployeeResponse} from "../model/create-employee-response";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private employeeApiUrl: string = "http://localhost:8080/api/employee";


  constructor(private http: HttpClient) {

  }

  createEmployee(request: CreateEmployeeRequest): Observable<CreateEmployeeResponse> {
    return this.http.post<CreateEmployeeResponse>(`${this.employeeApiUrl}`, request);
  }

  getEmployeeById() {

  }

  getAllEmployees() {

  }

  updateEmployee() {

  }

  deleteEmployee() {

  }
}
