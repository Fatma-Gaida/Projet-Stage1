package com.example.demo.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "account_type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("Employee")
public class employee {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable = false,updatable = false )
    private Long id_emp;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private String address;
    private String phone_num;
    private String status;
    private String department;
    private String role;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reservation> reservations;

    //constractors
    public employee() {}

    public employee(String first_name, String last_name, String email, String password, String address, String phone_num, String status, String department, String account_type, String role) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phone_num = phone_num;
        this.status = status;
        this.department = department;
        this.role = role;
    }

    public employee(String firstName, String lastName, String email, String password, String address, String phoneNum, String status, String department, String role) {
    }
    // Getters and setters

    public Long getId_emp() {
        return id_emp;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }
    public String getAccount_type() {
        return this.getClass().getAnnotation(DiscriminatorValue.class).value();
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Methods for Employee
    public void add_reservation() {
        // Implementation for adding a reservation
    }

    public void cancel_reservation() {
        // Implementation for canceling a reservation
    }

    public void modify_reservation() {
        // Implementation for modifying a reservation
    }

    public void send_reclamation() {
        // Implementation for sending a complaint
    }



}
