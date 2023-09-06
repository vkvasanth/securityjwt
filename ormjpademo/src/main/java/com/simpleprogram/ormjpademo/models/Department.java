package com.simpleprogram.ormjpademo.models;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="department_33")
@OnDelete(action=OnDeleteAction.SET_NULL)
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String deptname;
private String location;
@OneToMany(mappedBy="department",cascade = CascadeType.PERSIST,fetch= FetchType.EAGER)
private List<Employee> employees;
public Department(String deptname, String location) {
	super();
	this.deptname = deptname;
	this.location = location;
}
public Department(String deptname, String location, List<Employee> employees) {
	super();
	this.deptname = deptname;
	this.location = location;
	this.employees = employees;
}
public Department()
{
	
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getDeptname() {
	return deptname;
}
public void setDeptname(String deptname) {
	this.deptname = deptname;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public List<Employee> getEmployees() {
	return employees;
}
public void setEmployees(List<Employee> employees) {
	this.employees = employees;
}
@Override
public String toString() {
	return "Department [id=" + id + ", deptname=" + deptname + ", location=" + location + ", employees=" + employees
			+ "]";
}

}
