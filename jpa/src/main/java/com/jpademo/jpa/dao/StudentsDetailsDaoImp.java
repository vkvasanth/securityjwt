package com.jpademo.jpa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jpademo.jpa.models.StudentsDetails;
import com.jpademo.jpa.models.StudentsPrimarykey;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class StudentsDetailsDaoImp {
	@PersistenceContext
	private EntityManager em;
	public void saveStudents(StudentsDetails sd)
	{
		em.persist(sd);
	}
	public StudentsDetails getStudentsDetails(int studid,int courseid )
	{
		StudentsDetails sd= em.find(StudentsDetails.class, new StudentsPrimarykey(studid,courseid));
		return sd;
		
	}

	public  StudentsDetails updateStudentsDetails(int studid,int courseid,int updatemark)
	{
		StudentsDetails sd=em.find(StudentsDetails.class, new StudentsPrimarykey(studid,courseid));
		em.merge(sd);
		return sd;
	}
	public void deleteStudentsDetails(int studid,int courseid)
	{

		StudentsDetails sd=em.find(StudentsDetails.class, new StudentsPrimarykey(studid,courseid));
		em.remove(sd);
	}
	public List<StudentsDetails>getAllStudentsDetails()
	{
		Query q=em.createQuery("from StudentsDetails");
		List<StudentsDetails> l=q.getResultList();
		return l ;
		
	}
}
