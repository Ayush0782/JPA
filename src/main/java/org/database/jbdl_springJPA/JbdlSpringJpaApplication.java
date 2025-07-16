package org.database.jbdl_springJPA;

import org.database.jbdl_springJPA.model.Student;
import org.database.jbdl_springJPA.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JbdlSpringJpaApplication implements CommandLineRunner {

	@Autowired
	StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(JbdlSpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student student = new Student();

		student.setName("Ayush");
		student.setEmail("Ayush123@gmail");

		//For Saving the data
		//studentRepository.save(student);
		//System.out.println("Data Saved");

		//For Fetching the Data
		// Student data = studentRepository.findById(1).get();
		 //System.out.println(data);

		//For Deleting
		studentRepository.deleteById(1);

		 Student data = studentRepository.findByEmailAndNameCustomQuery("Ayush" , "Ayush123@gmail");
		 System.out.println(data);

		 studentRepository.updateByEmail(1,"Ayush123@gmsil");


	}
}
