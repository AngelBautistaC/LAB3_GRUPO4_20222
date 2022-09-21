package com.example.lab3_grupo4.Repository;

import com.example.lab3_grupo4.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EmployeesRepository extends JpaRepository<Employee, Integer> {

    @Query(value="SELECT * FROM employees group by manager_id",nativeQuery = true)
    List<Employee> buscaJefes();


    @Query(value="select concat(e.first_name, ' ', e.last_name), j.job_title, dep.department_name, job.start_date, job.end_date from employees as e inner join jobs as j on j.job_id= e.job_id\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\tinner join job_history as job on j.job_id = job.job_id\n" +
            "                            inner join departments as dep on dep.department_id=job.department_id\n" +
            "                            inner join employees as emp on emp.manager_id=dep.manager_id order by job.start_date desc;")
    List<Employee> buscaJefes1();




    @Transactional
    @Query(value = """
            select * from employees e
            inner join jobs j
            on (e.job_id=j.job_id)
            inner join departments dep
            on (e.department_id=dep.department_id)
            inner join locations loc
            on (dep.location_id=loc.location_id)
            where LOWER(first_name) like LOWER(concat('%',?1,'%')) OR LOWER(last_name) like LOWER(concat('%',?1,'%')) OR LOWER(j.job_title) LIKE LOWER (concat('%',?1,'%')) OR LOWER(dep.department_name) LIKE LOWER(concat('%',?1,'%')) OR LOWER(loc.city) like LOWER(concat('%',?1,'%'))\s""",nativeQuery = true)
    List<Employee> buscarEmployee(String searchField);


}
