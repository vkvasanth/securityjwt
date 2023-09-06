package com.simpleprogram.ormjpademo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
@NamedQueries({
             @NamedQuery(name="firstEmployeeOnsalary",query="select e from Employee e where e.salary>=:sal"),
      @NamedQuery(name="filterByAge",query="select e from Employee e where e.age>=age"),
@NamedQuery(name="findEmployeesByDept",query="select e from Employee e where e.department.id=:deptid")
})
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String email;
	private double salary;
	private int age;
	@ManyToOne
	@JoinColumn(name="dept_id")
	
	private Department department;
	public Employee()
	{
		
	}
	public Employee(String name, String email, Department department,double salary,int age) {
		super();
		this.name = name;
		this.email = email;
		this.department = department;
		this.age=age;
		this.salary=salary;
	}
	
	public double getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", department=" + department + "]";
	}
	

}
