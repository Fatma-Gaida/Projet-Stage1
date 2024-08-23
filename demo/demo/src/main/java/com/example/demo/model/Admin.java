package com.example.demo.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity

@DiscriminatorValue("Admin")
public class Admin extends employee {
    // Default constructor
    public Admin() {
    }

    // Parameterized constructor
    public Admin(String first_name, String last_name, String email, String password, String address, String phone_num, String status, String department, String role) {
        super(first_name, last_name, email, password, address, phone_num, status, department, role);
    }

    // Methods specific to Admin
//    public void ajouter_employe(EmployeeRepository employeeRepository, Employee employee) {
//        // Implementation for adding an employee
//        employeeRepository.save(employee);
//    }
//
//    public void modifier_employe(EmployeeRepository employeeRepository, Long id, Employee updatedEmployee) {
//        // Implementation for modifying an employee
//        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
//        employee.setFirst_name(updatedEmployee.getFirst_name());
//        employee.setLast_name(updatedEmployee.getLast_name());
//        employee.setEmail(updatedEmployee.getEmail());
//        employee.setPassword(updatedEmployee.getPassword());
//        employee.setAddress(updatedEmployee.getAddress());
//        employee.setPhone_num(updatedEmployee.getPhone_num());
//        employee.setStatus(updatedEmployee.getStatus());
//        employee.setDepartment(updatedEmployee.getDepartment());
//        employee.setAccount_type(updatedEmployee.getAccount_type());
//        employee.setRole(updatedEmployee.getRole());
//        employeeRepository.save(employee);
//    }

    public void add_equipment() {
        // Implementation for adding equipment
    }

    public void add_room() {
        // Implementation for adding a room
    }

    public void modify_equipment() {
        // Implementation for modifying equipment
    }

    public void modify_room() {
        // Implementation for modifying a room
    }
}