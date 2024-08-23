package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repo.EquipmentRepo;
import com.example.demo.repo.ReservationRepo;
import com.example.demo.repo.RoomRepo;
import com.example.demo.repo.employeeRepo;
import com.example.demo.repo.employeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepo reservationRepository;

    @Autowired
    private EquipmentRepo equipmentRepository;

    @Autowired
    private RoomRepo roomRepository;

    @Autowired
    private employeeRepo employeeRepository;

    public ReservationService(employeeRepo employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Reservation addReservation(ReservationRequest reservationRequest) {
        // Fetch equipment based on provided IDs
        List<Equipment> equipmentList = equipmentRepository.findAllById(reservationRequest.getEquipmentIds());
        if (equipmentList.isEmpty()) {
            throw new IllegalArgumentException("No valid equipment found for the given IDs");
        }

        // Fetch rooms based on provided IDs
        List<Room> roomList = roomRepository.findAllById(reservationRequest.getRoomIds());
        if (roomList.isEmpty()) {
            throw new IllegalArgumentException("No valid rooms found for the given IDs");
        }

        // Fetch the employee based on the provided ID
        employee employee = employeeRepository.findById(reservationRequest.getEmployeeId())
                .orElseThrow(() -> new IllegalArgumentException("No valid employee found for the given ID"));

        Reservation reservation = new Reservation();
        reservation.setStatus(reservationRequest.getStatus());
        reservation.setCategory(reservationRequest.getCategory());
        reservation.setReservationDate(reservationRequest.getReservationDate());
        reservation.setDepartHour(reservationRequest.getDepartHour());
        reservation.setReturnHour(reservationRequest.getReturnHour());
        reservation.setCreationDate(reservationRequest.getCreationDate());
        reservation.setModificationDate(reservationRequest.getModificationDate());
        reservation.setEquipments(equipmentList);
        reservation.setRooms(roomList);
        reservation.setEmployee(employee); // Set the employee

        // Save the reservation to the database
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
    public List<Equipment> findAvailableEquipments(LocalDate date, LocalTime startTime, LocalTime endTime) {
        List<Equipment> allEquipments = equipmentRepository.findAll();

        // Retrieve reservations that overlap with the given date and time range
        List<Reservation> reservations = reservationRepository.findByReservationDateAndDepartHourBeforeAndReturnHourAfter(date, endTime, startTime);

        List<Equipment> reservedEquipments = reservations.stream()
                .flatMap(reservation -> reservation.getEquipments().stream())
                .collect(Collectors.toList());

        // Filter out reserved equipments
        return allEquipments.stream()
                .filter(equipment -> !reservedEquipments.contains(equipment))
                .collect(Collectors.toList());
    }





    public List<Room> findAvailableRooms(LocalDate date, LocalTime startTime, LocalTime endTime) {
        List<Room> allRooms = roomRepository.findAll();

        // Retrieve reservations that overlap with the given date and time range
        List<Reservation> reservations = reservationRepository.findByReservationDateAndDepartHourBeforeAndReturnHourAfter(date, endTime, startTime);

        List<Room> reservedRooms = reservations.stream()
                .flatMap(reservation -> reservation.getRooms().stream())
                .collect(Collectors.toList());

        // Filter out reserved rooms
        return allRooms.stream()
                .filter(room -> !reservedRooms.contains(room))
                .collect(Collectors.toList());
    }

    public List<Reservation> getReservationsByEmployeeId(Long employeeId) {
        return reservationRepository.findByEmployeeIdEmp(employeeId);
    }

}
