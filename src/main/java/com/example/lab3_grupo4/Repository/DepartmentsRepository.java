package com.example.lab3_grupo4.Repository;

import com.example.lab3_grupo4.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentsRepository extends JpaRepository<Department, Integer> {
}
