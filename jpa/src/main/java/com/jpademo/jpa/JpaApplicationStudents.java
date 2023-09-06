package com.jpademo.jpa;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpademo.jpa.jparepository.StudentsDetailsRepository;
import com.jpademo.jpa.models.StudentsDetails;
import com.jpademo.jpa.models.StudentsPrimarykey;
@SpringBootApplication
public class JpaApplicationStudents implements CommandLineRunner {
	@Autowired
	StudentsDetailsRepository stDRtory;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(JpaApplicationStudents.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Enter your choice \n"+"1.findAll \n"+"2.update \n"+"3.insert \n"+"4.orderby \n"+"5.markgreatethan \n"+"6.MarkLessThan \n"+"7.topscore \n");
		Scanner sc =new Scanner(System.in);
		int choice=sc.nextInt();
		switch(choice) {
		case 1:System.out.println("findby all StudentsdetailsAll");
		Optional<StudentsDetails> op= stDRtory.findById(new StudentsPrimarykey(121,5555));
		if(op.isPresent())
		{
			StudentsDetails st=op.get();
			System.out.println(st);
		}else {
			System.out.println("does not exit");
		}
		break ;
		case 2:System.out.println("enter a stuid to update");
		int studid=sc.nextInt();
		System.out.println("enter a courseid to update");
		int courseid=sc.nextInt();
		Optional<StudentsDetails> ss=stDRtory.findById(new StudentsPrimarykey(studid,courseid));
		if(ss.isPresent())
		{
			StudentsDetails stdmark=ss.get();
			System.out.println("enter your unchoice");
			System.out.println("1.mark");
			int unchoice =sc.nextInt();
			switch(unchoice)
			{
			case 1:System.out.println("enter your mark");
			sc.nextLine();
			int mark=sc.nextInt();
			stdmark.setMark(mark);
			stDRtory.save(stdmark);
			break;
			}
			
			
		}
		break;
		case 3:System.out.println("enter a studid");
		 studid=sc.nextInt();
		System.out.println("enter a courseis");
		courseid=sc.nextInt();
		System.out.println("enter a mark");
		int mark=sc.nextInt();
		StudentsDetails SD =new StudentsDetails(studid,courseid,mark);
		stDRtory.save(SD);
		break;
		case 4:System.out.println("orderbyasc");
		stDRtory.findFirst2ByOrderByMarkAsc().forEach(System.out::println);
		break;
		case 5:System.out.println("markGreaterThan");
		stDRtory.findByMarkGreaterThan(98).forEach(System.out::println);
		break;
		case 6:System.out.println("markLessThan");
		stDRtory.findByMarkLessThan(100).forEach(System.out::println);
		break;
		case 7:System.out.println("topScoreMark");
		stDRtory.findTopScoreStudents().forEach(System.out::println);
		break;
		
		}
		
	}

}
