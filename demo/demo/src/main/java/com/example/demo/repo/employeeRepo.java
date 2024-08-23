package com.example.demo.repo;
import com.example.demo.model.Admin;
import com.example.demo.model.Technician;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.employee;

import java.util.List;

public interface employeeRepo extends JpaRepository<employee,Long> {


    employee findByEmailAndPassword(String email, String password);
}
 