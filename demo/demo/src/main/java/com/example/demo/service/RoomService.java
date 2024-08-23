package com.example.demo.service;

import com.example.demo.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private final com.example.demo.repo.RoomRepo RoomRepo;

    public RoomService(com.example.demo.repo.RoomRepo roomRepo) {
        RoomRepo = roomRepo;
    }


    public Room addRoom (Room  room ) {
        return (Room ) RoomRepo.save(room);
    }
    public Room  updateRoom (Room  equipment) {
        return (Room ) RoomRepo.save(equipment);
    }
    public Room  findRoomById(Long id) {
        return (Room) RoomRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Room with id " + id + " was not found"));
    }

    public void deleteRoom (Long id) {
        RoomRepo.deleteById(id);
    }


    public List<Room> findAllRooms() {
        return RoomRepo.findAll();
    }

    }
