package com.example.lab3_grupo4.Repository;

import com.example.lab3_grupo4.Entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobsRepository extends JpaRepository<Job, Integer> {
}
