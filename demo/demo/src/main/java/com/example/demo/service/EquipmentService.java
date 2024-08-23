package com.example.demo.service;

import com.example.demo.model.Equipment;
import com.example.demo.repo.EquipmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {

    private final EquipmentRepo equipmentRepo;

    @Autowired
    public EquipmentService(EquipmentRepo equipmentRepo){
        this.equipmentRepo = equipmentRepo;
    }

    public Equipment addEquipment(Equipment equipment) {
        return equipmentRepo.save(equipment);
    }

    public Equipment updateEquipment(Equipment equipment) {
        return equipmentRepo.save(equipment);
    }

    public Equipment findEquipmentById(Long id) {
        return equipmentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Equipment with id " + id + " was not found"));
    }

    public void deleteEquipment(Long id) {
        equipmentRepo.deleteById(id);
    }

    public List<Equipment> findAllEquipment() {
        return equipmentRepo.findAll();
    }
}
