package ru.max.Pract_16;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import ru.max.Pract_16.entity.Group;
import ru.max.Pract_16.entity.Student;
import ru.max.Pract_16.repository.StudentRepository;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Pract16Application {

	public static void main(String[] args) {
		SpringApplication.run(Pract16Application.class, args);
	}

}
