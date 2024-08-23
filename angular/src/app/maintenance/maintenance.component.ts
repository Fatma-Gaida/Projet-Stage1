import { Component, OnInit } from '@angular/core';
import { Reservation } from '../reservation/reservation'; 
import { HttpErrorResponse } from '@angular/common/http';
import { ReservationService } from '../reservation/reservation.service';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { EquipmentService } from '../ressources/equipment.service'; 
import { RoomService } from '../rooms/room.service';
@Component({
  selector: 'app-maintenance',
  standalone: true,
  imports: [CommonModule,RouterModule,FormsModule ],
  templateUrl: './maintenance.component.html',
  styleUrl: './maintenance.component.css'
})
export class MaintenanceComponent implements OnInit {
  public reservations: Reservation[] = [];
  public equipmentMap: Map<number, string> = new Map();  // Pour stocker les détails des équipements
  public roomMap: Map<number, string> = new Map();       // Pour stocker les détails des salles

  constructor(
    private reservationService: ReservationService,
    private equipmentService: EquipmentService,
    private roomService: RoomService
  ) {}

  ngOnInit(): void {
    this.getAllReservations();
  }

  public getAllReservations(): void {
    this.reservationService.getAllReservations().subscribe(
      (response: Reservation[]) => {
        this.reservations = response;
        
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
}
