package com.example.demo.repo;

import com.example.demo.model.Equipment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepo extends JpaRepository<Equipment,Long>{
}


