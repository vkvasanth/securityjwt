package com.simpleprogram.ormjpademo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.simpleprogram.ormjpademo.models.Employee;
import com.simpleprogram.ormjpademo.repostiory.DepartmentRepostiory;

@SpringBootApplication
public class OrmjpademoApplication implements CommandLineRunner {
	@Autowired
	DepartmentRepostiory  departRepos;
	public static void main(String[] args) {
		SpringApplication.run(OrmjpademoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		departRepos.findById(1).forEach(System.out::println);
	}

}
