import { LocalDate, LocalTime } from '@js-joda/core';
import { Ressources } from '../ressources/ressouces';
import { Equipment } from '../ressources/ressouces';
import { Room } from '../ressources/ressouces';
import { Employee } from '../employees/employees';
export class Reservation {
  id_reservation?: number;
  status: string;
  category: string;
  reservationDate: string;
  departHour: string; 
  returnHour: string; 
  creationDate: string; 
  modificationDate: string; 
  equipments: Equipment[]; 
  rooms: Room[]; 
  employee:Employee;


  constructor(
    status: string,
    category: string,
    reservationDate: string,
    departHour: string,
    returnHour: string,
    creationDate: string,
    modificationDate: string,
    equipments: Equipment[],
    rooms: Room[], 
    employee:Employee
  ) {
    this.status = status;
    this.category = category;
    this.reservationDate = reservationDate;
    this.departHour = departHour;
    this.returnHour = returnHour;
    this.creationDate = creationDate;
    this.modificationDate = modificationDate;
    this.equipments = equipments; 
    this.rooms = rooms; 
    this.employee = employee;
  }
  
}

