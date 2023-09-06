package com.jpademo.jpa.jparepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpademo.jpa.models.Person;

import jakarta.transaction.Transactional;
@Repository
@Transactional
public interface PersonJpaRepository extends JpaRepository<Person,Integer> {
	List<Person> findByFirstname(String firstname);
	List<Person>findByLastname(String lastname);
	List<Person>findAllByOrderByFirstnameAsc();
List<Person>findByEmailContainsIgnoreCase(String email);
List<Person>findByAddressCityIgnoreCase(String city);

}
