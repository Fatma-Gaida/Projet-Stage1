package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Room extends Ressource {
    private String capacity;
    private String location;

    public Room(){}

    public Room(String name, String status, String category, String status_maintenance, String description,
                String capacity, String location) {
        super(name, status, category, status_maintenance, description);
        this.capacity=capacity;
        this.location=location;

    }
    @ManyToMany(mappedBy = "rooms")
    @JsonIgnoreProperties("rooms")
    private List<Reservation> reservations;

    // Getters et setters
    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

}
