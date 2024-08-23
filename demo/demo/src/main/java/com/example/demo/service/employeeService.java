package com.example.demo.service;

import com.example.demo.model.employee;
import com.example.demo.repo.employeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class employeeService {
    private final employeeRepo employeeRepo;

    public employeeService(com.example.demo.repo.employeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }


    public List<employee> findAllemployee(){
        return  employeeRepo.findAll();
    }
    public employee getEmployeeById(Long id) {
        return employeeRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
    }

    public employee updateemployee(employee Employee){
        return employeeRepo.save(Employee);
    }
    public employee addemployee(employee Employee){
        return employeeRepo.save(Employee);
    }


}
