package com.example.lab3_grupo4.Repository;

import com.example.lab3_grupo4.Entity.JobHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Job_historyRepository extends JpaRepository<JobHistory, Integer> {
}
