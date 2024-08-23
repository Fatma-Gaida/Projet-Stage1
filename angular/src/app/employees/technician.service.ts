import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Technician } from './technician';

@Injectable({
  providedIn: 'root'
})
export class TechnicianService {
  private baseUrl = 'http://localhost:8080/technicians'; 

  constructor(private http: HttpClient) { }

  addTechnician(technician:Technician): Observable<Technician> {
    return this.http.post<Technician>(`${this.baseUrl}/add`, technician);
  }
}
