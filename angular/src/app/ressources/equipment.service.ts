import { Injectable, NgModule } from '@angular/core';
import { HttpClient, HttpClientModule, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Equipment,  } from './ressouces';

@Injectable({
  providedIn: 'root'
})

export class EquipmentService {
  private baseUrl = 'http://localhost:8080/equipment'; 

  constructor(private http: HttpClient) { }

  getAllEquipment(): Observable<Equipment[]> {
    return this.http.get<Equipment[]>(`${this.baseUrl}/all`);
  }

  addEquipment(equipment: Equipment): Observable<Equipment> {
    return this.http.post<Equipment>(`${this.baseUrl}/add`, equipment);
  }

  updateEquipment(equipment: Equipment): Observable<Equipment> {
    return this.http.put<Equipment>(`${this.baseUrl}/update`, equipment);
  }
}
