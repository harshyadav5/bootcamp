package com.example.JPAWithHibernatePart2;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface employeeRepository extends CrudRepository<Employee,Integer> {
    @Query("select firstName, lastName from Employee where salary >(select AVG(salary) from Employee)")
    List<Object[]> findfirstNameAndlastName(PageRequest pageable);

    @Query("select AVG(salary) from Employee")
    Integer findAvarageSalary();

    @Transactional
    @Query("update Employee set salary=:salarypassed where salary <:avg")
    @Modifying
    void updateSalary(@Param("avg") Integer avgsalary,@Param("salarypassed") Integer amount);

    @Query("select MIN(salary) from Employee")
    Integer findMinSalary();

    @Transactional
    @Query("delete from Employee where salary=:minsalary")
    @Modifying
    void deleteEmployee(@Param("minsalary") Integer salary);

   @Query(value = "select emp_id,emp_age,emp_firstname from employee where emp_lastname like '%Singh'", nativeQuery = true)
    List<Employee> selectUsingNative();

   @Transactional
   @Query(value = "delete from employee where emp_age>:AGE",nativeQuery = true)
   @Modifying
    void deleteEmployeeUsingNative(@Param("AGE") Integer age);
}
