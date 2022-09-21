package com.example.lab3_grupo4.Repository;

import com.example.lab3_grupo4.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesRepository extends JpaRepository<Employee, Integer> {

    @Query(value="SELECT * FROM employees group by manager_id",nativeQuery = true)
    List<Employee> buscaJefes();
}
