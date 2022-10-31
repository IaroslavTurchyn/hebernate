package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		userRepository.save(new User("Petro", "Ravlyk",42,"Male"));

//		userRepository.update(new User(2L,"Oksana","Zhuk",12,"Female"));
//		userRepository.update(new User(3L,"Olha","Pauk",22,"Female"));

//		userRepository.getAll().forEach(System.out::println);
//		userRepository.getByAge(18).forEach(System.out::println);

		System.out.println(userRepository.findById(2));

		System.out.println(userRepository.findByFirstName("Petro"));;
		userRepository.delete(2L);



	}


}
