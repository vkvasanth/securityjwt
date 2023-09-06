package com.jpaPractice;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpaPractice.booksmodels.Book;
import com.jpaPractice.dao.BookDaoImpl;
@SpringBootApplication

public class JpaApplication implements CommandLineRunner {
	@Autowired
	 BookDaoImpl bookDao;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			SpringApplication.run(JpaApplication.class, args);
		

	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	 /* int Bookid=bookDao.saveBook(new Book("mathsbook",100));
	System.out.println("generated a bid"+Bookid);
	Book book=bookDao.getBook(2);
	System.out.println("book isbookDao"+book);
	*/
	/*Book updateBookprice=bookDao.updateBookprice(52, 200);
	*///	System.out.println(updateBookprice);
	List<Book> books=bookDao.getAllBooks();
	for(Book bk:books)
		System.out.println(bk);
		
		//bookDao.deleteBook(102);
		
	}

}
