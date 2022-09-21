package com.example.lab3_grupo4.Repository;

import com.example.lab3_grupo4.Entity.Employee;
import com.example.lab3_grupo4.Entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobsRepository extends JpaRepository<Job, Integer> {

    @Query(value="select max_salary from jobs order by max_salary desc limit 1;\n",nativeQuery = true)
    List<Employee> buscaJefes();

    @Query(value="select min_salary from jobs order by min_salary asc limit 1;\n",nativeQuery = true)
    List<Employee> buscaJefes();

    @Query(value="select department_id, truncate(avg(salary),0) as `Salario` from employees  group by department_id;\n",nativeQuery = true)
    List<Employee> buscaJefes();



}
