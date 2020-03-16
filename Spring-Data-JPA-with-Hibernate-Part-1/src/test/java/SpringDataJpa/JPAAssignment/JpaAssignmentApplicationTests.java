package SpringDataJpa.JPAAssignment;

import SpringDataJpa.JPAAssignment.EmployeeRepository.EmployeePagingAndSortingRepository;
import SpringDataJpa.JPAAssignment.EmployeeRepository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
class JpaAssignmentApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	EmployeePagingAndSortingRepository employeePagingAndSortingRepository;

	@Test
	public void testEmployee(){

	}

	//Ques 3: Perform Create Operation on Entity using Spring Data JPA
	@Test
	public void createEmployee(){
		Employee employee = new Employee();
		employee.setId(4040);
		employee.setName("Harsh Yadav");
		employee.setAge(21);
		employee.setLocation("Greater Noida");
		employeeRepository.save(employee);
	}

	//Ques 4:Perform Update Operation on Entity using Spring Data JPA
	@Test
	public void updateEmployee(){
		Optional<Employee> employee = employeeRepository.findById(4041);
		Employee employee1 = employee.get();
		employee1.setName("Kshitiz Gupta");
		employee1.setAge(22);
		employee1.setLocation("Noida");

		employeeRepository.save(employee1);
	}

	//Ques 5: Perform Delete Operation on Entity using Spring Data JPA
	@Test
	public void deleteEmployee(){
		employeeRepository.deleteById(4023);
	}

	@Test
	public void employeeExists(){
		if (employeeRepository.existsById(4040)){
			System.out.println("===========================================================");
		}
	}

	//Ques 6:Perform Read Operation on Entity using Spring Data JPA
	@Test
	public void readEmployee(){
		Optional<Employee> employee = employeeRepository.findById(4040);
		Employee employee1 = employee.get();
		System.out.println("this is employee name  =================:"+employee1.getName());
	}

	//Ques 7:Get the total count of the number of Employees
	@Test
	public void countEmployee(){
		System.out.println("NUmber Of Employee ======================: "+employeeRepository.count());
	}

	//Ques 8:Implement Pagination and Sorting on the bases of Employee Age
	@Test
	public void testFindAllPagingAndSortingByName(){
		Pageable pageable = PageRequest.of(0,3,Sort.by("name"));
		Page<Employee> results = employeePagingAndSortingRepository.findAll(pageable);
		results.forEach(r-> System.out.println(r.getName()));
	}

	//Ques 9:Create and use finder to find Employee by Name
	@Test
	public void testFindByName(){
		List<Employee> employees = employeeRepository.findByName("Harsh Yadav");
		employees.forEach(e -> System.out.println(e.getName()));
	}

	// Ques 10 :Create and use finder to find Employees starting with A character
	@Test
	public void testFindByNameLike(){
		List<Employee> employees = employeeRepository.findByNameLike("%h%");
		employees.forEach(e -> System.out.println(e.getName()));
	}

	//Ques 11: Create and use finder to find Employees Between the age of 28 to 32
	@Test
	public void testFindByAgeBetween(){
		List<Employee> employees = employeeRepository.findByAgeBetween(28,32);
		employees.forEach(e -> System.out.println(e.getName()));
	}
}
