import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, NgForm } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { Employee } from './employees';
import { EmployeeService } from './employees.service';
import { HttpClient,HttpErrorResponse } from '@angular/common/http';
import { AdminService } from './admin.service';
import { Admin } from './admin';
import { TechnicianService } from './technician.service';
@Component({
  selector: 'app-employees',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule ],
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css']
})
export class EmployeesComponent implements OnInit {
  public employees: Employee[] = [];

  constructor(
    private employeeService: EmployeeService,
    private adminService: AdminService,
    private technicianService: TechnicianService 
  ) {}

  ngOnInit(): void {
    this.getEmployees();
  }

  public getEmployees(): void {
    this.employeeService.getAllEmployees().subscribe(
      (response: Employee[]) => {
        this.employees = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  openModal(event: Event, modalId: string): void {
    event.preventDefault();
    const modal = document.getElementById(modalId);
    if (modal) {
      modal.classList.add('show');
      modal.style.display = 'block';
      modal.setAttribute('aria-hidden', 'false');
      modal.setAttribute('aria-modal', 'true');
    }
  }

  closeModal(modalId: string): void {
    const modal = document.getElementById(modalId);
    if (modal) {
      modal.classList.remove('show');
      modal.style.display = 'none';
      modal.setAttribute('aria-hidden', 'true');
      modal.setAttribute('aria-modal', 'false');
    }
  }

  onAddEmployee(addForm: NgForm): void {
    const accountType = addForm.value.account_type;
    
    if (accountType === 'Employee') {
      this.employeeService.addEmployee(addForm.value).subscribe(
        (response: Employee) => {
          console.log('Employee added:', response);
          this.getEmployees();
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      );
    } else if (accountType === 'Admin') {
      this.adminService.addAdmin(addForm.value).subscribe(
        (response: Admin) => {
          console.log('Admin added:', response);
          this.getEmployees();
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      );
    } else if (accountType === 'Technician') {
      this.technicianService.addTechnician(addForm.value).subscribe(
        (response: Admin) => {
          console.log('technician added:', response);
          this.getEmployees();
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      );
    }
  }
}
