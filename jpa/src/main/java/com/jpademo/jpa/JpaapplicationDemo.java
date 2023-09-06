package com.jpademo.jpa;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpademo.jpa.jparepository.PersonJpaRepository;
import com.jpademo.jpa.models.Address;
import com.jpademo.jpa.models.Person;

public class JpaapplicationDemo implements CommandLineRunner {
@Autowired
PersonJpaRepository personJapa;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(JpaapplicationDemo.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Enter your choice \n"+"1.Find All\n"+"2.Insert \n"+"3.findid\n"+"4. delete \n"+"5.find firstname \n"+"6. update \n"+"7.find lastname \n"+"8.person \n"+"9.containsignoreCase \n"+"10.person by city \n");
		Scanner sc=new Scanner(System.in);
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			List<Person> persons = personJapa.findAll();
			for(Person p:persons)
				System.out.println(p);
			break;
		case 2:
			System.out.println("enter the firstname");
			String ftn=sc.nextLine();
			System.out.println("enter the lastname");
			String lt=sc.nextLine();
			System.out.println("enter your email");
			String em=sc.nextLine(); 
			System.out.println("enter your streetno");
			String sn=sc.nextLine();
			System.out.println("enter your city");
			String c=sc.nextLine();
			System.out.println("enter your country");
			String co=sc.nextLine();	
			Person p =new Person( ftn,lt,em,new Address(sn,c,co));
			personJapa.save(p);
			break;
		case 3: System.out.println("enter the person id");
		int id =sc.nextInt();
		Optional<Person> person=personJapa.findById(id);
		if(person.isPresent())
		{
		System.out.println(person);
		}else
		{
			System.out.println("person details does not exit");
		}
		break;
		case 4:
			System.out.println("Enter delete id");
			id=sc.nextInt();
			personJapa.deleteById(id);
			break;
			
			case 5:System.out.println("Enter a firstname");
			sc.nextLine();
			String fn=sc.nextLine();
			personJapa.findByFirstname(fn).forEach(System.out::println);
				break;
			case 6:System.out.println("Enter person'd id to be update");
			 id=sc.nextInt();
			 Optional<Person> p1=personJapa.findById(id);
			 if(p1.isPresent())
			 {
				 Person p2=p1.get();
				 System.out.println("enter you choice");
					System.out.println("1.em,2.ftln,3.lt");
					int uchoice =sc.nextInt();
					switch (uchoice) {
					case 1:
						System.out.println("enter update email");
						sc.nextLine();
						String email=sc.nextLine();
						p2.setEmail(email);
						personJapa.save(p2);
						break;
					case 2: System.out.println("enter update firstname");
					sc.nextLine();
					String firstname=sc.nextLine();
					p2.setFirstname(firstname);
					personJapa.save(p2);
					break;
					case 3: System.out.println("enter update lastname");
					sc.nextLine();
					String lastname=sc.nextLine();
					p2.setFirstname(lastname);
					personJapa.save(p2);
					break;	
					}
					break;
					
			 }
			case 7:System.out.println("enter  lastname");
			sc.nextLine();
			String lastname=sc.nextLine();
			personJapa.findByLastname(lastname).forEach(System.out::println);
			break;
			case 8:System.out.println("person sorted");
			personJapa.findAllByOrderByFirstnameAsc().forEach(System.out::println);
			break;
			case 9:System.out.println("enter a ignorecase letter");
			sc.nextLine();
			String email=sc.nextLine();
			personJapa.findByEmailContainsIgnoreCase(email).forEach(System.out::println);
			break;
			case 10: System.out.println("person by city");
			List<Person> person1=personJapa.findByAddressCityIgnoreCase("chennai");
			for(Person p2:person1)
			{
				System.out.println();
			}
		}
		
	}

}
