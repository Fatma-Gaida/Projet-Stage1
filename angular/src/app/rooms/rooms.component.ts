import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, NgForm } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
import { Room } from '../ressources/ressouces';
import { RoomService } from './room.service';
@Component({
  selector: 'app-rooms',
  standalone: true,
  imports: [RouterModule,FormsModule,CommonModule],
  templateUrl: './rooms.component.html',
  styleUrl: './rooms.component.css'
})
export class RoomsComponent implements OnInit {
  public Rooms: Room[] = [];
 

  constructor(private roomService: RoomService) {} 

  ngOnInit(): void {
    this.getRoom();
  }

  public getRoom(): void {
    this.roomService.getAllRooms().subscribe(
      (response: Room[]) => {
        this.Rooms = response;
        console.log(response);
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
  onAddRoom(addForm: NgForm): void {
    
      this.roomService.addRoom(addForm.value).subscribe(
        (response: Room) => {
          console.log('room added:', response);
          this.getRoom();
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      );
    }
}
