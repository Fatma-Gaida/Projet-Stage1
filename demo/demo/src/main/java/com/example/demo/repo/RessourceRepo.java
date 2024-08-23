package com.example.demo.repo;

import com.example.demo.model.Reservation;
import com.example.demo.model.Ressource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface RessourceRepo extends JpaRepository<Ressource,Long> {
    @Query("SELECT r FROM Reservation r WHERE r.reservationDate = :date AND (r.departHour < :endTime AND r.returnHour > :startTime)")
    List<Reservation> findByReservationDateAndDepartHourBetweenAndReturnHourBetween(
            @Param("date") LocalDate date,
            @Param("startTime") LocalTime startTime,
            @Param("endTime") LocalTime endTime
    );
}

