package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id_reservation;

    private String status;
    private String category;
    private LocalDate reservationDate;
    private LocalTime departHour;
    private LocalTime returnHour;
    private LocalDate creationDate;
    private LocalDate modificationDate;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private employee employee;

    @ManyToMany
    @JoinTable(
            name = "reservation_equipment",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "equipment_id")
    )
    @JsonIgnoreProperties("reservations")
    private List<Equipment> equipments = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "reservation_room",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "room_id")
    )
    @JsonIgnoreProperties("reservations")
    private List<Room> rooms = new ArrayList<>();

    public Reservation() {
        // Default constructor
    }

    public Reservation(String status, String category, LocalDate reservationDate,
                       LocalTime departHour, LocalTime returnHour, LocalDate creationDate,
                       LocalDate modificationDate) {
        this.status = status;
        this.category = category;
        this.reservationDate = reservationDate;
        this.departHour = departHour;
        this.returnHour = returnHour;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
    }

    // Getters and setters

    public Long getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(Long id_reservation) {
        this.id_reservation = id_reservation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public LocalTime getDepartHour() {
        return departHour;
    }

    public void setDepartHour(LocalTime departHour) {
        this.departHour = departHour;
    }

    public LocalTime getReturnHour() {
        return returnHour;
    }

    public void setReturnHour(LocalTime returnHour) {
        this.returnHour = returnHour;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(LocalDate modificationDate) {
        this.modificationDate = modificationDate;
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public employee getEmployee() {
        return employee;
    }

    public void setEmployee(employee employee) {
        this.employee = employee;
    }
}

