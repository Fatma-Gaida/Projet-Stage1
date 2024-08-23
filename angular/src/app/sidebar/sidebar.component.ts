import { Component, OnInit } from '@angular/core';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { AuthService } from '../login/Auth.service';

@Component({
  selector: 'app-sidebar',
  standalone: true,
  imports: [RouterModule, CommonModule ],
  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.css'
})
export class SidebarComponent implements OnInit {
  activeTab: string = ''; // Définissez le premier onglet comme actif par défaut

  setActiveTab(tabName: string) {
    this.activeTab = tabName;
    console.log(this.activeTab)
  }
  isEmployee: boolean = false;
  isAdmin: boolean = false;
  isTechnician = false;
  constructor(private authService: AuthService) {}

  ngOnInit(): void {
      const accountType = this.authService.getAccountType(); // Récupère le type de compte depuis le service d'authentification

      // Vérifie le type de compte pour afficher les champs appropriés
      if (accountType === 'Employee') {
          this.isEmployee = true;
          
      } else if (accountType === 'Admin') {
          this.isAdmin = true;
         
      }
      else if (accountType === 'Technician') {
      this.isTechnician = true;
     
    }
  }

  
}
