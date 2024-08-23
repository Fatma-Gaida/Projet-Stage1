package com.example.demo.controller;


import com.example.demo.model.Equipment;
import com.example.demo.model.Reservation;
import com.example.demo.model.ReservationRequest;
import com.example.demo.model.Room;
import com.example.demo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody ReservationRequest reservationRequest) {
        Reservation reservation = reservationService.addReservation(reservationRequest);
        return ResponseEntity.ok(reservation);
    }

    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations = reservationService.getAllReservations();
        return ResponseEntity.ok(reservations);
    }
    @GetMapping("/by-date-and-time-eq")
    public ResponseEntity<List<Equipment>> getAvailableEquipments(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam("startTime") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime startTime,
            @RequestParam("endTime") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime endTime) {

        List<Equipment> availableEquipments = reservationService.findAvailableEquipments(date, startTime, endTime);
        return ResponseEntity.ok(availableEquipments);
    }
    @GetMapping("/by-date-and-time-room")
    public ResponseEntity<List<Room>> getAvailableRooms(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam("startTime") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime startTime,
            @RequestParam("endTime") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime endTime) {

        List<Room> availableRooms = reservationService.findAvailableRooms(date, startTime, endTime);
        return ResponseEntity.ok(availableRooms);
    }


    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<Reservation>> getReservationsByEmployeeId(@PathVariable Long employeeId) {
        List<Reservation> reservations = reservationService.getReservationsByEmployeeId(employeeId);
        if (reservations.isEmpty()) {
            return ResponseEntity.noContent().build(); // Returns a 204 No Content response if no reservations are found
        }
        return ResponseEntity.ok(reservations); // Returns a 200 OK response with the list of reservations
    }

}
