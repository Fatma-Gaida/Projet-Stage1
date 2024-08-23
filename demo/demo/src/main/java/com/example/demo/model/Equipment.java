package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Equipment extends Ressource  {
    private String price;
    private String manifucturer;
    private String quantity;
    private String model;
    public Equipment(String name, String status, String category, String status_maintenance, String description,
                     String price, String manifucturer, String quantity, String model) {
        super(name, status, category, status_maintenance, description);
        this.manifucturer=manifucturer;
        this.model=model;
        this.price=price;
        this.quantity=quantity;
    }
    public Equipment() {
    }
    @ManyToMany(mappedBy = "equipments")
    @JsonIgnoreProperties("equipments")
    private List<Reservation> reservations;


    // Getters and setters
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manifucturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manifucturer = manufacturer;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
