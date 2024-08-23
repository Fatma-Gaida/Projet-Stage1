package com.example.demo.service;

import com.example.demo.model.Admin;
import com.example.demo.model.Technician;
import com.example.demo.repo.employeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicianService {

    private final employeeRepo employeeRepository;

    @Autowired
    public TechnicianService(employeeRepo employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Technician addTechnician(Technician technician) {
        return (Technician) employeeRepository.save(technician);
    }

    public Technician updateTechnician(Technician technician) {
        return (Technician) employeeRepository.save(technician);
    }

    public Technician findTechnicianById(Long id) {
        return (Technician) employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Technician with id " + id + " was not found"));
    }

    public void deleteTechnician(Long id) {
        employeeRepository.deleteById(id);
    }

}
