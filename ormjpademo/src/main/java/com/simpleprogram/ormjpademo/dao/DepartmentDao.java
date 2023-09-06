package com.simpleprogram.ormjpademo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.simpleprogram.ormjpademo.models.Department;
import com.simpleprogram.ormjpademo.models.Employee;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class DepartmentDao {
	@PersistenceContext
	private EntityManager em;
	public Department saveDepartment(Department department)
	{
		em.persist(department);
		return department;
		
	}
public Department getDepartment(int id)
{
	Department dept=em.find(Department.class, id);
	return dept;
	
}
public Employee getEmployee(int id)
{
	Employee dept1=em.find(Employee.class, id);
	return dept1;
	
}

public void updateEmployee(Employee employee)
{
	em.merge(employee);
}
public void deleteDepartment(int id)
{
	Department dept=em.find(Department.class, id);
	List<Employee> employees=dept.getEmployees();
	for(Employee emp:employees) {
		emp.setDepartment(dept);
	em.merge(emp);
	}
			

	em.remove(dept);
}
/*
public void updateEmployee(Employee emp)
{
	em.merge(emp);
}
*/

public Employee setEmployee(int id) {
	return em.find(Employee.class,id);
}
public List<Employee> getEmployeesBySalary(double salary)
{
	Query query=em.createNamedQuery("filterEmpBasedOnsalary");
	query.setParameter("sal", salary);
	return query.getResultList();
}
public List<Employee> getEmployeeByAge(int age)
{
	Query query=em.createNamedQuery("filterbyeAge");
	query.setParameter("age", age);
	return query.getResultList();
}
public List<Employee> getEmployeeByDept(int id)
{
	Query query=em.createNamedQuery("findbyeAge");
	query.setParameter("deptid", id);
	return query.getResultList();
}
}

