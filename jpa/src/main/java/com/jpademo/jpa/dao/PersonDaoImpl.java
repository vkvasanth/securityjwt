package com.jpademo.jpa.dao;

import org.springframework.stereotype.Repository;

import com.jpademo.jpa.models.Person;
import com.jpademo.jpa.models.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class PersonDaoImpl {
	@PersistenceContext
	private EntityManager em;
	public PersonDaoImpl()
	{
		System.out.println(".>>>>>>>>>>>>>>>>vasanth>>>>>>>>>>>>>>>");
	}
	public Person savePerson(Person p) {
		em.persist(p);
		return p;
	}
	public Person getPerson(int id)
	{
		Person person=em.find(Person.class,id);
		return person;
	}
	public void updatePerson(Person person)
	
	{
		
		em.merge(person);
	}
		
	public void deletePerson(int deleteid)
	{
		Person p=em.find(Person.class,deleteid);
		em.remove(p);
	}

}
