package com.example.JPAWithHibernatePart2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@SpringBootTest
class JpaWithHibernatePart2ApplicationTests {
	@Autowired
	employeeRepository repository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createEmployee() {
		Employee employee = new Employee();
		employee.setId(4045);
		employee.setFirstName("Ashish");
		employee.setLastName("pal");
		employee.setSalary(20000);
		employee.setAge(60);
		repository.save(employee);
		System.out.println("Value Updated==================");
	}
	@Test
	public void findAllEmployee(){
		Pageable pageable = PageRequest.of(0,2);
		List<Employee> employees = (List<Employee>) repository.findAll();
		employees.forEach(e-> System.out.println(e));

	}

	//Ques 1: Display the first name, last name of all employees having salary greater than average salary ordered in ascending by their age and in descending by their salary.
	@Test
	public void findfirstNameAndlastName() {
		Sort sort = Sort.by(Sort.Order.asc("age"),Sort.Order.desc("salary"));
		Pageable pageable = PageRequest.of(0,2,sort);
		List<Object[]> employees = repository.findfirstNameAndlastName((PageRequest) pageable);
		for (Object[] objects : employees) {
			System.out.println(objects[0]+" ");
			System.out.println(objects[1]+" ");
		}
	}

	//Output:
	// +--------+---------------+--------------+------------+---------+
	//| emp_id | emp_firstname | emp_lastname | emp_salary | emp_age |
	//+--------+---------------+--------------+------------+---------+
	//|   4040 | Kshitiz       | Gupta        |      22750 |      22 |
	//|   4041 | Harsh         | Yadav        |      15000 |      21 |
	//+--------+---------------+--------------+------------+---------+

	//Ques 2:Update salary of all employees by a salary passed as a parameter whose existing salary is less than the average salary.
	@Test
	@Rollback(value = false)
	public void updateSalary(){
		Integer agvsalary = repository.findAvarageSalary();
		repository.updateSalary(agvsalary,12000);
	}
	//Output:
	// +--------+---------------+--------------+------------+---------+
	//| emp_id | emp_firstname | emp_lastname | emp_salary | emp_age |
	//+--------+---------------+--------------+------------+---------+
	//|   4040 | Kshitiz       | Gupta        |      22750 |      22 |
	//|   4041 | Harsh         | Yadav        |      12000 |      21 |
	//+--------+---------------+--------------+------------+---------+

	//Ques 3:Delete all employees with minimum salary.
	@Test
	@Rollback(value = false)
	public void delete(){
		Integer result = repository.findMinSalary();
		repository.deleteEmployee(result);
	}
	//Output:
	// +--------+---------------+--------------+------------+---------+
	//| emp_id | emp_firstname | emp_lastname | emp_salary | emp_age |
	//+--------+---------------+--------------+------------+---------+
	//|   4040 | Kshitiz       | Gupta        |      22750 |      22 |
	//+--------+---------------+--------------+------------+---------+

	//Ques 4:Display the id, first name, age of all employees where last name ends with "singh"
	@Test
	public void selectEmployeeDetailsUsingNative(){
		List<Employee> list =repository.selectUsingNative();
		list.forEach(e-> System.out.println(e));
	}

	//Ques 5:Delete all employees with age greater than 45(Should be passed as a parameter)
	@Test
	public void deleteUsingNative(){
		repository.deleteEmployeeUsingNative(54);
	}
	//Output:BEFORE
	// +--------+---------------+--------------+------------+---------+
	//| emp_id | emp_firstname | emp_lastname | emp_salary | emp_age |
	//+--------+---------------+--------------+------------+---------+
	//|   4040 | Kshitiz       | Gupta        |      22750 |      22 |
	//|   4041 | Harsh         | Yadav        |      15000 |      21 |
	//|   4042 | Ashutosh      | singh        |      51000 |      21 |
	//|   4044 | Abhishek      | singh        |      20000 |      21 |
	//|   4045 | Ashish        | pal          |      20000 |      60 |
	//+--------+---------------+--------------+------------+---------+
	//AFTER
	// +--------+---------------+--------------+------------+---------+
	//| emp_id | emp_firstname | emp_lastname | emp_salary | emp_age |
	//+--------+---------------+--------------+------------+---------+
	//|   4040 | Kshitiz       | Gupta        |      22750 |      22 |
	//|   4041 | Harsh         | Yadav        |      15000 |      21 |
	//|   4042 | Ashutosh      | singh        |      51000 |      21 |
	//|   4044 | Abhishek      | singh        |      20000 |      21 |
	//+--------+---------------+--------------+------------+---------+

}

