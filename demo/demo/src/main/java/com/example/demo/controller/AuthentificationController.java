package com.example.demo.controller;

import com.example.demo.model.employee;
import com.example.demo.repo.employeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthentificationController {

    @Autowired
    private employeeRepo employeeRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        employee employee = employeeRepository.findByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
        if (employee != null) {
            LoginResponse loginResponse = new LoginResponse(employee.getId_emp(), employee.getAccount_type());
            return ResponseEntity.ok(loginResponse);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }
}


