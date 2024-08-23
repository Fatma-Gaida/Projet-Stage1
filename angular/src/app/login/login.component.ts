import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from './Auth.service';
import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core'; 
import { CommonModule } from '@angular/common';
import { LoginResponse } from './loginResponse';
import { LoginRequest } from './loginResponse'; 

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  email: string = '';
  password: string = '';
  errorMessage: string = '';

  constructor(private authService: AuthService, private router: Router) {}

  Login() {
    const loginRequest: LoginRequest = { email: this.email, password: this.password };

    this.authService.login(loginRequest).subscribe(
      (response: LoginResponse) => {
        if (response) {
          console.log('Login successful:', response);
          // Ensure response properties are defined before accessing them
          const employeeId = response.id;
          const accountType = response.accountType;

          if (employeeId !== undefined && accountType) {
            // Save the login response in local storage
            localStorage.setItem('employeeId', employeeId.toString());
            localStorage.setItem('accountType', accountType);
            this.redirectBasedOnAccountType(accountType);
          } else {
            console.error('Unexpected response format:', response);
            this.errorMessage = 'Unexpected server response';
          }
        } else {
          console.error('Login response is null or undefined');
          this.errorMessage = 'Unexpected server response';
        }
      },
      (error) => {
        console.error('Login failed:', error);
        this.errorMessage = 'Invalid email or password';
      }
    );
  }

  redirectBasedOnAccountType(accountType: string) {
    switch (accountType) {
      case 'Employee':
        this.router.navigate(['/reservation']);
        break;
      case 'Admin':
        this.router.navigate(['/upcoming_Reservation_Equipment']);
        break;
      case 'Technician':
        this.router.navigate(['/maintenanceEq']);
        break;
      default:
        console.error('Unknown account type:', accountType);
        break;
    }
  }
}
