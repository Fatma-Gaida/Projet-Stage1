package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class ReservationRequest {
    private String status;
    private String category;
    private LocalDate reservationDate;
    private LocalTime departHour;
    private LocalTime returnHour;
    private LocalDate creationDate;
    private LocalDate modificationDate;
    private List<Long> equipmentIds;
    private List<Long> roomIds;
    private Long employeeId;

    // Getters and setters

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

    public List<Long> getEquipmentIds() {
        return equipmentIds;
    }

    public void setEquipmentIds(List<Long> equipmentIds) {
        this.equipmentIds = equipmentIds;
    }

    public List<Long> getRoomIds() {
        return roomIds;
    }

    public void setRoomIds(List<Long> roomIds) {
        this.roomIds = roomIds;
    }
    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }


}
