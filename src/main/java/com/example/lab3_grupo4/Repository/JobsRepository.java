package com.example.lab3_grupo4.Repository;

import com.example.lab3_grupo4.Entity.Employee;
import com.example.lab3_grupo4.Entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobsRepository extends JpaRepository<Job, Integer> {

    @Query(value="select job_title, j.max_salary, j.min_salary, emp.salary, truncate(avg(salary),0) from employees as emp inner join jobs as j on emp.job_id= j.job_id group by job_title; ",nativeQuery = true)
    List<Job> sueldos();




}
