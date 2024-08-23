package com.example.demo.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Technician")

public class Technician extends employee{
    public Technician() {
    }

    // Parameterized constructor
    public Technician(String first_name, String last_name, String email, String password, String address, String phone_num, String status, String department, String role) {
        super(first_name, last_name, email, password, address, phone_num, status, department, role);
    }

    // Methods specific to Technician
    public void approve_reservation() {
        // Implementation for approving a reservation request
    }

    public void reject_reservation() {
        // Implementation for rejecting a reservation request
    }

    public void declaring_maintenance() {
        // Implementation for declaring maintenance status
    }
}
