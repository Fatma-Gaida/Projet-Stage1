package com.example.demo.repo;

import com.example.demo.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ReservationRepo extends JpaRepository<Reservation,Long> {
    List<Reservation> findByReservationDateAndDepartHourBeforeAndReturnHourAfter(LocalDate date, LocalTime endTime, LocalTime startTime);

    @Query("SELECT r FROM Reservation r WHERE r.employee.id_emp = :idEmp")
    List<Reservation> findByEmployeeIdEmp(@Param("idEmp") Long idEmp);
}
