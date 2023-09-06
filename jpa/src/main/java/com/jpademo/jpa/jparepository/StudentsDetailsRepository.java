package com.jpademo.jpa.jparepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jpademo.jpa.models.StudentsDetails;
import com.jpademo.jpa.models.StudentsPrimarykey;

import jakarta.transaction.Transactional;
@Repository
@Transactional
public interface StudentsDetailsRepository extends JpaRepository<StudentsDetails, StudentsPrimarykey> {
List<StudentsDetails>findFirst2ByOrderByMarkAsc();
List<StudentsDetails>findByMarkGreaterThan(int value);
List<StudentsDetails>findByMarkLessThan(int value);
@Query(value="select * from students_details where mark=(select max(mark) from students_details)"
,nativeQuery=true)

List<StudentsDetails>findTopScoreStudents ();
}
