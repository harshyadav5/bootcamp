package SpringDataJpa.JPAAssignment.EmployeeRepository;

import SpringDataJpa.JPAAssignment.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeePagingAndSortingRepository extends PagingAndSortingRepository<Employee,Integer> {
}
