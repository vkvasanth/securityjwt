package com.simpleprogram.ormjpademo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.simpleprogram.ormjpademo.dao.DepartmentDao;
import com.simpleprogram.ormjpademo.models.Department;
import com.simpleprogram.ormjpademo.models.Employee;
@SpringBootApplication
public class DepartmentEmployeeApplication implements CommandLineRunner {
	@Autowired
              DepartmentDao deptdao;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(DepartmentEmployeeApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	System.out.println("enter your choice \n"+"1.insert \n"+"2.find deptid \n"+"3.delete \n"+"4.update \n"+"5.salary \n");
	Scanner sc=new Scanner(System.in);
	int choice=sc.nextInt();
	switch(choice)
	{
	case 1:
		Department department=new Department("TRANING","madurai");
		List<Employee> emp=new ArrayList<Employee>();
		emp.add(new Employee("Riya","Riya33@gmail.com",department,20000,23));
		emp.add(new Employee("Vijay","Vijay22@gmail.com",department,33000,25));
		department.setEmployees(emp);
		deptdao.saveDepartment(department);
		break;
	case 2:
		System.out.println("enter a deptid");
		int deptid=sc.nextInt();
		Department dept1=deptdao.getDepartment(deptid);
		System.out.println(dept1.getDeptname()+" "+dept1.getLocation());
		List<Employee> emps=dept1.getEmployees();
		System.out.println(emps);
		break;
	case 3:
		System.out.println("Enter Department id");
		int did=sc.nextInt();
		deptdao.deleteDepartment(did);
		break;
	case 4:
		System.out.println("Updating employee's department");
		System.out.println("Enter the Employee id");
		int eid=sc.nextInt();
		Employee d=deptdao.getEmployee(eid);
				System.out.println("enter a department id");
		 deptid=sc.nextInt();
		
			dept1=deptdao.getDepartment(deptid);
			d.setDepartment(dept1);
			deptdao.updateEmployee(d);
			break;
			
	case 5:System.out.println("enter salary");
	double sal=sc.nextDouble();
	List<Employee> es=deptdao.getEmployeesBySalary(sal);
	for(Employee e:es)
			System.out.println(e);
	break;
	
	case 6:System.out.println("enter  age");
	int age =sc.nextInt();
	List<Employee> ed=deptdao.getEmployeeByAge(age);
	System.out.println(ed);
	case 7:
		System.out.println("Enter department id");
		int dept_id=sc.nextInt();
		List<Employee> er =deptdao.getEmployeeByDept(dept_id);
		for(Employee eo:er) 
			System.out.println(eo);
		break;

		
	
	}
		
	}
		
	}


