package com.jpademo.jpa;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

import com.jpademo.jpa.dao.PersonDaoImpl;
import com.jpademo.jpa.dao.ProductDaoImpl;
import com.jpademo.jpa.dao.StudentsDetailsDaoImp;
import com.jpademo.jpa.models.Address;
import com.jpademo.jpa.models.Person;
import com.jpademo.jpa.models.Product;
import com.jpademo.jpa.models.StudentsDetails;
import com.jpademo.jpa.models.StudentsPrimarykey;

import jakarta.persistence.Id;

//@SpringBootApplication
public class JpaApplication implements CommandLineRunner {
	@Autowired
		ProductDaoImpl productDao;
	@Autowired
	StudentsDetailsDaoImp studentsDetailsDao;
	@Autowired
	private PersonDaoImpl personDao;
	@Autowired
	ApplicationContext context;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}
	public Person savePerson(Person p) {
		p=personDao.savePerson( p);
		return p;
		
	}
	public void updatePerson(Person p)
	{
		personDao.updatePerson(p);
	}
	public Person getPerson(int id)
	{
		return personDao.getPerson(id);
		
	}
	public void deletePerson(int id)
	{
		personDao.deletePerson(id);
	}
	@Override
	public void run(String... args) throws Exception {
		JpaApplication jpademo=context.getBean(JpaApplication.class);
		
			Scanner sc=new Scanner(System.in);
			System.out.println("1.insert,2.find,3.update,4.delete");
			int choice=sc.nextInt();
			switch (choice) {
			case 1: 
				System.out.println("Enter a first name");
				String fn=sc.nextLine();
				System.out.println("eneter a last name");
				String lo= sc.nextLine();
				System.out.println("enter your email");
				String em=sc.nextLine(); 
				System.out.println("enter your streetno");
				String sn=sc.nextLine();
				System.out.println("enter your city");
				String c=sc.nextLine();
				System.out.println("enter your country");
				String co=sc.nextLine();	
				Person p =new Person( fn,lo,em,new Address(sn,c,co));
				jpademo.savePerson(p);
				break;
			
			
				
				case 2:System.out.println("enter the person id");
				int id =sc.nextInt();
				Person person=jpademo.getPerson(id);
				if(person==null)
					System.out.println("it does not exit");
				else
					System.out.println(person);
				break;
			
			
				case 3:System.out.println("enter personid to get update");
				int personid=sc.nextInt();
				Person person1=jpademo.getPerson(personid);
				System.out.println("enter you choice");
				System.out.println("1.fn,2.ln,3.em,4.sn,5.c,6.co");
				int uchoice =sc.nextInt();
				switch (uchoice) {
				
				case 1: System.out.println("enter a first name");
				String fname=sc.nextLine();
				person1.setFirstname(fname);
				personDao.updatePerson(person1);
					break;
				
				
				case 4:System.out.println("enter the streetno" );
					
					String so=sc.nextLine();
					Address address=person1.getAddress();
					address.setStreetno(so);
					person1.setAddress(address);
					jpademo.updatePerson(person1);
					break;
				}
				break;
				case 4:System.out.println("enter a delete id");
				jpademo.deletePerson();
				
			}
				
				
					
			
			/*
		//Person p =new Persson( "aswini","vasanth","awini22@gmail.com",new Address("anna nager","bangalore","india"));
		Person p1=new Person("vasu","kumar","vasu88@gmail.com",new Address("pk nagar","chennai","india"));
		Person p2=new Person("praveen","kumar","pk99@gmail.com",new Address("niyabakam","madurai","india"));
		Person p3=new Person("sathya","vsan","sathya22@gmail.com",new Address("oooo nagar","salem","india"));
		Person p4=new Person("tamil","kumar","tamil55@gmail.com",new Address("bb nagar","chennai","india"));
		/*jpademo.savePerson(p1);
		jpademo.savePerson(p2);
		jpademo.savePerson(p3);
		jpademo.savePerson(p4);
		*/
		//Person person=jpademo.getPerson(2);
		//System.out.println(person);
		//Person updatePersonname=jpademo.updatePersonname(4,"vasu");
		
		
	/*	Person person=jpademo.getPerson(1);
		person.setFirstname("veera");
		personDao.updatePerson(person);
		
		
		
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
/*StudentsDetails sd=new StudentsDetails(121,5555,98);	
StudentsDetails sd1=new StudentsDetails(121,4444,97);
studentsDetailsDao.saveStudents(sd);
studentsDetailsDao.saveStudents(sd1);
StudentsDetails sd3=studentsDetailsDao.getStudentsDetails(121,5555);	
System.out.println(sd3);
*/
//StudentsDetails updatemark=studentsDetailsDao.updateStudentsDetails(121,5555,100);
//System.out.println(updatemark);

//studentsDetailsDao.deleteStudentsDetails(121, 4444);
/*List<StudentsDetails> studentsdetails=studentsDetailsDao.getAllStudentsDetails();
for(StudentsDetails sd:studentsdetails)
	System.out.println(sd);
	*/

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*int id=productDao .savaProduct(new Product("xyz",123.09,12)); 
		System.out.println("is generated is"+id);
		*/
		/*
		Product product=productDao.getProduct(4);
				System.out.println("Product is"+product);
				Product updatedProductname=productDao.updateProductname(2, "vasanth");
				System.out.println(updatedProductname);
				productDao.deleteProduct(2);
				*/
		/*List<Product> products =productDao.getAllProducts();
		for(Product p:products)
		System.out.println(p);
		*/
			
	}
	private void deletePerson() {
		// TODO Auto-generated method stub
		
	}

}
 