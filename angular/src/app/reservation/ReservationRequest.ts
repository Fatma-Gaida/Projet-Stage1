export interface ReservationRequest {
    status: string;
    category: string;
    reservationDate: string; // Use string for date to handle datepicker values
    departHour: string; // Use string for time to handle timepicker values
    returnHour: string; // Use string for time to handle timepicker values
    creationDate: string; // Use string for date to handle datepicker values
    modificationDate: string; // Use string for date to handle datepicker values
    equipmentIds: number[];
    roomIds: number[];
    employeeId: number;
   
  }

