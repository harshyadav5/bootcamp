package SpringDataJpa.JPAAssignment.EmployeeRepository;

import SpringDataJpa.JPAAssignment.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// Ques 2:Set up EmployeeRepository with Spring Data JPA
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

    List<Employee> findByName(String name);
    List<Employee> findByNameLike(String s);
    List<Employee> findByAgeBetween(Integer age1, Integer age2);
}
