package com.example.JPAAssignment3;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.*;

@SpringBootTest
class JpaAssignment3ApplicationTests {

	@Autowired
	AuthorRepository authorRepository;

	@Test
	void contextLoads() {
	}

	//Ques 4: Persist 3 subjects for each author.
	@Test
	public void testAuthor(){
		Author author = new Author();
		author.setAuthorname("Kshitiz Gupta");

		Address address = new Address();
		address.setStreetNumber("D-321");
		address.setLocation("Greater Noida");
		address.setState("U.P");

		author.setAddress(address);

		Subject subject1 = new Subject();
		subject1.setSubjectName("English");
		subject1.setAuthor(author);

		Subject subject2 = new Subject();
		subject2.setSubjectName("Maths");
		subject2.setAuthor(author);

		Subject subject3 = new Subject();
		subject3.setSubjectName("Science");
		subject3.setAuthor(author);

		author.addSubject(subject1);
		author.addSubject(subject2);
		author.addSubject(subject3);
		authorRepository.save(author);
	}
	//Output:
	// +----------+---------------+--------------+---------------+-------+
	//| authorid | authorname    | streetnumber | location      | state |
	//+----------+---------------+--------------+---------------+-------+
	//|        1 | Harsh Yadav   | C-451        | Greater Noida | U.P   |
	//|        2 | Harsh Yadav   | C-451        | Greater Noida | U.P   |
	//|        3 | Kshitiz Gupta | D-321        | Greater Noida | U.P   |
	//
	//+-----------+-------------+-----------+
	//| subjectid | subjectname | author_id |
	//+-----------+-------------+-----------+
	//|         1 | English     |         1 |
	//|         2 | Maths       |         1 |
	//|         3 | Science     |         1 |
	//|         4 | English     |         2 |
	//|         5 | Maths       |         2 |
	//|         6 | Science     |         2 |
	//|         7 | English     |         3 |
	//|         8 | Maths       |         3 |
	//|         9 | Science     |         3 |
	//+-----------+-------------+-----------+

	@Test
	public void testLoadAuthor(){
		Optional<Author> optional =authorRepository.findById(1);
		Author author = optional.get();
		System.out.println(author.getAuthorname());
		List<Subject> list  = author.getList();
		list.forEach(s-> System.out.println(s.getSubjectName()));

	}
	@Test
	public void testOneToOne(){
		Author author = new Author();
		author.setAuthorname("Smarth Vaish");

		Book book = new Book();
		book.setBookName("TO THE NEW");
		author.addBook(book);

		Address address = new Address();
		address.setStreetNumber("New Street Number");
		address.setLocation("New Location");
		address.setState("New State");
		author.setAddress(address);

		Subject subject = new Subject();
		subject.setSubjectName("New Subject");
		author.addSubject(subject);

		authorRepository.save(author);
	}
}
