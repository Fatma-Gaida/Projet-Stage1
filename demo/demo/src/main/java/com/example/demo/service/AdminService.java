package com.example.demo.service;

import com.example.demo.model.Admin;
import com.example.demo.repo.employeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final employeeRepo employeeRepository;

    @Autowired
    public AdminService(employeeRepo employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Admin addAdmin(Admin admin) {
        return (Admin) employeeRepository.save(admin);
    }

    public Admin updateAdmin(Admin admin) {
        return (Admin) employeeRepository.save(admin);
    }

    public Admin findAdminById(Long id) {
        return (Admin) employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin with id " + id + " was not found"));
    }

    public void deleteAdmin(Long id) {
        employeeRepository.deleteById(id);
    }

}
