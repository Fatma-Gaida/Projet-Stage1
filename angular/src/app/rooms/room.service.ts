import { Injectable, NgModule } from '@angular/core';
import { HttpClient, HttpClientModule, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import {  Room } from '../ressources/ressouces'; 

@Injectable({
  providedIn: 'root'
})

export class RoomService {
  private baseUrl = 'http://localhost:8080/room'; 

  constructor(private http: HttpClient) { }

  getAllRooms(): Observable<Room[]> {
    return this.http.get<Room[]>(`${this.baseUrl}/all`);
  }

  addRoom(room: Room): Observable<Room> {
    return this.http.post<Room>(`${this.baseUrl}/add`, room);
  }

  updateRoom(room: Room): Observable<Room> {
    return this.http.put<Room>(`${this.baseUrl}/update`, room);
  }
}
