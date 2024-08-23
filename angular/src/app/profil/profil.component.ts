import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employees/employees.service';
import { Employee } from '../employees/employees';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-profil',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './profil.component.html',
  styleUrl: './profil.component.css'
})
export class ProfilComponent implements OnInit{

  employee: Employee | undefined;
  errorMessage: string = '';

  constructor(private EmployeeService: EmployeeService) { }

  ngOnInit(): void {
    const employeeId = +localStorage.getItem('employeeId')!; // Get the employee ID from local storage

    if (employeeId) {
      this.EmployeeService.getEmployeeById(employeeId).subscribe(
        (data: Employee) => {
          this.employee = data;
        },
        (error) => {
          this.errorMessage = 'Unable to fetch profile data';
          console.error('Error fetching profile', error);
        }
      );
    } else {
      this.errorMessage = 'No employee ID found';
    }
  }
}
