package com.example.demo.controller;


import com.example.demo.model.Technician;
import com.example.demo.service.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/technicians")
public class TechnicianController {

    private final TechnicianService technicianService;

    @Autowired
    public TechnicianController(TechnicianService technicianService) {
        this.technicianService = technicianService;
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<Technician> getTechnicianById(@PathVariable("id") Long id) {
        Technician technician = technicianService.findTechnicianById(id);
        return new ResponseEntity<>(technician, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Technician> addTechnician(@RequestBody Technician technician) {
        Technician newTechnician = technicianService.addTechnician(technician);
        return new ResponseEntity<>(newTechnician, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Technician> updateTechnician(@RequestBody Technician technician) {
        Technician updatedTechnician = technicianService.updateTechnician(technician);
        return new ResponseEntity<>(updatedTechnician, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTechnician(@PathVariable("id") Long id) {
        technicianService.deleteTechnician(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
