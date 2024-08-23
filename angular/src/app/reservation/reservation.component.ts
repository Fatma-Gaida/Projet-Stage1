import { Component, OnInit } from '@angular/core';
import { Equipment } from '../ressources/ressouces';
import { EquipmentService } from '../ressources/equipment.service';
import { Room } from '../ressources/ressouces';
import { RoomService } from '../rooms/room.service';
import { HttpErrorResponse } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, NgForm } from '@angular/forms';
import { Reservation } from './reservation';
import { ReservationService } from './reservation.service';
import { LocalDate, LocalTime } from '@js-joda/core';
import { ReservationRequest } from './ReservationRequest';
import { AuthService } from '../login/Auth.service';
declare var bootstrap: any;
@Component({
  selector: 'app-reservation',
  standalone: true,
  imports: [FormsModule,CommonModule],
  templateUrl: './reservation.component.html',
  styleUrl: './reservation.component.css'
})
export class ReservationComponent implements OnInit{
  public equipments: Equipment[] = [];
  public rooms: Room[] = [];
  public selectedEquipments: Equipment[] = [];
  public selectedRooms: Room[] = [];
  public reservationDate: string = '';
  public departureHour: string = '';
  public returnHour: string = '';

  constructor(
    private equipmentService: EquipmentService,
    private roomService: RoomService,
    private reservationService: ReservationService ,// Inject ReservationService
    private authService: AuthService
  ) {}

  ngOnInit(): void {
    // this.getEquipment();
    // this.getRoom();
    this.openDateModal();
  }
 
  public openDateModal(): void {
    const modal = new bootstrap.Modal(document.getElementById('reservationDateModal'));
    modal.show();
  }

  // public getEquipment(): void {
  //   this.equipmentService.getAllEquipment().subscribe(
  //     (response: Equipment[]) => {
  //       this.equipments = response;
  //       console.log(response);
  //     },
  //     (error: HttpErrorResponse) => {
  //       alert(error.message);
  //     }
  //   );
  // }
  // public getAvailableEquipments(): void {
  //   if (this.reservationDate && this.departureHour && this.returnHour) {
  //     this.reservationService.getAvailableEquipments(this.reservationDate, this.departureHour, this.returnHour).subscribe(
  //       (response: Equipment[]) => {
  //         this.equipments = response;
  //         console.log("Available equipments:", response);
  //       },
  //       (error: HttpErrorResponse) => {
  //         alert(error.message);
  //       }
  //     );
  //   }
  // }

 
  // public getRoom(): void {
  //   this.roomService.getAllRooms().subscribe(
  //     (response: Room[]) => {
  //       this.rooms = response;
  //       console.log(response);
  //     },
  //     (error: HttpErrorResponse) => {
  //       alert(error.message);
  //     }
  //   );
  // }

  public getAvailableEquipmentsAndRooms(): void {
    if (this.reservationDate && this.departureHour && this.returnHour) {
      this.reservationService.getAvailableEquipments(this.reservationDate, this.departureHour, this.returnHour).subscribe(
        (response: Equipment[]) => {
          this.equipments = response;
          console.log("Available equipments:", response);
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      );

      this.reservationService.getAvailableRooms(this.reservationDate, this.departureHour, this.returnHour).subscribe(
        (response: Room[]) => {
          this.rooms = response;
          console.log("Available rooms:", response);
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      );
    }
  }


  public toggleEquipmentSelection(equipment: Equipment): void {
    const index = this.selectedEquipments.indexOf(equipment);
    if (index > -1) {
      this.selectedEquipments.splice(index, 1);
    } else {
      this.selectedEquipments.push(equipment);
    }
    console.log('Selected Equipment IDs:', this.selectedEquipments.map(e => e.idRessource));
  }

  public toggleRoomSelection(room: Room): void {
    const index = this.selectedRooms.indexOf(room);
    if (index > -1) {
      this.selectedRooms.splice(index, 1);
    } else {
      this.selectedRooms.push(room);
    }
    console.log('Selected Room IDs:', this.selectedRooms.map(r => r.idRessource));
  }

  public openModal(): void {
    const reservationModal = new bootstrap.Modal(document.getElementById('reservationModal'));
    reservationModal.show();
  
  }



  confirmReservation() {
    // Afficher les valeurs des attributs avant de créer le ReservationRequest
    console.log('Reservation Date:', this.reservationDate);
    console.log('Departure Hour:', this.departureHour);
    console.log('Return Hour:', this.returnHour);
    console.log('Selected Equipment IDs:', this.selectedEquipments.map(e => e.idRessource));
    console.log('Selected Room IDs:', this.selectedRooms.map(r => r.idRessource));
    console.log('Current Date:', new Date().toISOString().split('T')[0]);
  
    const equipmentIds = this.selectedEquipments.map(e => e.idRessource).filter(id => id !== undefined) as number[];
    const roomIds = this.selectedRooms.map(r => r.idRessource).filter(id => id !== undefined) as number[];
    
      // Get the employee ID from the AuthService
  // const employeeId = this.authService.getIdEmployee();
  // console.log('Retrieved Employee ID from AuthService:', employeeId);

  // if (employeeId === null) {
  //   console.error('No employee ID found');
  //   alert('You must be logged in to make a reservation.');
  //   return;
  // }

    const reservationRequest: ReservationRequest = {
      status: 'Pending', // Set default or dynamic status
      category: 'General', // Set default or dynamic category
      reservationDate: this.reservationDate,
      departHour: this.departureHour,
      returnHour: this.returnHour,
      creationDate: new Date().toISOString().split('T')[0], // Set current date
      modificationDate: new Date().toISOString().split('T')[0], // Set current date
      equipmentIds: equipmentIds,
      roomIds: roomIds,
    employeeId: 202 // Id de l'employé connecté

    };
  
    // Afficher l'objet ReservationRequest pour vérifier sa structure
    console.log('Reservation Request:', reservationRequest);
  
    this.reservationService.addReservation(reservationRequest).subscribe(
      response => {
        console.log('Reservation created successfully', response);
        alert('Reservation created successfully. we will send you an email to confirme the reservation ');
        // Handle success, maybe close the modal or reset the form
      },
      error => {
        console.error('Error creating reservation', error.message);
        // Handle error, maybe show an error message
      }
    );
  }
  
  handleNext() {
    // Add logic for handling the next step after selecting date and time
    console.log('Reservation Date:', this.reservationDate);
    console.log('Departure Hour:', this.departureHour);
    console.log('Return Hour:', this.returnHour);
    // You can call a method here to proceed to the next step or perform an action
    // For example, open another modal to select resources to reserve
    this.getAvailableEquipmentsAndRooms();
  }
}
