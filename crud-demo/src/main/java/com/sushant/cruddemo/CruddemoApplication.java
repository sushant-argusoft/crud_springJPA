package com.sushant.cruddemo;

import com.sushant.cruddemo.dao.StudentDAO;
import com.sushant.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner->{
			//createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//updateStudent(studentDAO);
			deleteStudent(studentDAO);
		};
	}
	private  void deleteStudent(StudentDAO studentDAO){

		int studentId = 3;
		System.out.println("Deleting student id:"+ studentId);
		studentDAO.delete(studentId);

	}


	private void updateStudent(StudentDAO studentDAO){
		//retrieve student based on id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: "+studentId);

		Student myStudent = studentDAO.findById(studentId);
		System.out.println("Updating Student....");
		// change first name to "Scooby"
		myStudent.setFirstName("Scooby");
		studentDAO.update(myStudent);
		System.out.println("Updated student:"+ myStudent);
	}

	public void queryForStudents(StudentDAO studentDAO){
		List<Student> theStudents = studentDAO.findAll();
		for(var temp : theStudents){
			System.out.println(temp);
		}
	}
	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student ( "Daffy",  "Duck" , "daffy@luv2code.com");
	// save the student
			System.out.println("Saving the student ...");
			studentDAO.save (tempStudent);
	// display id of the saved student
			int theId = tempStudent.getId();
			System.out.println("Saved student. Generated id:" + theId);
	// retrieve student based on the id: primary key
		System.out.println("Retrieving student with id :"+theId);
        Student mystudent = studentDAO.findById(theId);


	// display student
		System.out.println("Found "+ mystudent.toString());


	}

	private void createMultipleStudents (StudentDAO studentDAO) {
// create multiple students
		System.out.println("Creating 3 student objects ...");
		Student tempStudent1 = new Student (  "John", "Doe", "john@luv2code.com");
		Student tempStudent2 = new Student (  "Mary",  "Public",  "mary@luv2code.com");
		Student tempStudent3 = new Student ( "Bonita",  "Applebum",  "bonita@luv2code.com");
// save the student objects
		System.out.println("Saving the students .. ");
		studentDAO.save (tempStudent1);
		studentDAO.save (tempStudent2);
		studentDAO.save (tempStudent3) ;
	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating....");
		Student tempStudent = new Student("Sushant","Sharma","ssharma@argusoft.com");

		//save the student object
		System.out.println("Saving....");
		studentDAO.save(tempStudent);


		//display id of saved student
		System.out.println("Generated Id" + tempStudent.getId());


	}

}
