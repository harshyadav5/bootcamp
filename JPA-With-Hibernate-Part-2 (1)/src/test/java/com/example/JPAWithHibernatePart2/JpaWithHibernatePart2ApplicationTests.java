package com.example.JPAWithHibernatePart2;

import com.example.JPAWithHibernatePart2.ComponentMapping.EmployeeComponent;
import com.example.JPAWithHibernatePart2.ComponentMapping.EmployeeComponentRepository;
import com.example.JPAWithHibernatePart2.ComponentMapping.Salary;
import com.example.JPAWithHibernatePart2.Joined_Table_Strategy.CardJoined;
import com.example.JPAWithHibernatePart2.Joined_Table_Strategy.CheckJoined;
import com.example.JPAWithHibernatePart2.Joined_Table_Strategy.PaymentJoinedRepository;
import com.example.JPAWithHibernatePart2.Single_Table_Strategy.Card;
import com.example.JPAWithHibernatePart2.Single_Table_Strategy.Check;
import com.example.JPAWithHibernatePart2.Single_Table_Strategy.PaymentRepository;
import com.example.JPAWithHibernatePart2.Table_Per_Class.CardPayment;
import com.example.JPAWithHibernatePart2.Table_Per_Class.CheckPayment;
import com.example.JPAWithHibernatePart2.Table_Per_Class.PaymentRepositorys;
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
	employeeRepository employeerepository;
	@Autowired
	PaymentRepository paymentRepository;
	@Autowired
	PaymentRepositorys paymentRepositorys;
	@Autowired
	PaymentJoinedRepository paymentJoinedRepository;
	@Autowired
	EmployeeComponentRepository employeeComponentRepository;

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
		employeerepository.save(employee);
		System.out.println("Value Updated==================");
	}
	@Test
	public void findAllEmployee(){
		Pageable pageable = PageRequest.of(0,2);
		List<Employee> employees = (List<Employee>) employeerepository.findAll();
		employees.forEach(e-> System.out.println(e));

	}

	//Ques 1: Display the first name, last name of all employees having salary greater than average salary ordered in ascending by their age and in descending by their salary.
	@Test
	public void findfirstNameAndlastName() {
		Sort sort = Sort.by(Sort.Order.asc("age"),Sort.Order.desc("salary"));
		Pageable pageable = PageRequest.of(0,2,sort);
		List<Object[]> employees = employeerepository.findfirstNameAndlastName((PageRequest) pageable);
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
		Integer agvsalary = employeerepository.findAvarageSalary();
		employeerepository.updateSalary(agvsalary,12000);
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
		Integer result = employeerepository.findMinSalary();
		employeerepository.deleteEmployee(result);
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
		List<Employee> list =employeerepository.selectUsingNative();
		list.forEach(e-> System.out.println(e));
	}

	//Ques 5:Delete all employees with age greater than 45(Should be passed as a parameter)
	@Test
	public void deleteUsingNative(){
		employeerepository.deleteEmployeeUsingNative(54);
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

	//Ques 6:Implement and demonstrate Single Table strategy.
	@Test
	public void addCheckPayment(){
		Check ch = new Check();
		ch.setId(1);
		ch.setAmount(123.23);
		ch.setCheck_Number("45");
		paymentRepository.save(ch);
	}
	@Test
	public void addCardPayment(){
		Card cd = new Card();
		cd.setId(2);
		cd.setAmount(9078.65);
		cd.setCard_Number("76678998");
		paymentRepository.save(cd);
	}

	//Output:
	// +----+-------+----------+-------------+--------------+
	//| id | pmode | amount   | card_Number | check_Number |
	//+----+-------+----------+-------------+--------------+
	//|  1 | cc    |  123.230 | NULL        | 45           |
	//|  2 | cd    | 9078.650 | 76678998    | NULL         |
	//+----+-------+----------+-------------+--------------+

	//Ques 8:Implement and demonstrate Table Per Class strategy.
	@Test
	public void addCheckPaymentUsingTablePerClass(){
		CheckPayment ch = new CheckPayment();
		ch.setId(123);
		ch.setAmount(123.456);
		ch.setCheck_Number("8998");
		paymentRepositorys.save(ch);
	}
	//Output:
	// +----+-------+----------+-------------+--------------+
	//| id | pmode | amount   | card_Number | check_Number |
	//+----+-------+----------+-------------+--------------+
	//|  1 | cc    |  123.230 | NULL        | 45           |
	//|  2 | cd    | 9078.650 | 76678998    | NULL         |
	//+----+-------+----------+-------------+--------------+

	@Test
	public void addCardPaymentUsingTablePerClass(){
		CardPayment cd = new CardPayment();
		cd.setId(456);
		cd.setAmount(8787.003);
		cd.setCard_Number("9984 5687 1234");
		paymentRepositorys.save(cd);
	}
	//Output:+
	// -----+----------+----------------+
	//| id  | amount   | card_Number    |
	//+-----+----------+----------------+
	//| 456 | 8787.003 | 9984 5687 1234 |
	//+-----+----------+----------------+

	//Ques 7:Implement and demonstrate Joined strategy.
	@Test
	public void addCardPaymentUsingJoinedStrategy(){
		CardJoined cr = new CardJoined();
		cr.setId(123);
		cr.setAmount(8998.456);
		cr.setCardnumber("9889 2345 5678 7656");
		paymentJoinedRepository.save(cr);
	}
	@Test
	public void addCheckPaymentUsingJoinedStrategy(){
		CheckJoined ch = new CheckJoined();
		ch.setId(345);
		ch.setAmount(5667.45);
		ch.setChecknumber("3456 7654 2343 1234");
		paymentJoinedRepository.save(ch);
	}
	//Output:
	// +-----+----------+
	//| id  | amount   |
	//+-----+----------+
	//| 123 | 8998.456 |
	//| 345 | 5667.450 |
	//
	//+-----+----------++------+---------------------+
	//| id   | cardnumber          |
	//+------+---------------------+
	//|  123 | 9889 2345 5678 7656 |
	//+------+---------------------+
	//+------+---------------------+
	//| id   | checknumber         |
	//+------+---------------------+
	//|  345 | 3456 7654 2343 1234 |
	//+------+---------------------+

	//Ques 9:Implement and demonstrate Embedded mapping using employee table having following fields: id, firstName,
	// lastName, age,basicSalary, bonusSalary, taxAmount, specialAllowanceSalary.
	@Test
	public void testComponentMapping(){
		EmployeeComponent ec = new EmployeeComponent();
		ec.setId(4040);
		ec.setFirstname("Harsh");
		ec.setLastname("Yadav");
		ec.setAge(21);
		Salary sc = new Salary();
		sc.setBasicsalary(14568.98);
		sc.setBonussalary(1800.23);
		sc.setTaxamount(1789.98);
		sc.setSpecialallowancesalary(1243.54);
		ec.setSalary(sc);
		employeeComponentRepository.save(ec);
	}
	//Output:+
	// ------+-----------+----------+------+-------------+-------------+-----------+------------------------+
	//| id   | firstname | lastname | age  | basicsalary | bonussalary | taxamount | specialallowancesalary |
	//+------+-----------+----------+------+-------------+-------------+-----------+------------------------+
	//| 4040 | Harsh     | Yadav    |   21 |   14568.980 |    1800.230 |  1789.980 |               1243.540 |
	//+------+-----------+----------+------+-------------+-------------+-----------+------------------------+

}
