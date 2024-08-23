import { Injectable } from '@angular/core';
import { HttpClient , HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ReservationRequest } from './ReservationRequest';
import { Reservation } from './reservation';
import { Equipment } from '../ressources/ressouces';
import { Room } from '../ressources/ressouces';
@Injectable({
  providedIn: 'root'
})
export class ReservationService {
  private apiUrl = 'http://localhost:8080/reservations';

  constructor(private http: HttpClient) {}

  addReservation(reservationRequest: ReservationRequest): Observable<any> {
    // Perform HTTP post with reservationRequest object
    return this.http.post<any>(`${this.apiUrl}`, reservationRequest);
  }
  getAllReservations(): Observable<Reservation[]> {
    return this.http.get<Reservation[]>(this.apiUrl);
  }
  getAvailableEquipments(date: string, startTime: string, endTime: string): Observable<Equipment[]> {
    const params = new HttpParams()
      .set('date', date)
      .set('startTime', startTime)
      .set('endTime', endTime);
    
    return this.http.get<Equipment[]>(`${this.apiUrl}/by-date-and-time-eq`, { params });
  }

  getAvailableRooms(date: string, startTime: string, endTime: string): Observable<Room[]> {
    const params = new HttpParams()
      .set('date', date)
      .set('startTime', startTime)
      .set('endTime', endTime);

    return this.http.get<Room[]>(`${this.apiUrl}/by-date-and-time-room`, { params });
  }
  getReservationsByEmployeeId(employeeId: number): Observable<Reservation[]> {
    return this.http.get<Reservation[]>(`${this.apiUrl}/employee/${employeeId}`);
  }
}