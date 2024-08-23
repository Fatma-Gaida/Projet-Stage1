import { Component , OnInit} from '@angular/core';
import { ReservationService } from '../reservation/reservation.service';
import { Reservation } from '../reservation/reservation';
import { HttpErrorResponse } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
@Component({
  selector: 'app-historic',
  standalone: true,
  imports: [RouterModule, FormsModule, CommonModule],
  templateUrl: './historic.component.html',
  styleUrl: './historic.component.css'
})
export class HistoricComponent implements OnInit {
  reservations: Reservation[] = [];

  constructor(private reservationService: ReservationService) { }

  ngOnInit(): void {
    const employeeId = +localStorage.getItem('employeeId')!; 
    this.reservationService.getReservationsByEmployeeId(employeeId).subscribe(
      (data) => {
        this.reservations = data;
      },
      (error) => {
        console.error('Error fetching reservations', error);
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
}
