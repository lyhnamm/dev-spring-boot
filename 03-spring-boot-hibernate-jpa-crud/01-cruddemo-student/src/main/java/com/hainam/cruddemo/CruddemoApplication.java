package com.hainam.cruddemo;

import com.hainam.cruddemo.dao.StudentDAO;
import com.hainam.cruddemo.model.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);
//			readStudent(studentDAO);
//			queryAllStudent(studentDAO);
//			queryStudentByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
			deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleting all students ... ");
		System.out.println("Deleted row count: " + studentDAO.deleteAll());
	}

	private void deleteStudent(StudentDAO studentDAO) {
		// get Student by id
		int id = 3;

		// delete
		System.out.println("Deleting student ...");
		studentDAO.delete(id);

		// display
		System.out.println("Deleted student");
	}

	private void updateStudent(StudentDAO studentDAO) {
		// get student by id
		int studentId = 1;
		Student student = studentDAO.findById(studentId);

		// Update student
		student.setFirstName("Nam");
		studentDAO.update(student);

		// display
		System.out.println(student);
	}

	private void queryStudentByLastName(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("doe");

		// display list students
		for (Student student : theStudents) {
			System.out.println(student);
		}
	}

	private void queryAllStudent(StudentDAO studentDAO) {
		// get list student
		List<Student> theStudents = studentDAO.findAll();

		// display list student
		for (Student student : theStudents) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create new Student object
		Student tmpStudent = new Student("John", "Doe", "john.doe@gmail.com");
		// Save student object
		studentDAO.save(tmpStudent);
		// Get id of saved student
		System.out.println("Student Id: " + tmpStudent.getId());
		// Retrieve student based on id
		Student student = studentDAO.findById(tmpStudent.getId());
		// Display the Student
		System.out.println(student);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new Student object ...");
		Student student = new Student("Nam", "Le", "namlh38@viettel.com.vn");

		System.out.println("Saving Student object ...");
		studentDAO.save(student);
		System.out.println("Student object created");

		System.out.println("Get student Id: " + student.getId());
	}
}
