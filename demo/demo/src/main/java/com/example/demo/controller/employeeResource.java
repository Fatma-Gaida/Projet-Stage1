package com.example.demo.controller;

import com.example.demo.model.employee;
import com.example.demo.service.employeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class employeeResource {
    private final employeeService EmployeeService;

    public employeeResource(employeeService EmployeeService) {
        this.EmployeeService = EmployeeService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<employee>> getAllemployee(){
        List<employee> Employees= EmployeeService.findAllemployee();
        return new ResponseEntity<>(Employees, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<employee> getEmployeeById(@PathVariable Long id) {
        try {
            employee employee = EmployeeService.getEmployeeById(id);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/add")
    public ResponseEntity <employee> addemployee(@RequestBody employee Employee){
        employee newEmployee= EmployeeService.addemployee(Employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }


}
