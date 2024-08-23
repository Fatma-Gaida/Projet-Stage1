import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, NgForm } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http'; // Import HttpErrorResponse
import { Equipment } from './ressouces';
import { EquipmentService } from './equipment.service';
@Component({
  selector: 'app-ressources',
  standalone: true,
  imports: [RouterModule,FormsModule,CommonModule],
  templateUrl: './ressources.component.html',
  styleUrl: './ressources.component.css'
})
export class ResourcesComponent implements OnInit {
  public equipments: Equipment[] = [];
 

  constructor(private equipmentService: EquipmentService) {} // Corrected the constructor

  ngOnInit(): void {
    this.getEquipment();
  }

  public getEquipment(): void {
    this.equipmentService.getAllEquipment().subscribe(
      (response: Equipment[]) => {
        this.equipments = response;
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
  onAddEquipment(addForm: NgForm): void {
    
      this.equipmentService.addEquipment(addForm.value).subscribe(
        (response: Equipment) => {
          console.log('Equipment added:', response);
          this.getEquipment();
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      );
    }
}
