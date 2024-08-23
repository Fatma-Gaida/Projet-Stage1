package com.example.demo.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Ressource {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable = false,updatable = false )
    private Long id_ressource;
    private String name;
    private String status;
    private String category;
    private String type;
    private String status_maintenance;
    private String description;



    public Ressource(){}
    public Ressource(String name,String status,String category,String type,String status_maintenance,String description){
        this.category=category;
        this.type=type;
        this.description=description;
        this.status_maintenance=status_maintenance;
        this.name=name;
        this.status=status;
    }

    public Ressource(String name, String status, String category, String statusMaintenance, String description) {
    }

    public Long getIdRessource() {
        return id_ressource;
    }

    public void setIdRessource(Long idRessource) {
        this.id_ressource = idRessource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public String getType() {
        return type;
    }

    public void setType(String Type) {
        this.type = Type;
    }

    public String getStatusMaintenance() {
        return status_maintenance;
    }

    public void setStatusMaintenance(String statusMaintenance) {
        this.status_maintenance = statusMaintenance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
