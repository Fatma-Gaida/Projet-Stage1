import { RouterModule,Routes } from '@angular/router';
import { SignUpComponent } from './sign-up/sign-up.component';
import { LoginComponent } from './login/login.component';
import { NgModule } from '@angular/core';
import { SidebarComponent } from './sidebar/sidebar.component';
import { ProfilComponent } from './profil/profil.component';
import { CalendarComponent } from './calendar/calendar.component';
import { ReservationComponent } from './reservation/reservation.component';
import { EmployeesComponent } from './employees/employees.component';
import { ResourcesComponent } from './ressources/ressources.component';
import { provideHttpClient, withInterceptorsFromDi } from '@angular/common/http';
import { RoomsComponent } from './rooms/rooms.component';
import { MaintenanceComponent } from './maintenance/maintenance.component';
import { UpcomingReservationRComponent } from './upcoming-reservation-r/upcoming-reservation-r.component';
import { UpcomingReservationEComponent } from './upcoming-reservation-e/upcoming-reservation-e.component';
import { MaintenanceEqComponent } from './maintenance/maintenance-eq/maintenance-eq.component';
import { HistoricComponent } from './historic/historic.component';
export const routes: Routes = [
    {path: "sign-up", component:SignUpComponent},
    {path: "login", component:LoginComponent},
    {path: "sidebar", component:SidebarComponent},
    {path: "profil", component:ProfilComponent},
    {path: "calendar", component:CalendarComponent},
    {path: "reservation", component:ReservationComponent},
    {path: "employees", component:EmployeesComponent},
    {path: "ressources", component:ResourcesComponent},
    {path: "rooms", component:RoomsComponent},
    {path: "maintenance",component:MaintenanceComponent},
    {path: "maintenanceEq",component:MaintenanceEqComponent},
    {path: "upcoming_Reservation_Room",component:UpcomingReservationRComponent},
    {path: "upcoming_Reservation_Equipment",component:UpcomingReservationEComponent},
    {path:"historic", component:HistoricComponent}
];
@NgModule({
    imports: [
      RouterModule.forRoot(routes), 
    
    ],
    declarations: [],
    exports: [RouterModule]
  })
  export class AppRoutingModule { }