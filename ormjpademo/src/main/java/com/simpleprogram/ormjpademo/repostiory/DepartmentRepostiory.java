package com.simpleprogram.ormjpademo.repostiory;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simpleprogram.ormjpademo.models.Employee;

import jakarta.transaction.Transactional;
@Repository
@Transactional
public interface DepartmentRepostiory extends JpaRepository<Employee, Integer> {
	 List<Employee>findById(int id);
	//Optional<Employee>findByDepartmentDeptname(String deptname);
 // @Query(value="select * e from employee e left join department d on e.deptid=d.deptid where depttname="
		 // ,nativeQuery = true)
 // List<Department> findByEmployeedeptid();
  
}
